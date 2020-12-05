package uk.co.schneiderweb.day5;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BinaryBoardingTest {


    @Test
    public void getSeatIdTest1() {
        int expectedSeatId = 357;
        int actualSeatId = new BinaryBoarding().getSeatId("FBFBBFFRLR");
        assertThat(actualSeatId, is(equalTo(expectedSeatId)));
    }

    @Test
    public void getSeatIdTest2() {
        int expectedSeatId = 567;
        int actualSeatId = new BinaryBoarding().getSeatId("BFFFBBFRRR");
        assertThat(actualSeatId, is(equalTo(expectedSeatId)));
    }

    @Test
    public void getSeatIdTest3() {
        int expectedSeatId = 119;
        int actualSeatId = new BinaryBoarding().getSeatId("FFFBBBFRRR");
        assertThat(actualSeatId, is(equalTo(expectedSeatId)));
    }

    @Test
    public void getSeatIdTest4() {
        int expectedSeatId = 820;
        int actualSeatId = new BinaryBoarding().getSeatId("BBFFBBFRLL");
        assertThat(actualSeatId, is(equalTo(expectedSeatId)));
    }
}