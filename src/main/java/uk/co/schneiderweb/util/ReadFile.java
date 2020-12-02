package uk.co.schneiderweb.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFile {

    public static List<Integer> readIntegerListFromFile(URL fileUrl) {
        return Arrays.stream(readFile(fileUrl).split("\n")).map(s -> Integer.valueOf(s)).collect(Collectors.toList());
    }

    public static List<String> readStringListFromFile(URL fileUrl) {
        return Arrays.asList(readFile(fileUrl).split("\n"));
    }

    private static String readFile(URL fileUrl) {
        File file = new File(fileUrl.getFile());
        String content = null;
        try {
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
