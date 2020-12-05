package uk.co.schneiderweb.day5;

import uk.co.schneiderweb.util.ReadFile;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryBoarding {

    public static void main(String[] args) {
        List<String> inputStringList = ReadFile.readStringListFromFile(BinaryBoarding.class.getClassLoader().getResource("day5_input"));
        BinaryBoarding binaryBoarding = new BinaryBoarding();
        System.out.println(inputStringList.stream().map(binaryBoarding::getSeatId).max(Integer::compare).get());

    }


    public int getSeatId(String binarySeat) {

        List<Boolean> rowBooleanList = IntStream.range(0, 7).mapToObj(i -> binarySeat.charAt(i) == 'F').collect(Collectors.toList());
        List<Boolean> columnBooleanList = IntStream.range(7, 10).mapToObj(i -> binarySeat.charAt(i) == 'L').collect(Collectors.toList());

        int row = parseBinary(rowBooleanList);
        int column = parseBinary(columnBooleanList);

        return (8*row) + column;
    }

    private int parseBinary(List<Boolean> x) {
        int lower = 0;
        int upper = (int) (Math.pow(2,x.size()) - 1);
        for (Boolean binary : x) {
            if(binary) {
                upper -= (upper- lower + 1)/2;
            } else {
                lower += (upper - lower + 1)/2;
            }
        }
        return lower;
    }
}
