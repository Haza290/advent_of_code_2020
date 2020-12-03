package uk.co.schneiderweb.day3;

import uk.co.schneiderweb.util.ReadFile;

import java.util.List;
import java.util.stream.IntStream;

public class TobogganTrajectory {

    public static void main(String[] args) {
        List<String> inputStringList = ReadFile.readStringListFromFile(TobogganTrajectory.class.getClassLoader().getResource("day3_input"));
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory();
        System.out.println("1:1 = " + tobogganTrajectory.countTreesInPath(inputStringList, 1, 1));
        System.out.println("3:1 = " + tobogganTrajectory.countTreesInPath(inputStringList, 3, 1));
        System.out.println("5:1 = " + tobogganTrajectory.countTreesInPath(inputStringList, 5, 1));
        System.out.println("7:1 = " + tobogganTrajectory.countTreesInPath(inputStringList, 7, 1));
        System.out.println("1:2 = " + tobogganTrajectory.countTreesInPath(inputStringList, 1, 2));
    }

    public int countTreesInPath(List<String> input, int right, int down) {
        int range = input.get(0).length();
        return (int) IntStream.range(0,input.size()).filter(i -> i % down == 0).filter(i -> input.get(i).charAt((i * right)/down % range) == '#').count();
    }
}
