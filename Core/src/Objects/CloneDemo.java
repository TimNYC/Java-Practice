package Objects;

/**
 * Created by Tim Wang on 3/27/2016.
 */
/*
    x.clone() != x
    x.clone().getClass() == x.getClass()
    x.clone().equals(x)

    instead of using clone method directly, use Cloneable
 */
public class CloneDemo implements Cloneable {

    //!A fine approach to object copying is to provide a copy constructor or copy
    //factory.
    public CloneDemo(CloneDemo c) {

    }
    public static CloneDemo newInstance(CloneDemo c) {
        return null;
    }
    /*
    Interface-based copy constructors and factories, more
properly known as conversion constructors and conversion factories, allow the
client to choose the implementation type of the copy rather than forcing the client
to accept the implementation type of the original.

     Given all of the problems associated with Cloneable, it’s safe to say that
other interfaces should not extend it, and that classes designed for inheritance
(Item 17) should not implement it.

     */
    //TODO: You can have a conversion constructor/factories return different class



    /*
        In effect, the clone method functions as another constructor;
    you must ensure that it does no harm to the original object and that it properly
    establishes invariants on the clone.
     */
    private Entry[] buckets;
    private static class Entry {
        final Object key;
        Object value;
        Entry next;
        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        // Recursively copy the linked list headed by this Entry
        Entry deepCopy() {
            return new Entry(key, value,
                    next == null ? null : next.deepCopy());
        }
    }

    /*
     If you extend a class that implements Cloneable, you have little choice but to implement a well-behaved
     clone method. Otherwise, you are better off providing an alternative means of
    object copying, or simply not providing the capability. For example, it doesn’t
    make sense for immutable classes to support object copying, because copies
    would be virtually indistinguishable from the original.
     */
    @Override
    public CloneDemo clone() {
        try {
            CloneDemo result = (CloneDemo) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++)
                if (buckets[i] != null)
                    result.buckets[i] = buckets[i].deepCopy();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
