package uk.co.schneiderweb.day6;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void sumNumberOfCharactersInAllStringsListTest() {
        CustomCustoms customCustoms = new CustomCustoms();
        int expectedCount = 6;
        List<List<String>> inputList = Arrays.asList(
                Arrays.asList("abc"),
                Arrays.asList("a","b","c"),
                Arrays.asList("ab", "ac"),
                Arrays.asList("a", "a", "a", "a"),
                Arrays.asList("b"));
        int actualCount = customCustoms.sumNumberOfCharactersInAllStringsList(inputList);
        assertThat(actualCount, is(equalTo(expectedCount)));
    }

    @Test
    public void getNumberOfCharactersInAllStringsTest1() {
        CustomCustoms customCustoms = new CustomCustoms();
        int expectedCount = 3;
        List<String> inputList = Arrays.asList("abc");
        int actualCount = customCustoms.getNumberOfCharactersInAllStrings(inputList);
        assertThat(actualCount, is(equalTo(expectedCount)));
    }

    @Test
    public void getNumberOfCharactersInAllStringsTest2() {
        CustomCustoms customCustoms = new CustomCustoms();
        int expectedCount = 0;
        List<String> inputList = Arrays.asList("a","b","c");
        int actualCount = customCustoms.getNumberOfCharactersInAllStrings(inputList);
        assertThat(actualCount, is(equalTo(expectedCount)));
    }

    @Test
    public void getNumberOfCharactersInAllStringsTest3() {
        CustomCustoms customCustoms = new CustomCustoms();
        int expectedCount = 1;
        List<String> inputList = Arrays.asList("ab", "ac");
        int actualCount = customCustoms.getNumberOfCharactersInAllStrings(inputList);
        assertThat(actualCount, is(equalTo(expectedCount)));
    }

    @Test
    public void getNumberOfCharactersInAllStringsTest4() {
        CustomCustoms customCustoms = new CustomCustoms();
        int expectedCount = 1;
        List<String> inputList = Arrays.asList("a", "a", "a", "a");
        int actualCount = customCustoms.getNumberOfCharactersInAllStrings(inputList);
        assertThat(actualCount, is(equalTo(expectedCount)));
    }

    @Test
    public void getNumberOfCharactersInAllStringsTest5() {
        CustomCustoms customCustoms = new CustomCustoms();
        int expectedCount = 1;
        List<String> inputList = Arrays.asList("b");
        int actualCount = customCustoms.getNumberOfCharactersInAllStrings(inputList);
        assertThat(actualCount, is(equalTo(expectedCount)));
    }

}