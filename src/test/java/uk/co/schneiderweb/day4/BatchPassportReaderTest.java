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
                Arrays.asList("ecl","pid","eyr","hcl","byr","iyr","cid","hgt"),
                Arrays.asList("iyr","ecl","cid","eyr","pid","hcl","byr"),
                Arrays.asList("hcl","iyr","eyr","ecl","pid","byr","hgt"),
                Arrays.asList("hcl","eyr","pid","iyr","ecl","hgt"));
        List<List<String>> actualPassports = BatchPassportReader.readPassports(test_batch_passports_URL);
        assertThat(actualPassports, is(expectedPassports));
    }

}