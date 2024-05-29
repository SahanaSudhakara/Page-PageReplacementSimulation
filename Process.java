import java.util.*;

/**
 * This class encapsulates information about a process,
 * including its name,size in pages, arrival time, and service duration.
 * It provides methods to access and modify these attributes.
 **/
public class Process {

    //process name, process size in pages, arrival time, and service duration

    String processName;
    int processSize;
    int arrivalTime;
    int serviceDuration;
    private List<Page> pageRequests;

    public Process(String processName, int processSize, int arrivalTime, int serviceDuration) {
        this.processName = processName;
        this.processSize = processSize;
        this.arrivalTime = arrivalTime;
        this.serviceDuration = serviceDuration;
        this.pageRequests = null;
    }

    public static String getProcessName(int processId) {
        String processName;
        if (processId < 26) {
            processName = Character.toString((char) ('A' + processId));
        } else {
            int firstCharIndex = (processId / 26) - 1;
            int secondCharIndex = processId % 26;
            processName = Character.toString((char) ('A' + firstCharIndex)) + Character.toString((char) ('A' + secondCharIndex));
        }
        return processName;
    }

    public String getProcessName() {
        return processName;
    }

    public int getProcessSize() {
        return processSize;
    }

    public List<Page> getPageRequests() {
        return pageRequests;
    }

    public void setPageRequests(List<Page> pageRequests) {
        this.pageRequests = pageRequests;
    }

    /**
     * Prints process details
     **/
    public void printProcessDetails(Process process) {
        int timeStamp = (int) System.currentTimeMillis();
        System.out.printf("%-12d | %-8s |%-8s  | %-6d | %-12d | %-8d\n",
                timeStamp, "Process = " + process.processName, "Enter", process.arrivalTime, process.processSize, process.serviceDuration);

    }
}
