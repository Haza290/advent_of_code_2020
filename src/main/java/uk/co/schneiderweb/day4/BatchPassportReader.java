package uk.co.schneiderweb.day4;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public class BatchPassportReader {

    public static List<List<String>> readPassports(URL fileUrl) {
        File file = new File(fileUrl.getFile());
        String content = null;
        try {
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Arrays.stream(content
                .split("\n\n"))
                .map(s -> Arrays.stream(s.split("\n| "))
                        .collect(toCollection(ArrayList::new)))
                .collect(toCollection(ArrayList::new));
    }
}
