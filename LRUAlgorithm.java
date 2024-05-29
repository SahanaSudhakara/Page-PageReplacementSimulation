import java.util.LinkedList;

public class LRUAlgorithm extends PageReplacementAlgorithm {

    @Override
    public Page evictPages(LinkedList<Page> frames) {
        int leastRecentTime = Integer.MAX_VALUE;
        Page pageToEvict = null;

        for (Page frame : frames) {
            int frameTime = frame.getLastAccessTime();

            if (frameTime < leastRecentTime) {
                leastRecentTime = frameTime;
                pageToEvict = frame;
            }
        }

        frames.remove(pageToEvict);
        return pageToEvict;
    }


}
