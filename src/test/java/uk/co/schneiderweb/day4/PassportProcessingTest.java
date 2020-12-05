package uk.co.schneiderweb.day4;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportProcessingTest {
    @Test
    public void isPassportValidValidTest1() {
        PassportProcessing passportProcessing = new PassportProcessing();
        List<String> passport = Arrays.asList("pid:087499704","hgt:74in","ecl:grn","iyr:2012","eyr:2030","byr:1980","hcl:#623a2f");
        assertThat(passportProcessing.isPassportValid(passport), is(equalTo(true)));
    }

    @Test
    public void isPassportValidValidTest2() {
        PassportProcessing passportProcessing = new PassportProcessing();
        List<String> passport = Arrays.asList("eyr:2029","ecl:blu","cid:129","byr:1989","iyr:2014","pid:896056539","hcl:#a97842","hgt:165cm");
        assertThat(passportProcessing.isPassportValid(passport), is(equalTo(true)));
    }

    @Test
    public void isPassportValidValidTest3() {
        PassportProcessing passportProcessing = new PassportProcessing();
        List<String> passport = Arrays.asList("hcl:#888785","hgt:164cm","byr:2001","iyr:2015","cid:88","pid:545766238","ecl:hzl","eyr:2022");
        assertThat(passportProcessing.isPassportValid(passport), is(equalTo(true)));
    }

    @Test
    public void isPassportValidValidTest4() {
        PassportProcessing passportProcessing = new PassportProcessing();
        List<String> passport = Arrays.asList("iyr:2010","hgt:158cm","hcl:#b6652a","ecl:blu","byr:1944","eyr:2021","pid:093154719");
        assertThat(passportProcessing.isPassportValid(passport), is(equalTo(true)));
    }

    @Test
    public void isPassportValidInvalidTest1() {
        PassportProcessing passportProcessing = new PassportProcessing();
        List<String> passport = Arrays.asList("eyr:1972","cid:100","hcl:#18171d","ecl:amb","hgt:170","pid:186cm","iyr:2018","byr:1926");
        assertThat(passportProcessing.isPassportValid(passport), is(equalTo(false)));
    }

    @Test
    public void isPassportValidInvalidTest2() {
        PassportProcessing passportProcessing = new PassportProcessing();
        List<String> passport = Arrays.asList("iyr:2019","hcl:#602927","eyr:1967","hgt:170cm","ecl:grn","pid:012533040","byr:1946");
        assertThat(passportProcessing.isPassportValid(passport), is(equalTo(false)));
    }

    @Test
    public void isPassportValidInvalidTest3() {
        PassportProcessing passportProcessing = new PassportProcessing();
        List<String> passport = Arrays.asList("hcl:dab227","iyr:2012","ecl:brn","hgt:182cm","pid:021572410","eyr:2020","byr:1992","cid:277");
        assertThat(passportProcessing.isPassportValid(passport), is(equalTo(false)));
    }

    @Test
    public void isPassportValidInvalidTest4() {
        PassportProcessing passportProcessing = new PassportProcessing();
        List<String> passport = Arrays.asList("hgt:59cm","ecl:zzz","eyr:2038","hcl:74454a","iyr:2023","pid:3556412378","byr:2007");
        assertThat(passportProcessing.isPassportValid(passport), is(equalTo(false)));
    }

}