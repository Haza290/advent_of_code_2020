package uk.co.schneiderweb.day3;

import uk.co.schneiderweb.util.ReadFile;

import java.util.List;
import java.util.stream.IntStream;

public class TobogganTrajectory {

    public static void main(String[] args) {
        List<String> inputStringList = ReadFile.readStringListFromFile(TobogganTrajectory.class.getClassLoader().getResource("day3_input"));
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory();
        System.out.println(tobogganTrajectory.countTreesInPath(inputStringList));
    }

    public int countTreesInPath(List<String> input) {
        int range = input.get(0).length();
        return (int) IntStream.range(0,input.size()).filter(i -> input.get(i).charAt(i*3 % range) == '#').count();
    }
}
