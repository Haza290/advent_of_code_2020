package uk.co.schneiderweb.day6;

import uk.co.schneiderweb.util.ReadFile;

import java.util.List;

public class CustomCustoms {

    public static void main(String[] args){
        List<String> inputList = ReadFile.readStringSplitFileOnBlankLines(CustomCustoms.class.getClassLoader().getResource("day6_input"));
        CustomCustoms customCustoms = new CustomCustoms();
        System.out.println(customCustoms.sumAllUniqueCharacters(inputList));
    }

    public int sumAllUniqueCharacters(List<String> inputList) {
        return inputList.stream().map(this::getNumberOfUniqueCharacters).mapToInt(Integer::intValue).sum();
    }

    public int getNumberOfUniqueCharacters(String input) {
        return (int) input.chars().distinct().count();
    }
}
