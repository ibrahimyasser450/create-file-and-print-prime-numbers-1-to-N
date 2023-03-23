package IBRAHIM_YASSER;

import javax.swing.*;

class Producer implements Runnable 
{
    private final int number;
	private JTextField text_Field_1;
	private JTextField text_Field_2;
	private JTextField text_Field_3;
    public Buffer buffer;
    
    public Producer(Buffer buffer, int num,JTextField text_Field1,JTextField text_Field2,JTextField text_Field3) {
    	this.buffer = buffer;
        this.number = num;
        this.text_Field_1=text_Field1;
        this.text_Field_2=text_Field2;
        this.text_Field_3=text_Field3;

    }

    /* calculate the prime number */
    public boolean isPrime(int n)
    {
    
        if (n <= 1)
            return false;
 
        for (int i = 2; i < n; i++)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    
    @Override
    public void run() 
    {
    	int big_number=0, no_of_primeNumbers=0;
    	long s_Time = System.nanoTime();

        for (int i = 0; i < number; i++) 
        {
        	if (isPrime(i)) 
            {
        		
                buffer.add(Integer.toString(i));
	              big_number=i;
	              no_of_primeNumbers++;
        	}

        }
        
        long e_Time   = System.nanoTime();
        long totalTime = e_Time - s_Time;
        
        this.text_Field_1.setText(String.valueOf(big_number));
        this.text_Field_2.setText(String.valueOf(no_of_primeNumbers));
        this.text_Field_3.setText(String.valueOf(totalTime)+"ns");

    }
}
