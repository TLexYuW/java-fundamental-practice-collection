package com.lex.practice.jackson.nodes.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.gradle.api.DefaultTask;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskAction;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author : Lex Yu
 */
public class Main extends DefaultTask {

	public static void main(String[] args) throws IOException {

		String userDir = System.getProperty("user.dir");

		String logDirectory = userDir + File.separator + "java-sorted-collection" + File.separator +
				"src" + File.separator + "main" + File.separator + "resources" + File.separator + "logs";
		String outputJsonFile = userDir + File.separator + "java-sorted-collection" + File.separator +
				"src" + File.separator + "main" + File.separator + "resources" + File.separator + "output\\merged_logs.json";

		ObjectMapper mapper = new ObjectMapper();
		ArrayNode logArray = mapper.createArrayNode();
		Path path = Paths.get(logDirectory);

		try (Stream<Path> stream1 = Files.list(path)) {
			stream1.filter(Files::isRegularFile)
//					.filter(path -> path.toString().endsWith(".log"))
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

			mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputJsonFile), logArray);
			System.out.println("Logs have been successfully written to " + outputJsonFile);

		} catch (IOException e) {
			System.err.println("Error listing files in directory: " + e.getMessage());
		}
	}

	@TaskAction
	public String getRootProjectName() {
		return getProject().getRootProject().getName();
	}
}
