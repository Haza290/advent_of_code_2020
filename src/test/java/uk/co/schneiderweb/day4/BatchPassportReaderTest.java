package uk.co.schneiderweb.day4;

import org.junit.Test;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BatchPassportReaderTest {

    @Test
    public void readBatchPassportTest() {
        URL test_batch_passports_URL = BatchPassportReader.class.getClassLoader().getResource("test_batch_passports");
        List<List<String>> expectedPassports = Arrays.asList(
                Arrays.asList("eyr:1972","cid:100","hcl:#18171d","ecl:amb","hgt:170","pid:186cm","iyr:2018","byr:1926"),
                Arrays.asList("iyr:2019","hcl:#602927","eyr:1967","hgt:170cm","ecl:grn","pid:012533040","byr:1946"),
                Arrays.asList("hcl:dab227","iyr:2012","ecl:brn","hgt:182cm","pid:021572410","eyr:2020","byr:1992","cid:277"),
                Arrays.asList("hgt:59cm","ecl:zzz","eyr:2038","hcl:74454a","iyr:2023","pid:3556412378","byr:2007"),
                Arrays.asList("pid:087499704","hgt:74in","ecl:grn","iyr:2012","eyr:2030","byr:1980","hcl:#623a2f"),
                Arrays.asList("eyr:2029","ecl:blu","cid:129","byr:1989","iyr:2014","pid:896056539","hcl:#a97842","hgt:165cm"),
                Arrays.asList("hcl:#888785","hgt:164cm","byr:2001","iyr:2015","cid:88","pid:545766238","ecl:hzl","eyr:2022"),
                Arrays.asList("iyr:2010","hgt:158cm","hcl:#b6652a","ecl:blu","byr:1944","eyr:2021","pid:093154719"));
        List<List<String>> actualPassports = BatchPassportReader.readPassports(test_batch_passports_URL);
        assertThat(actualPassports, is(expectedPassports));
    }

}