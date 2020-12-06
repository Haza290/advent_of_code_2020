package uk.co.schneiderweb.util;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

public class ReadFile {

    public static List<Integer> readIntegerListFromFile(URL fileUrl) {
        return Arrays.stream(readFile(fileUrl).split("\n")).map(s -> Integer.valueOf(s)).collect(Collectors.toList());
    }

    public static List<String> readStringListFromFile(URL fileUrl) {
        return Arrays.asList(readFile(fileUrl).split("\n"));
    }

    public static List<String> readStringSplitFileOnBlankLinesRemovingNewlines(URL fileUrl) {
        String content = readFile(fileUrl);

        return Arrays.stream(content
                .split("\n\n"))
                .map(s -> s.replace("\n", ""))
                .collect(toCollection(ArrayList::new));
    }

    public static List<List<String>> readStringSplitFileOnBlankLinesAndNewlines(URL fileUrl) {
        String content = readFile(fileUrl);

        return Arrays.stream(content.split("\n\n")).collect(toCollection(ArrayList::new)).stream().map(s -> Arrays.asList(s.split("\n"))).collect(Collectors.toList());
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
