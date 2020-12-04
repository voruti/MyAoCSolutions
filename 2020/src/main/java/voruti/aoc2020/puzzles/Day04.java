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

        for (String p : passportList) {
            List<String> fieldList = Arrays.asList(p.split("[\\s\\n]+"));
            Map<String, String> fieldMap = fieldListToMap(fieldList);

            if (fieldMap.get("byr") != null
                && fieldMap.get("iyr") != null
                && fieldMap.get("eyr") != null
                && fieldMap.get("hgt") != null
                && fieldMap.get("hcl") != null
                && fieldMap.get("ecl") != null
                && fieldMap.get("pid") != null) {
                validCount++;
            }
        }

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
        List<String> passportList = Arrays.asList(getInput().split("\n\n"));

        int validCount = 0;

        for (String p : passportList) {
            List<String> fieldList = Arrays.asList(p.split("[\\s\\n]+"));
            Map<String, String> fieldMap = fieldListToMap(fieldList);

            if (isValidPassport(fieldMap)) {
                validCount++;
            }
        }

        // return:
        return validCount + "";
    }
    
    /**
     * Checks, if a given passport (as {@link Map}) is valid.
     *
     * @param fieldMap the passport to validate
     * @return true, if the passport is valid, false otherwise
     */
    private boolean isValidPassport(Map<String, String> fieldMap) {
        return fieldMap.get("byr") != null
                && fieldMap.get("iyr") != null
                && fieldMap.get("eyr") != null
                && fieldMap.get("hgt") != null
                && fieldMap.get("hcl") != null
                && fieldMap.get("ecl") != null
                && fieldMap.get("pid") != null

                &&

                fieldMap.get("byr").matches("\\d{4}") && Integer.parseInt(fieldMap.get("byr")) >= 1920 && Integer.parseInt(fieldMap.get("byr")) <= 2002
                && fieldMap.get("iyr").matches("\\d{4}") && Integer.parseInt(fieldMap.get("iyr")) >= 2010 && Integer.parseInt(fieldMap.get("iyr")) <= 2020
                && fieldMap.get("eyr").matches("\\d{4}") && Integer.parseInt(fieldMap.get("eyr")) >= 2020 && Integer.parseInt(fieldMap.get("eyr")) <= 2030
                && (fieldMap.get("hgt").matches("\\d+cm") && Integer.parseInt(fieldMap.get("hgt").substring(0, fieldMap.get("hgt").length() - 2)) >= 150 && Integer.parseInt(fieldMap.get("hgt").substring(0, fieldMap.get("hgt").length() - 2)) <= 193
                   || fieldMap.get("hgt").matches("\\d+in") && Integer.parseInt(fieldMap.get("hgt").substring(0, fieldMap.get("hgt").length() - 2)) >= 59 && Integer.parseInt(fieldMap.get("hgt").substring(0, fieldMap.get("hgt").length() - 2)) <= 76)
                && fieldMap.get("hcl").matches("#[0-9a-f]{6}")
                && Arrays.asList(new String[]{"amb", "blu", "brn", "gry", "grn", "hzl", "oth"}).contains(fieldMap.get("ecl"))
                && fieldMap.get("pid").matches("\\d{9}")
            ;
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
