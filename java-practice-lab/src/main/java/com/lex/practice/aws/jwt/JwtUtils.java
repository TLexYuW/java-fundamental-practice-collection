package com.lex.practice.aws.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.BadJOSEException;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.proc.SecurityContext;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.proc.BadJWTException;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;

/**
 * @author : Lex Yu
 */
public class JwtUtils {
	private static final Logger log = LoggerFactory.getLogger(JwtUtils.class);
	private static final String KID = "kid";
	private static final String ALG = "alg";
	private static final String ISS = "iss";

	//	JWKS URI：https://cognito-idp.<Region>.amazonaws.com/<userPoolId>/.well-known/jwks.json。
	private static final String JWK_URL_SUFFIX = "/.well-known/jwks.json";
	private static final int HEADER = 0;
	private static final int PAYLOAD = 1;
	private static final int SIGNATURE = 2;
	private static final int JWT_PARTS = 3;

	public static String getAccessToken(String bearerToken) {
		return bearerToken.substring(7);
	}

	public static String base64Decode(String encodedString) {
		return new String(Base64.getUrlDecoder().decode(encodedString));
	}

	public static String getHeader(String access_token) {
		return access_token.split("\\.")[HEADER];
	}

	public static String getPayload(String access_token) {
		return access_token.split("\\.")[PAYLOAD];
	}

	public static String getSignature(String access_token) {
		return access_token.split("\\.")[SIGNATURE];
	}

	public static String getTokenKeyID(Map<String, Object> header) {
		return header.get(KID).toString();
	}

	public static String getTokenAlgorithm(Map<String, ?> header) {
		return header.get(ALG).toString();
	}

	public static String getIssuerUri(Map<String, Object> payload) {
		return payload.get(ISS).toString();
	}

	public static String[] getIssuerUriPart(Map<String, Object> payload) {
		return payload.get(ISS).toString().split("/");
	}

	public static String getUserPoolIdFromIssuerURI(String[] issuer_uri_parts) {
		return issuer_uri_parts[issuer_uri_parts.length - 1];
	}

	public static String getRegionFromIssuerURI(String[] issuer_uri_parts) {
		return issuer_uri_parts[2].split("\\.")[1];
	}

	public static boolean validateJWTPartsLen(String access_token) {
		return access_token.split("\\.").length == JWT_PARTS;
	}

	public static void fetchJsonWebKeyFile(String issuer_uri,
	                                       String save_in_absolute_location,
	                                       String your_file_name) throws IOException {

		String jwk_uri = issuer_uri + JWK_URL_SUFFIX;
		Path savePath = Path.of(save_in_absolute_location + your_file_name);

		boolean fileExist = Files.exists(Paths.get(save_in_absolute_location, your_file_name));
		if (fileExist) {
			System.out.println("File already exist");
			return;
		}

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(jwk_uri, String.class);

		if (!responseEntity.getStatusCode().is2xxSuccessful()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		} else {
			try (FileOutputStream fis = new FileOutputStream(savePath.toFile());
			     BufferedOutputStream bos = new BufferedOutputStream(fis)) {
				byte[] buffer = Objects.requireNonNull(responseEntity.getBody()).getBytes();
				bos.write(buffer);
			} catch (Exception ex) {
				throw new IOException(ex);
			}
			System.out.println("Fetch JWK File successfully");
		}
	}

	public static boolean validateAwsJWT(String bearer_token, String issuer_uri, String alg)
			throws JOSEException, BadJOSEException, MalformedURLException {

		String access_token = getAccessToken(bearer_token);
		if (!validateJWTPartsLen(access_token)) {
			throw new JOSEException("JWT Parts Length Wrong");
		}

		ConfigurableJWTProcessor<SecurityContext> jwtProcessor = new DefaultJWTProcessor<>();
		JWKSource<SecurityContext> jwkSource = new RemoteJWKSet<>(new URL(issuer_uri + JWK_URL_SUFFIX));
		JWSAlgorithm jwsAlgorithm = JWSAlgorithm.parse(alg);
		JWSKeySelector<SecurityContext> keySelector = new JWSVerificationKeySelector<>(jwsAlgorithm, jwkSource);

		jwtProcessor.setJWSKeySelector(keySelector);

		try {
			JWTClaimsSet claimsSet = jwtProcessor.process(access_token, null);
			log.info("ClaimsSet = {}", claimsSet);
			return true;
		} catch (BadJWTException | ParseException e) {
			log.error(e.toString());
		}
		return false;
	}

}
