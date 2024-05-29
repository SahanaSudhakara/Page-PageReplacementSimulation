import java.util.LinkedList;

public class OptimalAlgorithm extends PageReplacementAlgorithm {
    @Override
    public Page evictPages(LinkedList<Page> frames) {
        Page pageNoToEvict;
        Page farthestPage = new Page(0, 0);
        LinkedList<Page> temp = new LinkedList<>(frames);
        here:
        for (int i = 0; i < frames.size(); i++) {
            farthestPage = temp.removeFirst();
            if (!containsPageNumber(temp, farthestPage.getPageNumber())) {
                break here;
            }
        }
        pageNoToEvict = farthestPage;
        frames.remove(farthestPage);
        return pageNoToEvict;
    }

    public boolean containsPageNumber(LinkedList<Page> pages, int pageNo) {
        for (Page page : pages) {
            if (page.getPageNumber() == pageNo) {
                return true;
            }
        }
        return false;
    }

}
