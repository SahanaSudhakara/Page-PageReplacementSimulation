import java.util.LinkedList;
import java.util.List;

/**
 * This class consists of a linked list of frames representing the physical memory,
 * with a fixed size defined by the MAIN_MEMORY_SIZE constant. The virtual memory,
 * represented by the VIRTUAL_MEMORY_SIZE constant, contains all the pages available to the system.
 **/
public abstract class PageReplacementAlgorithm {
    //size of virtual memory
    public static final int VIRTUAL_MEMORY_SIZE = 100;
    //size of physical memory
    private static final int MAIN_MEMORY_SIZE = 50;
    //number of pages in physical memory
    public static LinkedList<Page> frames;

    public PageReplacementAlgorithm() {
        this.frames = new LinkedList<>();
    }

    /**
     * Function that checks whether page is present in physical memory
     **/
    public static boolean IsInMemory(int pageNumber) {
        for (Page page : frames) {
            if ((page.pageNumber == pageNumber)) {
                int accessTime = page.getLastAccessTime();
                page.setLastAccessTime(accessTime + 1);
                return true;
            }
        }
        return false;
    }

    public abstract Page evictPages(LinkedList<Page> frames);

    /**
     * create a readyQueue and pick a process from head of the readyQueue
     * assign memory to pages referenced by a process-run()
     * calculate hit ratio for all process and Average hit ratio for an Algorithm
     **/
    public void runPageReplacementSimulation(int runTime) {
        double hitRatioCount = 0;
        double hitRatio = 0;
        for (int i = 0; i < runTime; i++) {
            System.out.printf("runTime = "+
                    ( i+1) + "\n");
            System.out.printf("%-12s | %-8s | %-6s | %-12s | %-8s\n",
                    "Time Stamp", "Process", "Enter/exit","Arrival Time", "Size in Pages", "Service Duration");
            System.out.println("------------------------------------------------------------------");
            //create a readyQueue
            JobQueue readyQueue = JobQueue.creationOfQueue(150);
            int totalReferences = 0;
            int totalHits = 0;

            while (!readyQueue.processes.isEmpty()) {
                //pick a process from head of the readyQueue
                Process process = readyQueue.processes.removeFirst();
                System.out.println("\n");
                //print process Name and details
                process.printProcessDetails(process);
                generateMemoryMap(frames);
                int requiredPages = process.getProcessSize();
                //set totalReferences with total pages required for process
                totalReferences += requiredPages;
                int timesHit = run(process);
                //add number of hits in process to totalHits
                totalHits += timesHit;
            }

            System.out.println("Hits= " + totalHits);
            //calculate hit ratio for all process
            hitRatio = (double) totalHits / totalReferences;
            //keep track of hitRatio for 1,2..5 runs
            hitRatioCount += hitRatio;
        }
        double avgHitRatio = (double) hitRatioCount / runTime;
        System.out.println("\nAverage Hit Ratio for " + getName() + " = " + avgHitRatio);


    }

    /**
     * Get number of pages required for a process
     * make a random and use locality of references to get all pages required
     * iterate requested pages by process
     * if YES: increment hit
     * NO: check if memory is full-->if YES: Evict, NO: add to MainMemory
     * print Memory map for a process
     **/
    public int run(Process process) {
        int timesHit = 0;
        List<Page> pageRequests = process.getPageRequests();

        // Iterate through each requested page of the process
        for (int i = 0; i < pageRequests.size(); i++) {
            if (IsInMemory(pageRequests.get(i).getPageNumber())) {
                timesHit++;
                break;
            } else {
                // If there is no space in MAINMemory
                if (frames.size() >= MAIN_MEMORY_SIZE) {
                    // Evict the page
                    Page pageToEvict = evictPages(frames);
                    if (pageToEvict.getPageNumber() != -1) {
                        // Add evicted page number to the list for printing the memory map
                        System.out.println("Swapped out process is " + pageToEvict.getProcessName()
                                + " with evicted page Number " + pageToEvict.getPageNumber());
                    }
                }

                Page pageEntry = new Page(pageRequests.get(i).getPageNumber(), 1);
                pageEntry.setProcessName(process.getProcessName());

                // If space is available, add the page to memory
                frames.addFirst(pageEntry);
            }
        }
        return timesHit;
    }

    /**
     * Function that appends pageReplacementAlgorithm Name that is running
     **/
    public String getName() {
        String algorithmName = this.getClass().getSimpleName();
        return algorithmName;
    }

    /**
     * Function that generates memory maps
     **/
    public void generateMemoryMap(LinkedList<Page> frames) {
        StringBuilder memoryMapBuilder = new StringBuilder();

        for (Page page : frames) {
            if (page.getPageNumber() != -1 && page.getProcessName() != null) {

                memoryMapBuilder.append(page.getProcessName() + "..");
                memoryMapBuilder.append(page.getPageNumber());
            }

            memoryMapBuilder.append(" ");
        }

        System.out.println("Memory Map:");
        System.out.println(memoryMapBuilder.toString());
    }
}







