package IBRAHIM_YASSER;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private  Queue<String> myQueue = new LinkedList<String>();
    private int B_size;
    int element=0;
    String item = " ";

    public Buffer(int max_size)
    {
        this.B_size=max_size;
    }

    public Buffer() {
		// TODO Auto-generated constructor stub
	}

    // Add item to Queue
    public synchronized void add(String item)
    {
        while(myQueue.size()==B_size)
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        this.myQueue.add(item);
        element++;
        notify();
    }

    // take item from Queue
    public synchronized String consume()
    {
        while (myQueue.isEmpty()) 
        {
            try
            {
                wait();
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        item = myQueue.remove();
        element--;
        notify();
        return item;
    } 
}
