package uk.co.schneiderweb.day4;

import java.util.Arrays;
import java.util.List;



public class PassportProcessing {

    private List<String> requiredFields = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");

    public static void main(String[] args) {
        List<List<String>> passports = BatchPassportReader.readPassports(PassportProcessing.class.getClassLoader().getResource("day4_input"));
        PassportProcessing passportProcessing = new PassportProcessing();
        passports.stream().filter(passportProcessing::isPassportValid).forEach(System.out::println);
        System.out.println(passports.stream().filter(passportProcessing::isPassportValid).count());
    }

    public boolean isPassportValid(List<String> passport) {
        return passport.containsAll(requiredFields);
    }
}
