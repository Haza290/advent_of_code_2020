package uk.co.schneiderweb.day4;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportProcessingTest {

    @Test
    public void isPassportValidValidTest() {
        PassportProcessing passportProcessing = new PassportProcessing();
        List<String> passport = Arrays.asList("ecl","pid","eyr","hcl","byr","iyr","cid","hgt");
        assertThat(passportProcessing.isPassportValid(passport), is(equalTo(true)));
    }

    @Test
    public void isPassportValidInvalidTest() {
        PassportProcessing passportProcessing = new PassportProcessing();
        List<String> passport = Arrays.asList("iyr","ecl","cid","eyr","pid","hcl","byr");
        assertThat(passportProcessing.isPassportValid(passport), is(equalTo(false)));
    }

    @Test
    public void isPassportValidInvalidTest2() {
        PassportProcessing passportProcessing = new PassportProcessing();
        List<String> passport = Arrays.asList("hcl","eyr","pid","iyr","ecl","hgt");
        assertThat(passportProcessing.isPassportValid(passport), is(equalTo(false)));
    }

    @Test
    public void isPassportValidNothPoleCredentialsTest() {
        PassportProcessing passportProcessing = new PassportProcessing();
        List<String> passport = Arrays.asList("hcl","iyr","eyr","ecl","pid","byr","hgt");
        assertThat(passportProcessing.isPassportValid(passport), is(equalTo(true)));
    }
}