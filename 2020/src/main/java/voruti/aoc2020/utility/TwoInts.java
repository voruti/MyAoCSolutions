package voruti.aoc2020.utility;

/**
 * Data structure to store two ints.
 *
 * @author voruti
 */
public class TwoInts {

    private int first;
    private int second;

    /**
     * Constructor with both ints for the data structure.
     *
     * @param first the first int
     * @param second the second int
     */
    public TwoInts(int first, int second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Get the {@link TwoInts#first} int.
     *
     * @return the first int value
     */
    public int getFirst() {
        return this.first;
    }

    /**
     * Set the {@link TwoInts#first} int.
     *
     * @param first the first int value
     * @return this instance for chaining calls
     */
    public TwoInts setFirst(int first) {
        this.first = first;
        return this;
    }

    /**
     * Get the {@link TwoInts#second} int.
     *
     * @return the second int value
     */
    public int getSecond() {
        return this.second;
    }

    /**
     * Set the {@link TwoInts#second} int.
     *
     * @param second the second int value
     * @return this instance for chaining calls
     */
    public TwoInts setSecond(int second) {
        this.second = second;
        return this;
    }
}
