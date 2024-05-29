import java.util.LinkedList;
import java.util.Random;

public class RandomAlgorithm extends PageReplacementAlgorithm {
    @Override
    public Page evictPages(LinkedList<Page> frames) {
        Random random = new Random();
        Page pageToEvict = frames.remove(random.nextInt(frames.size()));
        return pageToEvict;
    }
}
