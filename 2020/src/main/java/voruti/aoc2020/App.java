package voruti.aoc2020;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

/**
 * Application starter.
 *
 * @author voruti
 */
@Command(name = "aoc2020", mixinStandardHelpOptions = true, version = "1.0", description = "My implementations of the Advent of Code (https://adventofcode.com) 2020 puzzles.")
public class App implements Runnable {

    @Parameters(description = "the days whose puzzles should be executed")
    private List<Integer> days;

    @Option(names = {"-a", "--all"}, description = "run all puzzles")
    private boolean runAll;

    /**
     * Starts execution after args are evaluated.
     */
    @Override
    public void run() {
        if (runAll) {
            days = IntStream.rangeClosed(1, 25).boxed().collect(Collectors.toList());
        }
        if (days != null) {
            days.stream().map(PuzzleFactory::createOfDay).forEach(p -> {
                System.out.println("=== Day " + String.format("%02d", p.getDay()) + " ===");

                long startFirst = System.nanoTime();
                String resultFirst = p.firstPuzzle();
                long stopFirst = System.nanoTime();
                double timerFirst = (stopFirst - startFirst) / 1000000.0;
                System.out.println("--- first puzzle's result:  " + resultFirst + "\t(in " + String.format("%,10.4f", timerFirst) + "ms) ---");

                long startSecond = System.nanoTime();
                String resultSecond = p.secondPuzzle();
                long stopSecond = System.nanoTime();
                double timerSecond = (stopSecond - startSecond) / 1000000.0;
                System.out.println("--- second puzzle's result: " + resultSecond + "\t(in " + String.format("%,10.4f", timerSecond) + "ms) ---");
            });
        }
    }

    /**
     * Entry point.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
}
