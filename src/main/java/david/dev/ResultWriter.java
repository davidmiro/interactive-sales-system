package david.dev;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultWriter {
    public void writeResults(Map<String, Double> results, String filePath) {
        try {
            List<String> lines = results.entrySet().stream()
                    .map(entry -> entry.getKey() + ": " + entry.getValue())
                    .collect(Collectors.toList());
            Files.write(Path.of(filePath), lines);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
