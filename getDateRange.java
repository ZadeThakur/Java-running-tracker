import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class getDateRange extends JFrame {

	private JPanel contentPane;
	private JTextField startDateField;
	private JTextField endDateField;
	static String startDate;
	static String endDate;
	public static String getStartDate(){
		return startDate;
	}
	public static String getEndDate(){
		return endDate;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getDateRange frame = new getDateRange();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public getDateRange() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		startDateField = new JTextField();
		startDateField.setBounds(171, 42, 116, 22);
		contentPane.add(startDateField);
		startDateField.setColumns(10);
		
		JLabel lblEnterStartDate = new JLabel("Enter Start Date");
		lblEnterStartDate.setBounds(48, 45, 100, 16);
		contentPane.add(lblEnterStartDate);
		
		JLabel lblEnterEndDate = new JLabel("Enter End Date");
		lblEnterEndDate.setBounds(48, 87, 100, 16);
		contentPane.add(lblEnterEndDate);
		
		endDateField = new JTextField();
		endDateField.setBounds(171, 84, 116, 22);
		contentPane.add(endDateField);
		endDateField.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().equals("January")) {
					startDateField.setText("01-01-2018");
					endDateField.setText("31-01-2018");
				}
				else if(comboBox.getSelectedItem().equals("February")) {
					startDateField.setText("01-02-2018");
					endDateField.setText("28-02-2018");
				}
				else if(comboBox.getSelectedItem().equals("March")) {
					startDateField.setText("01-03-2018");
					endDateField.setText("31-03-2018");
				}
				else if(comboBox.getSelectedItem().equals("April")) {
					startDateField.setText("01-04-2018");
					endDateField.setText("30-04-2018");
				}
				else if(comboBox.getSelectedItem().equals("May")) {
					startDateField.setText("01-05-2018");
					endDateField.setText("31-05-2018");
				}
				else if(comboBox.getSelectedItem().equals("June")) {
					startDateField.setText("01-06-2018");
					endDateField.setText("30-06-2018");
				}
				else if(comboBox.getSelectedItem().equals("July")) {
					startDateField.setText("01-07-2018");
					endDateField.setText("31-07-2018");
				}
				else if(comboBox.getSelectedItem().equals("August")) {
					startDateField.setText("01-08-2018");
					endDateField.setText("31-08-2018");
				}
				else if(comboBox.getSelectedItem().equals("September")) {
					startDateField.setText("01-09-2018");
					endDateField.setText("30-09-2018");
				}
				else if(comboBox.getSelectedItem().equals("October")) {
					startDateField.setText("01-10-2018");
					endDateField.setText("31-10-2018");
				}
				else if(comboBox.getSelectedItem().equals("November")) {
					startDateField.setText("01-11-2018");
					endDateField.setText("30-11-2018");
				}
				else if(comboBox.getSelectedItem().equals("December")) {
					startDateField.setText("01-12-2018");
					endDateField.setText("31-12-2018");
				}
				else if(comboBox.getSelectedItem().equals("")) {
					startDateField.setText("");
					endDateField.setText("");
				}
				
			}
		});
		comboBox.setBounds(171, 159, 116, 22);
		contentPane.add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("January");
		comboBox.addItem("February");
		comboBox.addItem("March");
		comboBox.addItem("April");
		comboBox.addItem("May");
		comboBox.addItem("June");
		comboBox.addItem("July");
		comboBox.addItem("August");
		comboBox.addItem("September");
		comboBox.addItem("October");
		comboBox.addItem("November");
		comboBox.addItem("December");
		
		JLabel lblSelectOnlyMonth = new JLabel("Select only month");
		lblSelectOnlyMonth.setBounds(48, 162, 110, 16);
		contentPane.add(lblSelectOnlyMonth);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int error=0;
					String temp1 = startDateField.getText();
					String temp2 = endDateField.getText();

					if(temp1.equals("")||temp2.equals("")) {
						JOptionPane.showMessageDialog(null,"Error:Empty Date Field Found.Try Again");
						error =1;
					}
					else if(temp1.length()!=10 || temp2.length()!=10 ) {
						JOptionPane.showMessageDialog(null,"Wrong input format of dates. Correct format is DD-MM-YYYY");
						error =1;
					}
					else {
						try {
							String[] dataLine1 = temp1.split("-");
							String[] dataLine2 = temp2.split("-");
							for(int i=0;i<3;i++) {
								int tempInt = Integer.parseInt(dataLine1[i]);	
							}
							for(int i=0;i<3;i++) {
								int tempInt = Integer.parseInt(dataLine2[i]);	
							}
						}
						catch(Exception e) {
							JOptionPane.showMessageDialog(null,"Invalid Dates entered.Correct format is DD-MM-YYYY. please try again.");
							error =1;
						}

						
					}
					if(error ==0) {
						startDate = startDateField.getText();
						endDate = endDateField.getText();
						setVisible(false);
	    				showAverages showAverage = new showAverages();
	    				showAverage.setVisible(true);
					}

				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}

			}
		});
		btnSubmit.setBounds(48, 227, 97, 25);
		contentPane.add(btnSubmit);
	}
}
