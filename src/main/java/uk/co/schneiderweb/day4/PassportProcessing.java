package uk.co.schneiderweb.day4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class PassportProcessing {

    private List<String> requiredFields = Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");

    public static void main(String[] args) {
        List<List<String>> passports = BatchPassportReader.readPassports(PassportProcessing.class.getClassLoader().getResource("day4_input"));
        PassportProcessing passportProcessing = new PassportProcessing();
        System.out.println(passports.stream().filter(passportProcessing::isPassportValid).count());
    }

    public boolean isPassportValid(List<String> passport) {

        if (!passport.stream().map(field -> field.substring(0,field.indexOf(":"))).collect(Collectors.toList()).containsAll(requiredFields)) { return false;}
        return passport.stream().allMatch(this::isPassportFieldValid);
    }

    private boolean isPassportFieldValid(String field) {
        String[] splitField = field.split(":");
        String fieldType = splitField[0];
        String fieldValue = splitField[1];

        switch (fieldType) {
            case "byr":
                return Integer.parseInt(fieldValue) >= 1920 && Integer.parseInt(fieldValue) <= 2002;
            case "iyr":
                return Integer.parseInt(fieldValue) >= 2010 && Integer.parseInt(fieldValue) <= 2020;
            case "eyr":
                return Integer.parseInt(fieldValue) >= 2020 && Integer.parseInt(fieldValue) <= 2030;
            case "hgt":

                switch (fieldValue.substring(fieldValue.length() - 2)) {
                    case "in":
                        int heightIn = Integer.parseInt(fieldValue.substring(0, fieldValue.length() - 2));
                        return heightIn >= 59 && heightIn <= 76;
                    case "cm":
                        int heightCm = Integer.parseInt(fieldValue.substring(0, fieldValue.length() - 2));
                        return heightCm >= 150 && heightCm <= 193;
                }
                return false;
            case "hcl":
                return fieldValue.matches("^#[0-9a-f]{6}$");
            case "ecl":
                return fieldValue.matches("amb|blu|brn|gry|grn|hzl|oth");
            case "pid":
                return fieldValue.matches("[0-9]{9}");
            case "cid":
                return true;
        }
        return false;
    }
}
