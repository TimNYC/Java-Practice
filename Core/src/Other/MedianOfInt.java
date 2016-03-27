package Other;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Tim Wang on 3/18/2016.
 */
public class MedianOfInt {
    public Queue<Integer> min;
    public Queue<Integer> max;
    public int size;

    public MedianOfInt() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(10, new MaxComparator());
        size = 0;
    }

    public void add(Integer num) {
        max.add(num);
        if (size % 2 == 0) {
            if (min.isEmpty()) {
                size++;
                return;
            } else if (max.peek() > min.peek()) {
                Integer maxRoot = max.poll();
                Integer minRoot = min.poll();
                max.add(minRoot);
                max.add(maxRoot);
            }
        } else {
            //min.add(max);
        }
    }

    private class MaxComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

}
