package org.dmullins.outpace;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    List<String> lines;

    public FileParser(String directory, String file) {
        Path path = Paths.get(directory, file);
        lines = getLinesInFile(path);
    }

    public List<Account> parse() {
        List<Account> accounts = new ArrayList<>();

        for (int i = 0; i < lines.size(); i+=4) {
            AccountParser parser = new AccountParser(lines.get(i), lines.get(i + 1), lines.get(i + 2));
            accounts.add(parser.parse());
        }

        return accounts;
    }

    private List<String> getLinesInFile(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
