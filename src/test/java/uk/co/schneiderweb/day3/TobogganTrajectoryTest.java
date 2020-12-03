package uk.co.schneiderweb.day3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TobogganTrajectoryTest {

    @Test
    public void tobogganTrajectoryTest() {
        List<String> input = Arrays.asList( "..##.......",
                                            "#...#...#..",
                                            ".#....#..#.",
                                            "..#.#...#.#",
                                            ".#...##..#.",
                                            "..#.##.....",
                                            ".#.#.#....#",
                                            ".#........#",
                                            "#.##...#...",
                                            "#...##....#",
                                            ".#..#...#.#");

        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory();
        assertThat(tobogganTrajectory.countTreesInPath(input), is(equalTo(7)));

    }

}