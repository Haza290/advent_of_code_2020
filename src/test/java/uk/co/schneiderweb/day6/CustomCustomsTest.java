package uk.co.schneiderweb.day6;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CustomCustomsTest {

    @Test
    public void sumAllUniqueCharactersTest() {
        CustomCustoms customCustoms = new CustomCustoms();
        int expectedCount = 11;
        int actualCount = customCustoms.sumAllUniqueCharacters(Arrays.asList("abc", "abc", "abac", "aaaa", "b"));
        assertThat(actualCount, is(equalTo(expectedCount)));
    }

    @Test
    public void getNumberOfUniqueCharactersTest1() {
        CustomCustoms customCustoms = new CustomCustoms();
        int expectedCount = 3;
        int actualCount = customCustoms.getNumberOfUniqueCharacters("abc");
        assertThat(actualCount, is(equalTo(expectedCount)));
    }

    @Test
    public void getNumberOfUniqueCharactersTest2() {
        CustomCustoms customCustoms = new CustomCustoms();
        int expectedCount = 3;
        int actualCount = customCustoms.getNumberOfUniqueCharacters("abcab");
        assertThat(actualCount, is(equalTo(expectedCount)));
    }

    @Test
    public void getNumberOfUniqueCharactersTest3() {
        CustomCustoms customCustoms = new CustomCustoms();
        int expectedCount = 1;
        int actualCount = customCustoms.getNumberOfUniqueCharacters("aaaaa");
        assertThat(actualCount, is(equalTo(expectedCount)));
    }

}