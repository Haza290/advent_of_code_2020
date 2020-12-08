package uk.co.schneiderweb.day7;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import uk.co.schneiderweb.util.ReadFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HandyHaversacks {

    private Set<String> bagsThatContainGold = new HashSet<String>(Arrays.asList("shiny gold"));

    public static void main(String[] args) {
        List<String> input = ReadFile.readStringListFromFile(HandyHaversacks.class.getClassLoader().getResource("day7_input"));
        HandyHaversacks handyHaversacks = new HandyHaversacks();
        System.out.println(handyHaversacks.numberOfBagsThatCanContainGold(input));
    }

    public int numberOfBagsThatCanContainGold(List<String> inputList) {
        List<Bag> bags = inputList.stream().map(this::stringToBag).collect(Collectors.toList());
        int numberOfContaingBagsFound = 0;
        while (numberOfContaingBagsFound < bagsThatContainGold.size()) {
            numberOfContaingBagsFound = bagsThatContainGold.size();
            bagsThatContainGold.addAll(bags.stream().filter(bag -> bag.containsBags(bagsThatContainGold)).map(bag -> bag.getColour()).collect(Collectors.toList()));
        }
        return bagsThatContainGold.size() - 1;
    }

    private Bag stringToBag(String bagString) {
        String[] bagStringSplit = bagString.split(" bags contain ");
        String colour = bagStringSplit[0];
        Set<String> bagsThatCanBeContained;
        if (bagStringSplit[1] == "no other bags.") {
            bagsThatCanBeContained = new HashSet<>();
        } else {
            bagsThatCanBeContained = Arrays.stream(bagStringSplit[1].split(", "))
                    .map(s -> s.substring(s.indexOf(' ') + 1, s.lastIndexOf(' ')))
                    .collect(Collectors.toSet());
        }
        return new Bag(colour, bagsThatCanBeContained);
    }

    @Data
    public class Bag {
        private final String colour;
        private final Set<String> bagsThatCanBeContained;

        public boolean containsBags(Set<String> bags) {
            return bagsThatCanBeContained.stream().anyMatch(bags::contains);
        }
    }
}
