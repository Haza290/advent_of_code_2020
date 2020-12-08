package uk.co.schneiderweb.day7;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import uk.co.schneiderweb.util.ReadFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HandyHaversacks {

    private Set<String> bagsThatContainGold = new HashSet<String>(Arrays.asList("shiny gold"));

    public static void main(String[] args) {
        List<String> input = ReadFile.readStringListFromFile(HandyHaversacks.class.getClassLoader().getResource("day7_input"));
        HandyHaversacks handyHaversacks = new HandyHaversacks();
        System.out.println(handyHaversacks.numberOfBagsThatGoldContains(input));
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

    public int numberOfBagsThatGoldContains(List<String> inputList) {
        HashMap<String, Integer> bagsContentsHashMap = new HashMap<>();
        List<Bag> bags = inputList.stream().map(this::stringToBag).collect(Collectors.toList());

        // initialise the bagsContentsHashMap with empty bags
        bags.stream().filter(bag -> bag.getBagsThatCanBeContained().isEmpty()).forEach(bag -> bagsContentsHashMap.put(bag.getColour(),1));

        while (!bagsContentsHashMap.containsKey("shiny gold")) {
            bags.stream()
                    .filter(bag -> !bagsContentsHashMap.containsKey(bag.getColour()))
                    .filter(bag -> bagsContentsHashMap.keySet().containsAll(bag.getBagsThatCanBeContained().keySet()))
                    .forEach(bag -> bagsContentsHashMap.put(bag.getColour(), bag.getNumberOfBagsInside(bagsContentsHashMap)));
        }


        return bagsContentsHashMap.get("shiny gold") - 1;
    }

    private Bag stringToBag(String bagString) {
        String[] bagStringSplit = bagString.split(" bags contain ");
        String colour = bagStringSplit[0];
        HashMap<String, Integer> bagsThatCanBeContained;
        if (bagStringSplit[1].equals("no other bags.")) {
            bagsThatCanBeContained = new HashMap<>();
        } else {
            bagsThatCanBeContained = (HashMap<String, Integer>)Arrays.stream(bagStringSplit[1].split(", "))
                    .collect(Collectors.toMap(s -> s.substring(s.indexOf(' ') + 1, s.lastIndexOf(' ')), s -> Integer.valueOf(s.substring(0,s.indexOf(' ')))));
        }
        return new Bag(colour, bagsThatCanBeContained);
    }

    @Data
    public class Bag {
        private final String colour;
        private final HashMap<String, Integer> bagsThatCanBeContained;

        public boolean containsBags(Set<String> bags) {
            return true;//bagsThatCanBeContained.stream().anyMatch(bags::contains);
        }

        public int getNumberOfBagsInside(HashMap<String, Integer> hashMap) {
            return bagsThatCanBeContained.keySet().stream().reduce(0, (subtotal, colour) -> subtotal + bagsThatCanBeContained.get(colour) * hashMap.get(colour), Integer::sum) + 1;
        }
    }
}
