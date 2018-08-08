import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ConversionAppUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	public static String meas1, meas2, text1, text2; 


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
				testMethod();
			}
		});
		btnNewButton.setBounds(228, 279, 137, 33);
		frame.getContentPane().add(btnNewButton);
		
		
		String[] measurements = new String[] {"Tablespoon", "Teaspoon", "Cup", "Gallon"};
		
		comboBox = new JComboBox(measurements);
		comboBox.setBounds(265, 143, 162, 33);
		frame.getContentPane().add(comboBox);
		
		comboBox_1 = new JComboBox(measurements);
		comboBox_1.setBounds(265, 198, 162, 33);
		frame.getContentPane().add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(166, 143, 64, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(166, 198, 64, 33);
		frame.getContentPane().add(textField_1);
	}
	
	public void testMethod() {
		meas1 = (String) comboBox.getSelectedItem();
		meas2 = (String) comboBox_1.getSelectedItem();
		text1 = textField.getText();
		text2 = textField_1.getText();
		System.out.println("Converting " + text1 + " " + meas1 + " to " + text2 + " " + meas2 + "...");
	}
}

