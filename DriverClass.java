public class DriverClass {

    public static void main(String[] args) {
        // Choose a page replacement algorithm
        PageReplacementAlgorithm fifoAlgorithm = new FIFOAlgorithm();
        PageReplacementAlgorithm randomAlgorithm = new RandomAlgorithm();
        PageReplacementAlgorithm optimalAlgorithm = new OptimalAlgorithm();
        PageReplacementAlgorithm lruAlgorithm = new LRUAlgorithm();

        // run each algorithm 5 times
        fifoAlgorithm.runPageReplacementSimulation(5);
        randomAlgorithm.runPageReplacementSimulation(5);
        optimalAlgorithm.runPageReplacementSimulation(5);
        lruAlgorithm.runPageReplacementSimulation(5);
    }
}