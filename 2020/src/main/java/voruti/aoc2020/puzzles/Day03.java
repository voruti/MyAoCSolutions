package voruti.aoc2020.puzzles;

import java.util.Arrays;
import java.util.List;

import voruti.aoc2020.utility.TwoInts;

/**
 * Puzzles of day 3.
 *
 * @author voruti
 */
public class Day03 extends AbstractPuzzle {

    /**
     * Place of implementation of the first puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String firstPuzzle() {
        String[] inputLines = getInput().split("\n");
        // System.out.println(inputLines[inputLines.length - 1]);
        boolean[][] trees = new boolean[inputLines.length][inputLines[0].length()];

        for (int i = 0; i < inputLines.length; i++) {
            for (int j = 0; j < inputLines[i].length(); j++) {
                trees[i][j] = inputLines[i].charAt(j) == '#';
            }
            // System.out.println(Arrays.toString(trees[i]));
        }

        int count = 0;

        int j = 0;
        for (int i = 1; i < trees.length; i++) {
            j += 3;
            if (j >= trees[i].length) {
                j -= trees[i].length;
            }

            if (trees[i][j]) {
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
        String[] inputLines = getInput().split("\n");
        // System.out.println(inputLines[inputLines.length - 1]);
        boolean[][] trees = new boolean[inputLines.length][inputLines[0].length()];

        for (int i = 0; i < inputLines.length; i++) {
            for (int j = 0; j < inputLines[i].length(); j++) {
                trees[i][j] = inputLines[i].charAt(j) == '#';
            }
            // System.out.println(Arrays.toString(trees[i]));
        }

        long finalCount = 1;

        List<TwoInts> slopes = Arrays.asList(new TwoInts[]{
            new TwoInts(1, 1),
            new TwoInts(3, 1),
            new TwoInts(5, 1),
            new TwoInts(7, 1),
            new TwoInts(1, 2)
        });
        for (TwoInts slope : slopes) {
            int count = 0;
            int j = 0;
            for (int i = slope.getSecond(); i < trees.length; i += slope.getSecond()) {
                j += slope.getFirst();
                if (j >= trees[i].length) {
                    j -= trees[i].length;
                }

                if (trees[i][j]) {
                    count++;
                }
            }

            // System.out.println(count);
            finalCount *= count;
        }

        // return:
        return finalCount + "";
    }

    /**
     * Get the day of this puzzle.
     *
     * @return the day of this puzzle
     */
    public int getDay() {
        return 3;
    }
}
