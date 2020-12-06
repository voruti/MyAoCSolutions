package voruti.aoc2020.puzzles;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

/**
 * Puzzles of day 5.
 *
 * @author voruti
 */
public class Day05 extends AbstractPuzzle {

    /**
     * Place of implementation of the first puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String firstPuzzle() {
        List<String> boardingPassList = Arrays.asList(getInput().split("\n"));
        // System.out.println("size: " + boardingPassList.size());
        // boardingPassList.sort(Comparator.naturalOrder());
        int max = -1;
        for (String boardingPass : boardingPassList) {
            int seatId = findSeatId(boardingPass);
            if (seatId > max) {
                max = seatId;
            }
        }

        // return:
        return max + "";
    }

    /**
     * Converts a boarding pass {@link String} into the proper seat id.
     *
     * @param boardingPass the boardingPass {@link String}
     * @return the seat id
     */
    private int findSeatId(String boardingPass) {
        int row = Integer.parseInt(boardingPass.substring(0, 7).replace("F", "0").replace("B", "1"), 2);
        int column = Integer.parseInt(boardingPass.substring(7, 10).replace("L", "0").replace("R", "1"), 2);
        return row * 8 + column;
    }

    /**
     * Place of implementation of the second puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String secondPuzzle() {
        List<String> boardingPassList = Arrays.asList(getInput().split("\n"));

        List<Integer> seatIdList = boardingPassList.parallelStream().map(b -> findSeatId(b)).sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        int mySeatId = -1;
        for (int i = 1; i < seatIdList.size(); i++) {
            if (seatIdList.get(i - 1) + 1 != seatIdList.get(i)) {
                mySeatId = seatIdList.get(i - 1) + 1;
                break;
            }
        }

        // return:
        return mySeatId + "";
    }

    /**
     * Get the day of this puzzle.
     *
     * @return the day of this puzzle
     */
    public int getDay() {
        return 5;
    }
}
