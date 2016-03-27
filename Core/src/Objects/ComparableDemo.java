package Objects;

/**
 * Created by Tim Wang on 3/27/2016.
 */
public class ComparableDemo implements Comparable<ComparableDemo> {
    String s;
    public int compareTo(ComparableDemo c) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, c.s);
    }
}
