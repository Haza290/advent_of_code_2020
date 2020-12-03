package uk.co.schneiderweb.day3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TobogganTrajectoryTest {

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

    @Test
    public void tobogganTrajectoryRight1Down1Test() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory();
        assertThat(tobogganTrajectory.countTreesInPath(this.input, 1, 1), is(equalTo(2)));
    }

    @Test
    public void tobogganTrajectoryRight3Down1Test() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory();
        assertThat(tobogganTrajectory.countTreesInPath(this.input, 3, 1), is(equalTo(7)));
    }

    @Test
    public void tobogganTrajectoryRight5Down1Test() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory();
        assertThat(tobogganTrajectory.countTreesInPath(this.input, 5, 1), is(equalTo(3)));
    }

    @Test
    public void tobogganTrajectoryRight7Down1Test() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory();
        assertThat(tobogganTrajectory.countTreesInPath(this.input, 7, 1), is(equalTo(4)));
    }

    @Test
    public void tobogganTrajectoryRight1Down2Test() {
        TobogganTrajectory tobogganTrajectory = new TobogganTrajectory();
        assertThat(tobogganTrajectory.countTreesInPath(this.input, 1, 2), is(equalTo(2)));
    }

}