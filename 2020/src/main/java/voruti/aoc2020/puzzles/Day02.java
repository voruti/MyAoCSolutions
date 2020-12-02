package voruti.aoc2020.puzzles;

import voruti.aoc2020.utility.PasswordAndPolicy;

/**
 * Puzzles of day 2.
 *
 * @author voruti
 */
public class Day02 extends AbstractPuzzle {

    /**
     * Place of implementation of the first puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String firstPuzzle() {
        int count = 0;
        for (String inputLine : getInput().split("\n")) {
            if (PasswordAndPolicy.fromInputLine(inputLine).isValidV1()) {
                count++;
            }
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
        int count = 0;
        for (String inputLine : getInput().split("\n")) {
            if (PasswordAndPolicy.fromInputLine(inputLine).isValidV2()) {
                count++;
            }
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
        return 2;
    }
}
