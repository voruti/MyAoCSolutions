package voruti.aoc2020.utility;

/**
 * Data structure for a password and its policy.
 *
 * @author voruti
 */
public class PasswordAndPolicy {

    private int minimum;
    private int maximum;
    private char character;

    private String password;

    /**
     * Generates a {@link PasswordAndPolicy} object from a line of the input file.
     *
     * @param inputLine the line of input
     * @return the new instance
     */
    public static PasswordAndPolicy fromInputLine(String inputLine) {
        PasswordAndPolicy passwordAndPolicy = new PasswordAndPolicy();

        passwordAndPolicy.minimum = Integer.parseInt(inputLine.split("-")[0]);
        passwordAndPolicy.maximum = Integer.parseInt(inputLine.split("-")[1].split(" ")[0]);
        passwordAndPolicy.character = inputLine.split(" ")[1].charAt(0);
        passwordAndPolicy.password = inputLine.split(": ")[1];

        return passwordAndPolicy;
    }

    /**
     * Checks if the password is valid within the first policy.
     *
     * @return true, if the password is valid, false otherwise
     */
    public boolean isValidV1() {
        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == character) {
                count++;
            }
        }
        /*if (!(count >= minimum && count <= maximum)) {
            System.out.printf("%s-%s %s: %s%n", minimum, maximum, character, password);
        }*/
        return count >= minimum && count <= maximum;
    }

    /**
     * Checks if the password is valid within the second policy.
     *
     * @return true, if the password is valid, false otherwise
     */
    public boolean isValidV2() {
        /*if ((password.charAt(minimum - 1) == character ^ password.charAt(maximum - 1) == character)) {
            System.out.printf("%s-%s %s: %s%n", minimum, maximum, character, password);
        }*/
        return password.charAt(minimum - 1) == character ^ password.charAt(maximum - 1) == character;
    }

    /**
     * Get the {@link PasswordAndPolicy#minimum} count of {@link PasswordAndPolicy#character}.
     *
     * @return the minimum value
     */
    public int getMinimum() {
        return this.minimum;
    }

    /**
     * Set the {@link PasswordAndPolicy#minimum} count of {@link PasswordAndPolicy#character}.
     *
     * @param minimum the minimum value
     * @return this instance for chaining calls
     */
    public PasswordAndPolicy setMinimum(int minimum) {
        this.minimum = minimum;
        return this;
    }

    /**
     * Get the {@link PasswordAndPolicy#maximum} count of {@link PasswordAndPolicy#character}.
     *
     * @return the maximum value
     */
    public int getMaximum() {
        return this.maximum;
    }

    /**
     * Set the {@link PasswordAndPolicy#maximum} count of {@link PasswordAndPolicy#character}.
     *
     * @param maximum the maximum value
     * @return this instance for chaining calls
     */
    public PasswordAndPolicy setMaximum(int maximum) {
        this.maximum = maximum;
        return this;
    }

    /**
     * Get the {@link PasswordAndPolicy#character} of the policy.
     *
     * @return the character value
     */
    public char getCharacter() {
        return this.character;
    }

    /**
     * Set the {@link PasswordAndPolicy#character} of the policy.
     *
     * @param character the character value
     * @return this instance for chaining calls
     */
    public PasswordAndPolicy setCharacter(char character) {
        this.character = character;
        return this;
    }

    /**
     * Get the {@link PasswordAndPolicy#password}.
     *
     * @return the password value
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Set the {@link PasswordAndPolicy#password}.
     *
     * @param password the password value
     * @return this instance for chaining calls
     */
    public PasswordAndPolicy setPassword(String password) {
        this.password = password;
        return this;
    }
}
