package voruti.aoc2020.puzzles;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Puzzles of day 1.
 *
 * @author voruti
 */
public class Day01 extends AbstractPuzzle {

    /**
     * Place of implementation of the first puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String firstPuzzle() {
        // to int list:
        List<Integer> integerList = new ArrayList<>();
        for (String s : getInput().split("[\\s\\r\\n]+")) {
            integerList.add(Integer.parseInt(s));
        }

        integerList.sort(Comparator.naturalOrder());

        int product = 0;
        outer: for (int i : integerList) {
            inner: for (int j : integerList) {
                // break loop if too high:
                /*if (i + j > 2020) {
                    break inner;
                }*/

                // check for 2020:
                if (i + j == 2020) {
                    product = i * j;
                    System.out.println(String.format("%,d", i) + " + " + String.format("%,d", j) + " = " + String.format("%,d", 2020) + "\n"
                        + String.format("%,d", i) + " * " + String.format("%,d", j) + " = " + String.format("%,d", product)
                    );
                    break outer;
                }
            }
        }

        // return:
        return product + "";
    }

    /**
     * Place of implementation of the second puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String secondPuzzle() {
        // to int list:
        List<Integer> integerList = new ArrayList<>();
        for (String s : getInput().split("[\\s\\r\\n]+")) {
            integerList.add(Integer.parseInt(s));
        }

        integerList.sort(Comparator.naturalOrder());

        int product = 0;
        outer: for (int i : integerList) {
            middle: for (int j : integerList) {
                inner: for (int h : integerList) {
                    // check for 2020:
                    if (i + j + h == 2020) {
                        product = i * j * h;
                        System.out.println(String.format("%,d", i) + " + " + String.format("%,d", j) + " + " + String.format("%,d", h) + " = " + String.format("%,d", 2020) + "\n"
                            + String.format("%,d", i) + " * " + String.format("%,d", j) + " * " + String.format("%,d", h) + " = " + String.format("%,d", product)
                        );
                        break outer;
                    }
                }
            }
        }

        // return:
        return product + "";
    }

    /**
     * Get the day of this puzzle.
     *
     * @return the day of this puzzle
     */
    public int getDay() {
        return 1;
    }
}
