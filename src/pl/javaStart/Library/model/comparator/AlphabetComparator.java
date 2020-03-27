package pl.javaStart.Library.model.comparator;

import pl.javaStart.Library.model.Publication;

import java.util.Comparator;

public class AlphabetComparator implements Comparator<Publication> {
    @Override
    public int compare(Publication p1, Publication p2) {
        if (p1==null && p2 == null)
            return 0;
        else if (p1 == null)
            return 1;
        else if (p2==null)
            return -1;
        return p1.getTitle().compareToIgnoreCase(p2.getTitle());
    }
}
