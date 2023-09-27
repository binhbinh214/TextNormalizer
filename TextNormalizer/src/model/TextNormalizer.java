package model;

import java.util.regex.*;

public class TextNormalizer {

    public String normalize(String inputText) {
        // Replace multiple spaces with a single space
        inputText = inputText.replaceAll("\\s+", " ");

        // Normalize spaces after comma, dot, and colon
        inputText = inputText.replaceAll("(\\s*([,\\.:])\\s*)", "$2 ");

        // Remove spaces before and after quotes
        inputText = inputText.replaceAll("(\\s*\"(.*?)\"\\s*)", "\"$2\"");

        // Ensure the first character of the first line is uppercase
        String[] lines = inputText.split("\n");
        if (lines.length > 0) {
            lines[0] = capitalizeFirstWord(lines[0]);
            inputText = String.join("\n", lines);
        }

        // Remove blank lines
        inputText = inputText.replaceAll("(?m)^[ \t]*\r?\n", "");

        // Ensure no spaces before comma or dot
        inputText = inputText.replaceAll("\\s+([,\\.])", "$1");

        // Ensure there is a dot at the end of the text
        if (!inputText.endsWith(".")) {
            inputText += ".";
        }

        return inputText;
    }

    private String capitalizeFirstWord(String line) {
        Pattern pattern = Pattern.compile("([a-zA-Z])");
        Matcher matcher = pattern.matcher(line);

        if (matcher.find()) {
            int index = matcher.start();
            return line.substring(0, index) + line.substring(index, index + 1).toUpperCase() + line.substring(index + 1);
        }

        return line;
    }
}
