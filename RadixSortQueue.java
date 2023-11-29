import java.util.LinkedList;
import java.util.Queue;

public class RadixSortQueue {
    // Used for finding the queue
    static final int RADIX_BASE = 10;
    static final int[] POWERS_OF_TEN = {1, 10, 100};
    Queue[] queues;
    
    public RadixSortQueue()
    {
        generateQueues();  
    }

    /**
     * Creates an array of queues -- LinkedList is used for queue
     */
    private void generateQueues() {
        queues = new Queue[RADIX_BASE]; 
        for(int i = 0; i < RADIX_BASE; i++) 
            queues[i] = new LinkedList<Integer>();
    }
    
    /**
     * @param input array of int to be sorted (only integers with 3 digits ranging from 100 to 999
     * @return sorted array
     */
    public int[] sort(int[]input)
    {
        for (int pass = 1; pass<=3; pass++)
        {
            // this value is used to get the corresponding digit in each pass
            int divisor = POWERS_OF_TEN[pass-1];
            
            // this method will add the values to the corresponding queue
            updateQueues(input, divisor);  
            for(int temp : input) {
            	int tempVal = 0;
            	if(divisor == 1) 
            		tempVal = temp%10;
            	if(divisor == 10) 
            		tempVal = temp%100/10;
            	if(divisor == 100) 
            		tempVal = temp/100;
            	queues[tempVal].offer(temp);
            }
            int i = 0;
            for(Queue q: queues) {
            	if(q.peek() == null)
            		continue;
            	else {
            		input[i] = (int) q.poll();
            		i++;
            	}
            }
        }
        return input;
    }

    private void updateQueues(int[] input, int divisor) {
        // empty the queues
        generateQueues();
        
        for(int num: input)
        {
            int queueIndex = (num/divisor)%RADIX_BASE; 
            queues[queueIndex].add(num);
        }
    }
    
    public static void main(String[] args) {
        int[]arr = {100,200,333,431,198};
        RadixSortQueue r = new RadixSortQueue();
        r.sort(arr);
    }
}
