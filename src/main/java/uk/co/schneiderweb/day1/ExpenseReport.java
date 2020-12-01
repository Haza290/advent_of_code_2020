package uk.co.schneiderweb.day1;

import uk.co.util.ReadFile;

import java.util.List;
import java.util.Optional;

public class ExpenseReport {

    public static void main(String[] args) {
        List<Integer> inputArray = ReadFile.readIntegerListFromFile(ExpenseReport.class.getClassLoader().getResource("day1_input"));
        System.out.println("Solution for 2 elements: " + new ExpenseReport().solve(inputArray, 2));
        System.out.println("Solution for 3 elements: " + new ExpenseReport().solve(inputArray, 3));
    }

    Integer solve(List<Integer> inputArray, int elements) {
        if (elements == 2) {
            int[] result = getPairsSummingTarget(inputArray, 2020);
            return result[0] * result[1];
        }

        Integer first = inputArray.stream().filter(i -> getPairsSummingTarget(inputArray, 2020-i) != null).findAny().get();
        int[] result = getPairsSummingTarget(inputArray, 2020 - first);
        return first * result[0] * result[1];
    }

    int[] getPairsSummingTarget(List<Integer> inputArray, int target) {
        Optional<Integer> first = inputArray.stream().filter(i -> inputArray.contains(target - i)).findAny();
        if (first.isPresent()) {
            int[] result = {first.get(), target - first.get()};
            return result;
        }
        return null;
    }
}
