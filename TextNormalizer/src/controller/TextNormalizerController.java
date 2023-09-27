package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.TextNormalizer;
import view.TextNormalizerView;

public class TextNormalizerController {

    private TextNormalizer model;
    private TextNormalizerView view;

    public TextNormalizerController(TextNormalizer model, TextNormalizerView view) {
        this.model = model;
        this.view = view;
    }

    public void normalizeTextFromFile(String inputFileName, String outputFileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            StringBuilder inputText = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                inputText.append(line).append("\n");
            }

            reader.close();

            String normalizedText = model.normalize(inputText.toString());

            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            writer.write(normalizedText);
            writer.close();

            view.displayOutput(normalizedText);
        } catch (IOException e) {
            System.err.println("An error occurred while reading or writing the file: " + e.getMessage());
        }
    }
}
