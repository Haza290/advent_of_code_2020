package uk.co.schneiderweb.day2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test
    public void passwordValidatorPart1Test() {

        List<String> inputArray = Arrays.asList("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");
        PasswordValidator passwordValidator = new PasswordValidator();
        int count = passwordValidator.countValidPasswords(inputArray, PasswordValidator.ValidationType.CHARACTER_FREQUENCY);
        assertThat(count, is(equalTo(2)));
    }

    @Test
    public void passwordValidatorPart2Test() {

        List<String> inputArray = Arrays.asList("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");
        PasswordValidator passwordValidator = new PasswordValidator();
        int count = passwordValidator.countValidPasswords(inputArray, PasswordValidator.ValidationType.CHARACTER_POSITION);
        assertThat(count, is(equalTo(1)));
    }

}