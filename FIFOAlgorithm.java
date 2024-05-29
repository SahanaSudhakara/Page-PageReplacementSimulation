import java.util.LinkedList;

public class FIFOAlgorithm extends PageReplacementAlgorithm {

    @Override
    public Page evictPages(LinkedList<Page> frames) {
        Page evictedFrame = frames.removeFirst();
        return evictedFrame;
    }

}