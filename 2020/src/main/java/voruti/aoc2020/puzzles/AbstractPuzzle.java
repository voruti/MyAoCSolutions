package voruti.aoc2020.puzzles;

/**
 * Abstract and template for the puzzle classes.
 *
 * @author voruti
 */
public abstract class AbstractPuzzle {

    private String input;

    /**
     * Place of implementation of the first puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public abstract String firstPuzzle();

    /**
     * Place of implementation of the second puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public abstract String secondPuzzle();

    /**
     * Get the day of this puzzle.
     *
     * @return the day of this puzzle
     */
    public abstract int getDay();

    /**
     * Get the input {@link String} of this puzzle.
     *
     * @return the input of this puzzle
     */
    public String getInput() {
        return this.input;
    }

    /**
     * Set the input {@link String} of this puzzle.
     *
     * @param input the input of this puzzle
     * @return this instance for chaining calls
     */
    public AbstractPuzzle setInput(String input) {
        this.input = input;
        return this;
    }
}
