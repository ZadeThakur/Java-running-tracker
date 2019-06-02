import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class showAverages extends JFrame {

	private JPanel contentPane;
	private JTextField averagePaseField;
	private JTextField averageDistanceField;
	private JTextField avAltGainField;
	private JTextField avAltLossField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showAverages frame = new showAverages();
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
	public showAverages() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 457);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAveragePace = new JLabel("Average pace");
		lblAveragePace.setBounds(94, 68, 95, 16);
		contentPane.add(lblAveragePace);
		
		
		averagePaseField = new JTextField();
		averagePaseField.setBounds(236, 65, 116, 22);
		contentPane.add(averagePaseField);
		averagePaseField.setColumns(10);
		averagePaseField.setText(calculateAverage.averagePace(getDateRange.getStartDate(),getDateRange.getEndDate(), File file));
		
		
		JLabel lblAverageDistance = new JLabel("average distance");
		lblAverageDistance.setBounds(94, 120, 110, 16);
		contentPane.add(lblAverageDistance);
		
		averageDistanceField = new JTextField();
		averageDistanceField.setBounds(236, 117, 116, 22);
		contentPane.add(averageDistanceField);
		averageDistanceField.setColumns(10);
		averageDistanceField.setText(calculateAverage.averageDistance(getDateRange.getStartDate(),getDateRange.getEndDate(), File file));
		
		JLabel lblAverageAltitudeGain = new JLabel("average altitude gain");
		lblAverageAltitudeGain.setBounds(94, 175, 132, 16);
		contentPane.add(lblAverageAltitudeGain);
		
		JLabel lblAverageAltitudeLoss = new JLabel("average altitude loss");
		lblAverageAltitudeLoss.setBounds(94, 233, 132, 16);
		contentPane.add(lblAverageAltitudeLoss);
		
		avAltGainField = new JTextField();
		avAltGainField.setBounds(236, 172, 116, 22);
		contentPane.add(avAltGainField);
		avAltGainField.setColumns(10);
		avAltGainField.setText(calculateAverage.avgAltGain(getDateRange.getStartDate(),getDateRange.getEndDate(), File file));
		
		avAltLossField = new JTextField();
		avAltLossField.setBounds(236, 230, 116, 22);
		contentPane.add(avAltLossField);
		avAltLossField.setColumns(10);
		avAltLossField.setText(calculateAverage.absAltitudeGained(getDateRange.getStartDate(),getDateRange.getEndDate(), File file));
		
		JButton btnCloseWindow = new JButton("close window");
		btnCloseWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCloseWindow.setBounds(92, 290, 134, 25);
		contentPane.add(btnCloseWindow);
	}
}
