package voruti.aoc2020.puzzles;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import voruti.aoc2020.utility.Bag;

/**
 * Puzzles of day 7.
 *
 * @author voruti
 */
public class Day07 extends AbstractPuzzle {

    /**
     * Place of implementation of the first puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String firstPuzzle() {
        Set<Bag> bagSet = Arrays.stream(getInput().split("\n")).map(this::lineToBag).collect(Collectors.toSet());
        Bag.updateContainedByMaps();

        Bag shinyGold = Bag.getBagWithLabel("shiny gold");
        System.out.println(shinyGold);

        // return:
        return whereToPutBag(shinyGold).size() + "";
    }

    /**
     * Converts an input line into a {@link Bag} object.
     *
     * @param line the input line {@link String}
     * @return the generated {@link Bag} object
     */
    private Bag lineToBag(String line) {
        String[] lineSplit = line.split(" bags contain ");
        // load bag:
        Bag bag = Bag.getBagWithLabel(lineSplit[0]);

        // load contained bags:
        if (!lineSplit[1].equals("no other bags.")) {
            String[] containedBags = lineSplit[1].substring(0, lineSplit[1].length() - 1).split(", ");
            for (String containedBag : containedBags) {
                String[] parts = containedBag.split(" ");
                bag.getContainsBagMap().put(parts[1] + " " + parts[2], Integer.parseInt(parts[0]));
            }
        }

        // return:
        return bag;
    }

    /**
     * Recursive method, which returns all {@link Bag Bags} in which the first {@code bag} can be stored in (recursively).
     *
     * @param bag the {@link Bag} to test for; where it's storable
     * @return a {@link Set} of {@link Bag Bags} in which the {@code bag} is recursively storable
     */
    private Set<Bag> whereToPutBag(Bag bag) {
        Set<Bag> storingLocationSet = bag.getContainedByMap().keySet()
                .parallelStream().map(Bag::getBagWithLabel).collect(Collectors.toSet());
        for (Bag storingLocation : new HashSet<>(storingLocationSet)) {
            storingLocationSet.addAll(whereToPutBag(storingLocation));
        }

        return storingLocationSet;
    }

    /**
     * Place of implementation of the second puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String secondPuzzle() {
        Set<Bag> bagSet = Arrays.stream(getInput().split("\n")).map(this::lineToBag).collect(Collectors.toSet());

        Bag shinyGold = Bag.getBagWithLabel("shiny gold");
        System.out.println(shinyGold);

        // return:
        return whatsInsideBag(shinyGold).size() + "";
    }

    /**
     * Recursive method, which returns all {@link Bag Bags} which fit into the first {@code bag} (recursively).
     *
     * @param bag the {@link Bag} to test for; what's inside
     * @return a {@link List} of {@link Bag Bags} which are recursively inside the {@code bag}
     */
    private List<Bag> whatsInsideBag(Bag bag) {
        List<Bag> insideList = bag.getContainsBagMap().entrySet()
                .parallelStream().flatMap(e -> {
                    Bag bagInside = Bag.getBagWithLabel(e.getKey());
                    return Collections.nCopies(e.getValue(), bagInside).stream();
                }).collect(Collectors.toList());
        for (Bag oneInside : new ArrayList<>(insideList)) {
            insideList.addAll(whatsInsideBag(oneInside));
        }

        return insideList;
    }

    /**
     * Get the day of this puzzle.
     *
     * @return the day of this puzzle
     */
    public int getDay() {
        return 7;
    }
}
