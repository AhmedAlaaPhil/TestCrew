package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {
    public static String readJsonValue(String filePath, String jsonPath) throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(jsonString);

        String[] keys = jsonPath.split("\\.");
        JsonNode currentNode = jsonNode;
        for (String key : keys) {
            if (currentNode.isArray()) {
                int index = getIndexFromKey(key);
                if (index >= 0 && index < currentNode.size()) {
                    currentNode = currentNode.get(index);
                } else {
                    throw new IllegalArgumentException("Invalid JSON path: " + jsonPath);
                }
            } else if (currentNode.isObject()) {
                if (currentNode.has(key)) {
                    currentNode = currentNode.get(key);
                } else {
                    throw new IllegalArgumentException("Invalid JSON path: " + jsonPath);
                }
            } else {
                throw new IllegalArgumentException("Invalid JSON path: " + jsonPath);
            }
        }

        if (currentNode != null && !currentNode.isNull()) {
            return currentNode.asText();
        } else {
            throw new IllegalArgumentException("Value not found for JSON path: " + jsonPath);
        }
    }

    private static int getIndexFromKey(String key) {
        try {
            return Integer.parseInt(key);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}

