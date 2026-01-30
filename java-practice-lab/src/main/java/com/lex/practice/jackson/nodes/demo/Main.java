package com.lex.practice.jackson.nodes.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author : Lex Yu
 */
public class Main {

	public static void main(String[] args) throws IOException {

		String userDir = System.getProperty("user.dir");

		String logDirectory = userDir + File.separator + "src" + File.separator + "main" +
				File.separator + "resources" + File.separator + "logs";
		String outputJsonFile = userDir + File.separator + "src" + File.separator + "main" +
				File.separator + "resources" + File.separator + "output" + File.separator + "merged_logs.json";

		ObjectMapper mapper = new ObjectMapper();
		ArrayNode logArray = mapper.createArrayNode();
		Path path = Paths.get(logDirectory);

		if (!Files.exists(path)) {
			System.out.println("Log directory does not exist: " + logDirectory);
			return;
		}

		try (Stream<Path> stream1 = Files.list(path)) {
			stream1.filter(Files::isRegularFile)
					.forEach(p -> {
						try (Stream<String> stream2 = Files.lines(p)) {
							stream2.forEach(line -> {
								try {
									JsonNode logEntry = mapper.readTree(line);
									System.out.println("JsonNode = " + logEntry);
									logArray.add(logEntry);
								} catch (IOException e) {
									System.err.println("Error parsing JSON: " + e.getMessage());
								}
							});
						} catch (IOException e) {
							System.err.println("Error reading file: " + e.getMessage());
						}
					});

			// Ensure output directory exists
			Path outputPath = Paths.get(outputJsonFile).getParent();
			if (outputPath != null && !Files.exists(outputPath)) {
				Files.createDirectories(outputPath);
			}

			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputJsonFile), logArray);
			System.out.println("Logs have been successfully written to " + outputJsonFile);

		} catch (IOException e) {
			System.err.println("Error listing files in directory: " + e.getMessage());
		}
	}
}
