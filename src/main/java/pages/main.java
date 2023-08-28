package pages;

import java.io.IOException;

import static utils.JsonReader.readJsonValue;

public class main {
    public static void main(String[] args) {
        String filePath = "src/test/resources/testData/HomePageTestData.json";
        String jsonPath = "KSA.En.LITEPrice";
        try {
            String value = readJsonValue(filePath, jsonPath);
            System.out.println("Value: " + value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
