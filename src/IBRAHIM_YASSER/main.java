package IBRAHIM_YASSER;

import javax.swing.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.*;

public class main {
    
    private JFrame frame;
    private JTextField text_number;
    private JTextField text_Buffersize;
	private JTextField text_filename;
	private JTextField text_Field_1;
	private JTextField text_Field_2;
	private JTextField text_Field_3;

    
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				    }catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    

    /*
       * create the form
    */

    public main(){
          Initialization(); 
	}


	private void Initialization() {
    
        frame = new JFrame();
		frame.setBounds(125, 150, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		text_number = new JTextField();
		text_number.setBounds(30, 40, 200, 30);
		frame.getContentPane().add(text_number);

        text_Buffersize = new JTextField();
		text_Buffersize.setBounds(30, 80, 200, 30);
		frame.getContentPane().add(text_Buffersize);
		
		text_filename = new JTextField();
		text_filename.setBounds(30, 120, 200, 30);
		frame.getContentPane().add(text_filename);

        text_Field_1 = new JTextField();
		text_Field_1.setEditable(false);
		text_Field_1.setBounds(300, 200, 200, 30);
		frame.getContentPane().add(text_Field_1);
		
		text_Field_2 = new JTextField();
		text_Field_2.setEditable(false);
		text_Field_2.setBounds(300, 240, 200, 30);
		frame.getContentPane().add(text_Field_2);
		
		text_Field_3 = new JTextField();
		text_Field_3.setEditable(false);
		text_Field_3.setBounds(300, 280, 200, 30);
		frame.getContentPane().add(text_Field_3);
        

        JButton button1 = new JButton("Start");
		button1.setForeground(new Color(0,225,0));
		
            button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int num= Integer.parseInt( text_number.getText() );
                int B_size= Integer.parseInt( text_Buffersize.getText() );
				String  filename =text_filename.getText();
				Buffer buffer = new Buffer(B_size);
		        Thread producerThread = new Thread(new Producer(buffer,num , text_Field_1 , text_Field_2 , text_Field_3), "Producer");
		        Thread consumerThread = new Thread(new Consumer(buffer,num ,filename), "Consumer");
		        producerThread.start();
		        consumerThread.start();
			}
		});
        
		button1.setBounds(55, 160, 100, 30);
		frame.getContentPane().add(button1);
		

        JLabel Label_Number = new JLabel("Number");
		Label_Number.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_Number.setBounds(270, 40, 100, 30);
		Label_Number.setForeground(new Color(128,0,0));
		frame.getContentPane().add(Label_Number);

        JLabel Label_Buffersize = new JLabel("Buffer Size");
		Label_Buffersize.setFont(new Font("Tahoma", Font.BOLD, 15));
		Label_Buffersize.setBounds(270, 80, 150, 30);
		Label_Buffersize.setForeground(new Color(128,0,0));
		frame.getContentPane().add(Label_Buffersize);
		
		JLabel label_File = new JLabel("File name");
		label_File.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_File.setBounds(270, 120, 150, 30);
		label_File.setForeground(new Color(128,0,0));
		frame.getContentPane().add(label_File);
		
		JLabel label_PrimeNumber = new JLabel("Large of prime number");
		label_PrimeNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_PrimeNumber.setBounds(35, 200, 300, 30);
		label_PrimeNumber.setForeground(new Color(0,128,128));
		frame.getContentPane().add(label_PrimeNumber);
		
		JLabel label_No_ofprimeNumbers = new JLabel("Number of prime numbers");
		label_No_ofprimeNumbers.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_No_ofprimeNumbers.setBounds(35, 240, 300, 30);
		label_No_ofprimeNumbers.setForeground(new Color(0,128,128));
		frame.getContentPane().add(label_No_ofprimeNumbers);
		
		JLabel label_Time = new JLabel("Time of processing");
		label_Time.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_Time.setBounds(35, 280, 300, 30);
		label_Time.setForeground(new Color(0,128,128));
		frame.getContentPane().add(label_Time);


    }
}

    