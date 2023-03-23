package IBRAHIM_YASSER;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.nio.file.*;

class Consumer implements Runnable {

    public Buffer buffer;
    private final int number;
    private String filename;
    

    public Consumer(Buffer buffer, int num,String f_name) {
    	this.buffer = buffer;
        this.number = num;
        this.filename=f_name;
    }

    @Override
    public void run() {
    	String item;
    	
    	if(!Files.exists(Paths.get(this.filename)))
    	{
    		try {
                File myObj = new File(this.filename);
                if (myObj.createNewFile()) {
                	JFrame frame=new JFrame();
            		JLabel label_PrimeNumber = new JLabel("Large of prime number");
            		frame.getContentPane().add(label_PrimeNumber);
            		
            		JLabel label_No_ofprimeNumbers = new JLabel("Number of prime numbers");
            		frame.getContentPane().add(label_No_ofprimeNumbers);
            		
            		JLabel label_Time = new JLabel("Time of processing");
            		frame.getContentPane().add(label_Time);
            		

                } else {
                  System.out.print("");
                }
              } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
              }
    	}
    	
    	 
        for(int i=0; i<number;i++){
            try {
                   //System.out.println("Consumed: " + s);
                try {
                    FileWriter myWriter = new FileWriter(this.filename,true);
                    item = buffer.consume();
                    myWriter.write("'" + String.valueOf(item) + "', ");
                    myWriter.close();
                  } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                  }
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        

    }
}
