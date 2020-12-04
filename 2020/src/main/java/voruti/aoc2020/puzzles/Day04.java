package voruti.aoc2020.puzzles;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Puzzles of day 4.
 *
 * @author voruti
 */
public class Day04 extends AbstractPuzzle {

    /**
     * Place of implementation of the first puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String firstPuzzle() {
        List<String> passportList = Arrays.asList(getInput().split("\n\n"));

        int validCount = 0;

        passportList.forEach(p -> {
            List<String> fieldList = Arrays.asList(p.split("[\s\n]+"));
            Map<String, String> fieldMap = fieldListToMap(fieldList);

            if (fieldMap.get("byr", null) != null && 
                fieldMap.get("iyr", null) != null && 
                fieldMap.get("eyr", null) != null && 
                fieldMap.get("hgt", null) != null && 
                fieldMap.get("hcl", null) != null && 
                fieldMap.get("ecl", null) != null && 
                fieldMap.get("pid", null) != null) {
                validCount++;
            }
        });

        // return:
        return validCount + "";
    }
    
    /**
     * Map a {@link List} of fields to a {@link Map} of fields.
     *
     * @param fieldList the {@link List} containing the fields
     * @return the {@link Map} with the mapped values of the {@code fieldList}
     */
    private Map<String, String> fieldListToMap(List<String> fieldList) {
        Map<String, String> map = new HashMap<>();

        fieldList.forEach(f -> {
            String[] splitField = f.split(":");
            map.put(splitField[0], splitField[1]);
        });

        return map;
    }

    /**
     * Place of implementation of the second puzzle of the day.
     * Uses {@link AbstractPuzzle#input} as input source.
     *
     * @return the result of the calculation, etc.
     */
    public String secondPuzzle() {
        

        // return:
        return "";
    }

    /**
     * Get the day of this puzzle.
     *
     * @return the day of this puzzle
     */
    public int getDay() {
        return 4;
    }
}
