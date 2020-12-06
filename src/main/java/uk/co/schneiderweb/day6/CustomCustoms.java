package uk.co.schneiderweb.day6;

import uk.co.schneiderweb.util.ReadFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomCustoms {

    public static void main(String[] args){
        List<String> inputListPart1 = ReadFile.readStringSplitFileOnBlankLinesRemovingNewlines(CustomCustoms.class.getClassLoader().getResource("day6_input"));
        List<List<String>> inputListPart2 = ReadFile.readStringSplitFileOnBlankLinesAndNewlines(CustomCustoms.class.getClassLoader().getResource("day6_input"));
        CustomCustoms customCustoms = new CustomCustoms();
        int part1Count = customCustoms.sumAllUniqueCharacters(inputListPart1);
        int part2Count = customCustoms.sumNumberOfCharactersInAllStringsList(inputListPart2);
        System.out.println("part 1: " + part1Count);
        System.out.println("part 2: " + part2Count);
    }

    public int sumAllUniqueCharacters(List<String> inputList) {
        return inputList.stream().map(this::getNumberOfUniqueCharacters).mapToInt(Integer::intValue).sum();
    }

    public int getNumberOfUniqueCharacters(String input) {
        return (int) input.chars().distinct().count();
    }

    public int getNumberOfCharactersInAllStrings(List<String> inputList) {
        Set<Integer> intersectionOfAllCharacters = new HashSet<>();
        boolean first = true;
        for (String string : inputList) {
            List<Integer> stringCharList = string.chars().boxed().collect(Collectors.toList());
            if (first) {
                intersectionOfAllCharacters.addAll(stringCharList);
                first = false;
            } else {
                intersectionOfAllCharacters.retainAll(stringCharList);
            }
        }
        return intersectionOfAllCharacters.size();
    }

    public int sumNumberOfCharactersInAllStringsList(List<List<String>> inputList) {
        return inputList.stream().map(this::getNumberOfCharactersInAllStrings).mapToInt(Integer::intValue).sum();
    }
}
