package voruti.aoc2020;

import voruti.aoc2020.puzzles.AbstractPuzzle;
import voruti.aoc2020.puzzles.Day01;
import voruti.aoc2020.puzzles.Day02;
import voruti.aoc2020.puzzles.Day03;
import voruti.aoc2020.puzzles.Day04;

import java.util.Scanner;

/**
 * Creates a puzzle instance of the correct day.
 *
 * @author voruti
 */
public final class PuzzleFactory {

    /**
     * Hidden constructor.
     */
    private PuzzleFactory() {
    }

    /**
     * Creates an instance of the correct "DayXY"-class (matching {@code day}).
     *
     * @param day the day to create an instance of
     * @return an instance of the matching class
     */
    public static AbstractPuzzle createOfDay(int day) {
        AbstractPuzzle puzzle = null;
        switch (day) {
            case 1:
                puzzle = new Day01().setInput(loadInputOfDay(day));
                break;
            case 2:
                puzzle = new Day02().setInput(loadInputOfDay(day));
                break;
            case 3:
                puzzle = new Day03().setInput(loadInputOfDay(day));
                break;
            case 4:
                puzzle = new Day04().setInput(loadInputOfDay(day));
                break;

            default:
        }
        return puzzle;
    }

    /**
     * Loads the input {@link String} of the given {@code day} from a file.
     * 
     * @param day the day to load the input for
     * @return the input {@link String} of the {@code day}
     */
    private static String loadInputOfDay(int day) {
        return new Scanner(
            PuzzleFactory.class.getClassLoader().getResourceAsStream(
                "input" + String.format("%02d", day) + ".txt"
            )
        ).useDelimiter("\\A").next();
    }
}
