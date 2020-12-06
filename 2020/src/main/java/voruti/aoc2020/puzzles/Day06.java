package voruti.aoc2020.puzzles;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

/**
 * Puzzles of day 6.
 *
 * @author voruti
 */
public class Day06 extends AbstractPuzzle {

    /**
     * Place of implementation of the first puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String firstPuzzle() {
        Set<String> groupSet = new HashSet<>(Arrays.asList(getInput().split("\n\n")));
        int count = 0;
        for (String group : groupSet) {
            Set<String> personSet = new HashSet<>(Arrays.asList(group.split("\n")));
            Set<Character> yesQuestionSet = new HashSet<>();
            for (String person : personSet) {
                for (int i = 0; i < person.length(); i++) {
                    yesQuestionSet.add(person.charAt(i));
                }
            }
            count += yesQuestionSet.size();
        }

        // return:
        return count + "";
    }

    /**
     * Place of implementation of the second puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String secondPuzzle() {
        Set<String> groupSet = new HashSet<>(Arrays.asList(getInput().split("\n\n")));
        int count = 0;
        for (String group : groupSet) {
            Set<String> personSet = new HashSet<>(Arrays.asList(group.split("\n")));
            Map<Character, Integer> yesQuestionMap = new HashMap<>();
            for (String person : personSet) {
                for (int i = 0; i < person.length(); i++) {
                    yesQuestionMap.put(person.charAt(i), yesQuestionMap.getOrDefault(person.charAt(i), 0) + 1);
                }
            }
            count += yesQuestionMap
                    .entrySet()
                    .parallelStream()
                    .filter(
                        e -> e.getValue() == personSet.size()
                    )
                    .count();
        }

        // return:
        return count + "";
    }

    /**
     * Get the day of this puzzle.
     *
     * @return the day of this puzzle
     */
    public int getDay() {
        return 6;
    }
}
