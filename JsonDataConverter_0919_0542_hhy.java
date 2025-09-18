// 代码生成时间: 2025-09-19 05:42:05
package com.example.converter;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;
import java.util.Optional;

@QuarkusMain
public class JsonDataConverter implements QuarkusApplication {

    // Converts JSON string to formatted JSON string
    public static String convertToJson(String jsonData) {
        try {
            JsonReader jsonReader = Json.createReader(new StringReader(jsonData));
            JsonObject jsonObject = jsonReader.readObject();
            return jsonObject.toString();
        } catch (Exception e) {
            // Handle JSON parsing error
            return "Error parsing JSON: " + e.getMessage();
        }
    }

    @Override
    public int run(String... args) {
        // Example usage of the JSON converter
        String inputJson = "{"name": "John", "age": 30}";
        Optional<String> convertedJson = Optional.ofNullable(convertToJson(inputJson));

        if (convertedJson.isPresent()) {
            System.out.println("Converted JSON: " + convertedJson.get());
        } else {
            System.out.println("Failed to convert JSON.");
        }

        return 0;
    }

    // Main method for standalone execution
    public static void main(String... args) {
        JsonDataConverter converter = new JsonDataConverter();
        converter.run(args);
    }
}
