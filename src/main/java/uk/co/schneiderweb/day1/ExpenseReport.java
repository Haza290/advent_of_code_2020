package uk.co.schneiderweb.day1;

import uk.co.util.ReadFile;

import java.net.URL;
import java.util.List;

public class ExpenseReport {

    public static void main(String[] args) {
        List<Integer> inputArray = ReadFile.readIntegerListFromFile(ExpenseReport.class.getClassLoader().getResource("day1_input"));
        System.out.println(new ExpenseReport().solve(inputArray));
    }

    public Integer solve(List<Integer> inputArray) {
        Integer first = inputArray.stream().filter(i -> inputArray.contains(2020 - i)).findAny().get();
        return first * (2020 - first);
    }
}
