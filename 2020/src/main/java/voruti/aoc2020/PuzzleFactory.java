package voruti.aoc2020;

import voruti.aoc2020.puzzles.AbstractPuzzle;
import voruti.aoc2020.puzzles.*;

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
            case 5:
                puzzle = new Day05().setInput(loadInputOfDay(day));
                break;
            case 6:
                puzzle = new Day06().setInput(loadInputOfDay(day));
                break;
            case 7:
                puzzle = new Day07().setInput(loadInputOfDay(day));
                break;
            case 8:
                puzzle = new Day08().setInput(loadInputOfDay(day));
                break;
            case 9:
                puzzle = new Day09().setInput(loadInputOfDay(day));
                break;
            case 10:
                puzzle = new Day10().setInput(loadInputOfDay(day));
                break;
            case 11:
                puzzle = new Day11().setInput(loadInputOfDay(day));
                break;
            case 12:
                puzzle = new Day12().setInput(loadInputOfDay(day));
                break;
            case 13:
                puzzle = new Day13().setInput(loadInputOfDay(day));
                break;
            case 14:
                puzzle = new Day14().setInput(loadInputOfDay(day));
                break;
            case 15:
                puzzle = new Day15().setInput(loadInputOfDay(day));
                break;
            case 16:
                puzzle = new Day16().setInput(loadInputOfDay(day));
                break;
            case 17:
                puzzle = new Day17().setInput(loadInputOfDay(day));
                break;
            case 18:
                puzzle = new Day18().setInput(loadInputOfDay(day));
                break;
            case 19:
                puzzle = new Day19().setInput(loadInputOfDay(day));
                break;
            case 20:
                puzzle = new Day20().setInput(loadInputOfDay(day));
                break;
            case 21:
                puzzle = new Day21().setInput(loadInputOfDay(day));
                break;
            case 22:
                puzzle = new Day22().setInput(loadInputOfDay(day));
                break;
            case 23:
                puzzle = new Day23().setInput(loadInputOfDay(day));
                break;
            case 24:
                puzzle = new Day24().setInput(loadInputOfDay(day));
                break;
            case 25:
                puzzle = new Day25().setInput(loadInputOfDay(day));
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
