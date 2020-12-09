package voruti.aoc2020.puzzles;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.Iterator;

/**
 * Puzzles of day 9.
 *
 * @author voruti
 */
public class Day09 extends AbstractPuzzle {

    private long invalidNumber;
    private long lastOfContiguousSet;

    /**
     * Place of implementation of the first puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String firstPuzzle() {
        List<Long> inputList = Arrays.stream(getInput().split("\n")).map(Long::parseLong).collect(Collectors.toList());

        ArrayBlockingQueue<Long> queue = new ArrayBlockingQueue(25, true);
        while (queue.remainingCapacity() != 0) {
            queue.add(inputList.remove(0));
        }

        invalidNumber = -1;
        for (Long number : inputList) {
            if (!numberValidForQueue(number, queue)) {
                invalidNumber = number;
                break;
            }

            queue.remove();
            queue.add(number);
        }

        // return:
        return invalidNumber + "";
    }

    /**
     * Tests, if the given {@code number} is valid within the context of the given {@code queue}.
     *
     * @param number the {@code long} number to test
     * @param queue the {@link Queue}{@literal <}Long{@literal >} as context for the test
     * @return true, if the {@code number} is valid, false otherwise
     */
    private boolean numberValidForQueue(long number, Queue<Long> queue) {
        // System.out.println(number + " with queue " + queue.toString());

        Iterator<Long> iterator1 = queue.iterator();
        while (iterator1.hasNext()) {
            long value1 = iterator1.next();
            Iterator<Long> iterator2 = queue.iterator();
            while (iterator2.hasNext()) {
                long value2 = iterator2.next();
                if (value1 + value2 == number && value1 != value2) {
                    // System.out.println(value1 + " and " + value2 + " match for " + number);
                    return true;
                }
                // System.out.println(value1 + " and " + value2 + " not matching for " + number);
            }
        }
        return false;
    }

    /**
     * Place of implementation of the second puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String secondPuzzle() {
        List<Long> masterInputList = Arrays.stream(getInput().split("\n")).map(Long::parseLong).collect(Collectors.toList());
        List<Long> inputList = new ArrayList<>(masterInputList);

        ArrayBlockingQueue<Long> queue = new ArrayBlockingQueue(25, true);
        while (queue.remainingCapacity() != 0) {
            queue.add(inputList.remove(0));
        }

        invalidNumber = -1;
        for (Long number : inputList) {
            if (!numberValidForQueue(number, queue)) {
                invalidNumber = number;
                break;
            }

            queue.remove();
            queue.add(number);
        }

        // find encryption weakness:
        long encryptionWeakness = -1;
        lastOfContiguousSet = -1;
        outer: while (masterInputList.size() > 1) {
            masterInputList.stream().reduce(0L, (a, b) -> {
                long sum = a + b;
                if (a != 0 && sum == invalidNumber && lastOfContiguousSet == -1) {
                    lastOfContiguousSet = b;
                }
                return sum;
            });

            if (lastOfContiguousSet != -1) {
                long min = Long.MAX_VALUE;
                long max = Long.MIN_VALUE;
                inner: for (int i = 0; i < masterInputList.size(); i++) {
                    long value = masterInputList.get(i);
                    if (value > max) {
                        max = value;
                    }
                    if (value < min) {
                        min = value;
                    }

                    if (value == lastOfContiguousSet) {
                        break inner;
                    }
                }

                encryptionWeakness = min + max;
                break outer;
            }

            masterInputList.remove(0);
        }

        // return:
        return encryptionWeakness + "";
    }

    /**
     * Get the day of this puzzle.
     *
     * @return the day of this puzzle
     */
    public int getDay() {
        return 9;
    }
}
