import javax.swing.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

public class FileInspector {

    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser("src");
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            System.out.println("Reading file: " + selectedFile.getName());
            System.out.println("-------------------------------------------------");

            try {
                List<String> lines = Files.readAllLines(selectedFile.toPath());

                for (String line : lines) {
                    System.out.println(line);
                    lineCount++;
                    wordCount += line.trim().isEmpty() ? 0 : line.trim().split("\\s+").length;
                    charCount += line.length();
                }

                System.out.println("-------------------------------------------------");
                System.out.println("Summary Report:");
                System.out.println("File Name: " + selectedFile.getName());
                System.out.println("Number of Lines: " + lineCount);
                System.out.println("Number of Words: " + wordCount);
                System.out.println("Number of Characters: " + charCount);

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
