import java.awt.EventQueue;
import java.util.*;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ConversionAppUI {

	/* Initialize private variables */
	private JFrame frame;
	private JComboBox comboBox1; 
	private JComboBox comboBox2;
	private JTextField textField1;
	private JTextField textField2;
	
	/* Initialize public variables */
	public static String m1, m2;  // Variables to send both measurement labels to the constructor
	public static int text1, text2;  // Variables to send both measurement numbers to the constructor

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversionAppUI window = new ConversionAppUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConversionAppUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		frame = new JFrame();
		frame.setBounds(100, 100, 637, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Convert");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Gather all user inputs */
				m1 = (String) comboBox1.getSelectedItem();
				m2 = (String) comboBox2.getSelectedItem();
				text1 = Integer.parseInt(textField1.getText());
				text2 = Integer.parseInt(textField2.getText());
				
				/* Create converter object and display conversion */
				Converter result = new Converter(m1, m2, text1, text2);
				result.print();
			}
		});
		btnNewButton.setBounds(228, 279, 137, 33);
		frame.getContentPane().add(btnNewButton);
		
		
		ArrayList<String> measurements = createStringArray();
		
		comboBox1 = new JComboBox(measurements.toArray());
		comboBox1.setBounds(265, 143, 162, 33);
		frame.getContentPane().add(comboBox1);
		
		comboBox2 = new JComboBox(measurements.toArray());
		comboBox2.setBounds(265, 198, 162, 33);
		frame.getContentPane().add(comboBox2);

		textField1 = new JTextField();
		textField1.setBounds(166, 143, 64, 33);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(166, 198, 64, 33);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);
	}
	
	private ArrayList<String> createStringArray() {
        String fileName = "labels.txt";
        String line = null;
        ArrayList<String> result = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader =  new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }   
            
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" + fileName + "'");                  
        }
	
		return result;
	}
}

