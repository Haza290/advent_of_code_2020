package uk.co.schneiderweb.day2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PasswordValidatorTest {

    @Test
    public void passwordValidatorTest() {

        List<String> inputArray = Arrays.asList("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc");

        PasswordValidator passwordValidator = new PasswordValidator();
        int count = passwordValidator.countValidPasswords(inputArray);
        assertThat(count, is(equalTo(2)));

    }

}