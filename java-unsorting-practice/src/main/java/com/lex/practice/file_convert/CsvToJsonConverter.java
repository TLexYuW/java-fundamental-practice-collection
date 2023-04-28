package com.lex.practice.file_convert;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Lex Yu
 * @version : 0.0.1
 * @date : 2023/4/28
 */
public class CsvToJsonConverter {
	public static void main(String[] args) {
		String csvFilePath = "data.csv";
		String jsonFilePath = "data.json";

		List<Map<String, String>> records = new ArrayList<>();

		// Read the CSV file
		try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
			String line;
			String[] headers = null;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				if (headers == null) {
					headers = values;
				} else {
					Map<String, String> record = new HashMap<>();
					for (int i = 0; i < headers.length; i++) {
						record.put(headers[i], values[i]);
					}
					records.add(record);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Convert the records to JSON
		Gson gson = new Gson();
		String jsonData = gson.toJson(records);

		// Write the JSON data to file
		try (FileWriter writer = new FileWriter(jsonFilePath)) {
			writer.write(jsonData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
