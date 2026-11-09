package Design;

import java.util.ArrayDeque;
import java.util.Deque;

class HitCounter {

    private Deque<Integer> dq;


    public HitCounter() {
        dq=new ArrayDeque<Integer>();
    }

    private void removeExpired(int timestamp){
        while(!dq.isEmpty() && dq.getFirst()<=timestamp){
            dq.pollFirst();
        }
    }

    public void hit(int timestamp) {
        dq.offerLast(timestamp);
        removeExpired(timestamp-300);
    }

    public int getHits(int timestamp) {
        removeExpired(timestamp-300);
        return dq.size();
    }
}
