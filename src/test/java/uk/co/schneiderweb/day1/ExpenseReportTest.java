package uk.co.schneiderweb.day1;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExpenseReportTest {

    @Test
    public void expenseReportPart1Test() {
        ExpenseReport expenseReport = new ExpenseReport();
        List<Integer> inputArray1 = Arrays.asList(1721, 979, 366, 299, 675, 1456);
        List<Integer> inputArray2 = Arrays.asList(23, 1721, 979, 366, 299, 675, 1456);
        assertThat(expenseReport.solve(inputArray1, 2), is(equalTo(514579)));
        assertThat(expenseReport.solve(inputArray2, 2), is(equalTo(514579)));
    }

    @Test
    public void expenseReportPart2Test() {

        ExpenseReport expenseReport = new ExpenseReport();
        List<Integer> inputArray1 = Arrays.asList(1721, 979, 366, 299, 675, 1456);
        assertThat(expenseReport.solve(inputArray1, 3), is(equalTo(241861950)));
    }

    @Test
    public void getPairsSummingTargetTest() {
        ExpenseReport expenseReport = new ExpenseReport();
        List<Integer> inputArray1 = Arrays.asList(1721, 979, 366, 299, 675, 1456);
        int[] expected = {1721, 299};
        assertThat(expenseReport.getPairsSummingTarget(inputArray1, 2020), is(equalTo(expected)));
    }

}