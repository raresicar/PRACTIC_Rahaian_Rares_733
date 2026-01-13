package org.example.io;

import org.example.model.Tribut;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class TributFileWriter {

    public void writeToFile(List<Tribut> tributes, String outputFile) throws IOException {
        Path outputPath = Path.of(outputFile);
        try (BufferedWriter writer = Files.newBufferedWriter(
                outputPath,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {
            for (Tribut tribute : tributes) {
                writer.write(tribute.toString());
                writer.newLine();
            }
        }
    }
}
