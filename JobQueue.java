import java.util.*;

public class JobQueue {
    LinkedList<Process> processes;

    public JobQueue() {
        this.processes = new LinkedList<>();
    }

    /**
     * Create queue with process, sorted by arrivalTime
     **/
    public static JobQueue creationOfQueue(int maxJobs) {
        JobQueue readyQueue = new JobQueue();
        Random random = new Random();
        for (int i = 0; i < maxJobs; i++) {
            int processId = i + 1;
            int size = random.nextInt(4) + 1; // memory requirement
            int arrivalTime = random.nextInt(200);
            int serviceDuration = random.nextInt(5) + 1;//time taken

            Process process = new Process(Process.getProcessName(i), size, arrivalTime, serviceDuration);
            int currentPageNumber = random.nextInt(PageReplacementAlgorithm.VIRTUAL_MEMORY_SIZE) + 1;
            Page currentPage = new Page(currentPageNumber, 1);
            currentPage.setProcessName(process.getProcessName());
            List<Page> pageRequested = new ArrayList<>();
            pageRequested.add(currentPage);
            addPagesRequestedByProcess(process, pageRequested, currentPageNumber);
            readyQueue.addToJobQueue(process);
        }
        return readyQueue;
    }

    /**
     * This method mimics the behavior of page referencing by randomly determining
     * the probability of locality and generating the next page accordingly and adding to associated process.
     **/
    public static void addPagesRequestedByProcess(Process process, List<Page> pageRequested, int currentPageNumber) {

        Random random = new Random();

        for (int j = 1; j < process.getProcessSize(); j++) {
            int nextPageNumber;
            final int LOCALITY_PROBABILITY = 7; // 70% probability for locality of reference

            int probability = random.nextInt(10);
            int locality;
            if (probability < LOCALITY_PROBABILITY) {
                locality = random.nextInt(3) - 1; // -1, 0, or 1
            } else {
                locality = random.nextInt(7) + 2; // Range between 2 and 8
            }

            nextPageNumber = ((currentPageNumber + locality) % PageReplacementAlgorithm.VIRTUAL_MEMORY_SIZE);
            Page nextPage = new Page(nextPageNumber, 1);
            nextPage.setProcessName(process.getProcessName());
            pageRequested.add(nextPage);
            currentPageNumber = nextPageNumber;
        }
        process.setPageRequests(pageRequested);
    }

    /**
     * Add process to queue sorted by arrivalTime
     **/
    void addToJobQueue(Process process) {
        this.processes.add(process);
        Collections.sort(this.processes, Comparator.comparingInt(p -> p.arrivalTime));
    }
}
