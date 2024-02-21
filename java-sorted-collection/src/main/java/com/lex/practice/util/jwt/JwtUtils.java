package com.lex.practice.util.jwt;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author : Lex Yu
 */
public class JwtUtils {
	private static boolean isValidJwtFormat(String token) {
		String jwtRegex = "^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.?[A-Za-z0-9-_.+/=]*$";

		Pattern pattern = Pattern.compile(jwtRegex);
		Matcher matcher = pattern.matcher(token);

		return matcher.matches();
	}

	public static void main(String[] args) {
		String accessToken = "{{access_token}}";

		if (JwtUtils.isValidJwtFormat(accessToken)) {
			System.out.println("Valid JWT format");
		} else {
			System.out.println("Invalid JWT format");
		}
	}
}


