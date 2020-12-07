package voruti.aoc2020.utility;

import java.util.Map;
import java.util.HashMap;

/**
 * Representation of a bag.
 *
 * @author voruti
 */
public final class Bag {

    private static Map<String, Bag> allBagsMap = new HashMap<>();

    private String label;
    /**
     * Bag linkage.<br>
     * key: label {@link String} of another {@link Bag}, which can fit inside this {@link Bag}<br>
     * value: number of how often the other {@link Bag} is contained inside this {@link Bag}
     */
    private Map<String, Integer> containsBagMap;
    /**
     * Bag linkage.<br>
     * key: label {@link String} of another {@link Bag}, in which this {@link Bag} fits in<br>
     * value: number of how often this {@link Bag} is contained inside the other {@link Bag}
     */
    private Map<String, Integer> containedByMap;

    /**
     * Constructor with label.
     *
     * @param label the label of the bag
     */
    private Bag(String label) {
        this.label = label;
        this.containsBagMap = new HashMap<>();
        this.containedByMap = new HashMap<>();

        allBagsMap.put(label, this);
    }

    /**
     * Returns the {@link Bag} object with the fitting label.
     * Creates a new object, if necessary.
     *
     * @param label the {@link String} label of the bag to return
     * @return the desired {@link Bag} object
     */
    public static Bag getBagWithLabel(String label) {
        return allBagsMap.get(label) != null ? allBagsMap.get(label) : new Bag(label);
    }

    /**
     * Updates the {@link Bag#containedByMap} of all {@link Bag} objects
     * (in {@link Bag#allBagsMap}).
     */
    public static void updateContainedByMaps() {
        allBagsMap.values().parallelStream().forEach(b -> b.containedByMap.clear());
        allBagsMap.values().parallelStream().forEach(b -> {
            b.containsBagMap.entrySet().parallelStream().forEach(e -> {
                allBagsMap.get(e.getKey()).containedByMap.put(b.label, e.getValue());
            });
        });
    }

    @Override
    public String toString() {
        return "Bag \"" + label + "\": contains=" + containsBagMap + ", containedBy=" + containedByMap;
    }

    /**
     * Get the {@link Bag#label} {@link String}.
     *
     * @return the label {@link String} value
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Get the {@link Bag#containsBagMap} {@link Map}{@literal <}String, Integer{@literal >}.
     *
     * @return the containsBagMap {@link Map} instance
     */
    public Map<String, Integer> getContainsBagMap() {
        return this.containsBagMap;
    }

    /**
     * Get the {@link Bag#containedByMap} {@link Map}{@literal <}String, Integer{@literal >}.
     *
     * @return <em>a copy</em> of the containedByMap {@link Map} instance
     */
    public Map<String, Integer> getContainedByMap() {
        return new HashMap<>(this.containedByMap);
    }
}
