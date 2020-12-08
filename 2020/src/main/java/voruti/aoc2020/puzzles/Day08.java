package voruti.aoc2020.puzzles;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Puzzles of day 8.
 *
 * @author voruti
 */
public class Day08 extends AbstractPuzzle {

    /**
     * Place of implementation of the first puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    @SuppressWarnings("fallthrough")
    public String firstPuzzle() {
        LinkedList<String> consoleCode = new LinkedList<>(Arrays.asList(getInput().split("\n")));
        ListIterator<String> listIterator = consoleCode.listIterator(0);

        String currentInstruction = listIterator.next();
        boolean goingForward = true;
        int accumulator = 0;
        // System.out.println("new: " + listIterator.previousIndex() + ": " + currentInstruction);
        while (currentInstruction != null) {
            // System.out.println(listIterator.previousIndex() + ": " + currentInstruction);
            // System.out.println(consoleCode.toString().substring(0, 50));

            String[] instructionParts = currentInstruction.split(" ");
            switch (instructionParts[0]) {
                case "jmp":
                    int jumpCount = Integer.parseInt(instructionParts[1].substring(1, instructionParts[1].length()));
                    boolean jumpingForward = instructionParts[1].startsWith("+");
                    if (jumpingForward ^ goingForward) {
                        goingForward = !goingForward;
                        String throwAway = jumpingForward ? listIterator.next() : listIterator.previous();
                    }

                    while (jumpCount != 0) {
                        currentInstruction = jumpingForward ? listIterator.next() : listIterator.previous();
                        jumpCount--;
                    }

                    // System.out.println("new: " + (jumpingForward ? listIterator.previousIndex() : listIterator.nextIndex()) + ": " + currentInstruction);
                    break;
                case "acc":
                    accumulator += Integer.parseInt(instructionParts[1]);
                case "nop":
                    if (!goingForward) {
                        goingForward = true;
                        listIterator.next();
                    }

                    consoleCode.set(listIterator.previousIndex(), null);
                    // System.out.println("new: " + consoleCode.toString().substring(0, 150));
                    currentInstruction = listIterator.next();
                    // System.out.println("new: " + listIterator.previousIndex() + ": " + currentInstruction);
            }
        }

        // return:
        return accumulator + "";
    }

    /**
     * Place of implementation of the second puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String secondPuzzle() {
        LinkedList<String> consoleCode = new LinkedList<>(Arrays.asList(getInput().split("\n")));
        ListIterator<String> listIterator = consoleCode.listIterator(0);

        String currentInstruction = listIterator.next();
        boolean goingForward = true;
        int accumulator = 0;
        // System.out.println("new: " + listIterator.previousIndex() + ": " + currentInstruction);
        try  {
            while (true) {
                // System.out.println(listIterator.previousIndex() + ": " + currentInstruction);
                // System.out.println(consoleCode.toString().substring(0, 50));

                String[] instructionParts = currentInstruction.split(" ");
                switch (instructionParts[0]) {
                    case "jmp":
                        int jumpCount = Integer.parseInt(instructionParts[1].substring(1, instructionParts[1].length()));
                        boolean jumpingForward = instructionParts[1].startsWith("+");
                        if (jumpingForward ^ goingForward) {
                            goingForward = !goingForward;
                            String throwAway = jumpingForward ? listIterator.next() : listIterator.previous();
                        }

                        while (jumpCount != 0) {
                            currentInstruction = jumpingForward ? listIterator.next() : listIterator.previous();
                            jumpCount--;
                        }

                        // System.out.println("new: " + (jumpingForward ? listIterator.previousIndex() : listIterator.nextIndex()) + ": " + currentInstruction);
                        break;
                    case "acc":
                        accumulator += Integer.parseInt(instructionParts[1]);
                    case "nop":
                        if (!goingForward) {
                            goingForward = true;
                            listIterator.next();
                        }

                        consoleCode.set(listIterator.previousIndex(), null);
                        // System.out.println("new: " + consoleCode.toString().substring(0, 150));
                        currentInstruction = listIterator.next();
                        // System.out.println("new: " + listIterator.previousIndex() + ": " + currentInstruction);
                }
            }
        } catch (NullPointerException npe) {
            System.err.println("Loop detected!");
        } catch (NoSuchElementException nsee) {
            System.out.println("Program fixed!");
        }
        
        // return:
        return accumulator + "";
    }

    /**
     * Get the day of this puzzle.
     *
     * @return the day of this puzzle
     */
    public int getDay() {
        return 8;
    }
}
