/**
 * This class provides methods to get and set the page number and last access time.
 **/
public class Page {
    public Integer pageNumber;

    public String ProcessName;

    public int timeLastUsed;

    public Page(int pageNumber, int timeLastUsed) {
        this.pageNumber = pageNumber;
        this.timeLastUsed = timeLastUsed;
    }

    public String getProcessName() {
        return ProcessName;
    }

    public void setProcessName(String processName) {
        ProcessName = processName;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getLastAccessTime() {
        return timeLastUsed;
    }

    public void setLastAccessTime(int timeLastUsed) {
        this.timeLastUsed = timeLastUsed;
    }


}
