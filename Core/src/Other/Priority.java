package Other;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Tim Wang on 3/18/2016.
 */
public class Priority {

    public static void main(String[] args) {
        Queue<Integer> heap = new PriorityQueue<>(2);
        heap.add(3);
        heap.add(4);
        heap.add(2);
        heap.add(1);
        heap.add(9);
        for (int x : heap) {
            System.out.println(x);
        }
    }
}
