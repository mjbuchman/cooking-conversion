import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConversionAppUI {

	/* Initialize private variables */
	private JFrame frame;
	private JComboBox comboBox1; 
	private JComboBox comboBox2;
	private JTextField textField1;
	
	public static JLabel lblAns;
	public static String m1, m2;  // Variables to send both measurement labels to the constructor
	public static double text1;  // Variables to send both measurement numbers to the constructor

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	    	System.out.println("Unsupported Look and Feel");
	    }
	    catch (ClassNotFoundException e) {
	    	System.out.println("Look and Feel Class Not Found");
	    }
	    catch (InstantiationException e) {
	        System.out.println("Instantiation Exception Thrown");
	    }
	    catch (IllegalAccessException e) {
	    	System.out.println("Illegal Access Exception Thrown");
	    }
	    
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
		frame = new JFrame("Cooking Measurement Conversion Tool");
		frame.setBounds(100, 100, 538, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 522, 55);
		frame.getContentPane().add(panel);
		
		JLabel lblCookingConversions = new JLabel("Cooking Conversions");
		lblCookingConversions.setForeground(Color.WHITE);
		lblCookingConversions.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblCookingConversions.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCookingConversions);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Gather all user inputs */
				m1 = (String) comboBox1.getSelectedItem();
				m2 = (String) comboBox2.getSelectedItem();
				text1 = Double.parseDouble(textField1.getText());
				
				/* Create converter object and display conversion */
				Converter result = new Converter(m1, m2, text1);
				double rate = result.getConversionRate();
				lblAns.setText(result.getResult(rate));
			}
		});
		btnNewButton.setBounds(118, 284, 137, 33);
		frame.getContentPane().add(btnNewButton);
		
		
		ArrayList<String> measurements = createStringArray();
		
		comboBox1 = new JComboBox(measurements.toArray());
		comboBox1.setBounds(169, 148, 162, 33);
		frame.getContentPane().add(comboBox1);
		comboBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAns.setText("");
			}
		});
		
		comboBox2 = new JComboBox(measurements.toArray());
		comboBox2.setBounds(169, 203, 162, 33);
		frame.getContentPane().add(comboBox2);
		comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAns.setText("");
			}
		});

		textField1 = new JTextField();
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setBounds(67, 148, 64, 33);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		JLabel lblConvert = new JLabel("Convert");
		lblConvert.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConvert.setHorizontalAlignment(SwingConstants.CENTER);
		lblConvert.setBounds(149, 84, 70, 43);
		frame.getContentPane().add(lblConvert);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setBounds(73, 212, 46, 14);
		frame.getContentPane().add(lblTo);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblResult.setBounds(416, 148, 70, 24);
		frame.getContentPane().add(lblResult);
		
		lblAns = new JLabel("");
		lblAns.setOpaque(true);
		lblAns.setHorizontalAlignment(SwingConstants.CENTER);
		lblAns.setBackground(Color.WHITE);
		lblAns.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAns.setBounds(416, 199, 46, 33);
		frame.getContentPane().add(lblAns);
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
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
        }
        
		return result;
	}
}

