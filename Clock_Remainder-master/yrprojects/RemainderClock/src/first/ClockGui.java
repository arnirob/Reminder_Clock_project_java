package first;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ClockGui {

	public static String day;
	public static String hour;
	public static String minute;
	public static String message;

	private JFrame frmRemainderclock;
	private JLabel lblSetTheTimer;
	private JButton btnSet;

	public void close() {
		frmRemainderclock.dispose();
	}

	/**
	 * Launch the application.
	 */
	public static void showScreen() throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClockGui window = new ClockGui();
					window.frmRemainderclock.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClockGui() {
		initialize();
	}

	// TextLimit limit = new TextLimit(2);
	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frmRemainderclock = new JFrame();
		frmRemainderclock.getContentPane().setBackground(new Color(153, 102, 153));
		frmRemainderclock.setResizable(false);
		frmRemainderclock.setTitle("Remainder Clock");
		frmRemainderclock.setBounds(100, 100, 618, 386);
		frmRemainderclock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRemainderclock.getContentPane().setLayout(null);

		lblSetTheTimer = new JLabel("Set the Timer");
		lblSetTheTimer.setBounds(41, 11, 536, 71);
		lblSetTheTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblSetTheTimer.setFont(new Font("Segoe Print", Font.PLAIN, 50));
		frmRemainderclock.getContentPane().add(lblSetTheTimer);

		JComboBox<String> comboBoxDay = new JComboBox<String>();
		comboBoxDay.setModel(new DefaultComboBoxModel<String>(new String[] { "Day" }));
		comboBoxDay.setMaximumRowCount(5);
		comboBoxDay.setFont(new Font("Rockwell", Font.BOLD, 35));
		comboBoxDay.setBounds(41, 93, 160, 52);
		frmRemainderclock.getContentPane().add(comboBoxDay);

		JComboBox<String> comboBoxHour = new JComboBox<String>();
		comboBoxHour.setMaximumRowCount(5);
		comboBoxHour.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Hour", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
						"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		comboBoxHour.setFont(new Font("Rockwell", Font.BOLD, 35));
		comboBoxHour.setBounds(232, 93, 160, 52);
		frmRemainderclock.getContentPane().add(comboBoxHour);

		JComboBox<String> comboBoxMinute = new JComboBox<String>();
		comboBoxMinute.setModel(new DefaultComboBoxModel<String>(new String[] { "Minute" }));
		comboBoxMinute.setMaximumRowCount(5);
		comboBoxMinute.setFont(new Font("Rockwell", Font.BOLD, 35));
		comboBoxMinute.setBounds(417, 93, 160, 52);
		frmRemainderclock.getContentPane().add(comboBoxMinute);

		JLabel lblNewLabelMessage = new JLabel("Message:");
		lblNewLabelMessage.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabelMessage.setBounds(41, 175, 160, 62);
		frmRemainderclock.getContentPane().add(lblNewLabelMessage);

		JTextArea textMessage = new JTextArea();
		textMessage.setFont(new Font("Monospaced", Font.PLAIN, 50));
		textMessage.setBounds(219, 175, 358, 62);
		frmRemainderclock.getContentPane().add(textMessage);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(95, 255, 167, 38);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBoxDay.setSelectedIndex(0);
				comboBoxHour.setSelectedIndex(0);
				comboBoxMinute.setSelectedIndex(0);
				textMessage.setText("");
			}
		});
		frmRemainderclock.getContentPane().add(btnReset);

		btnSet = new JButton("Set");
		btnSet.setBounds(338, 255, 167, 38);
		btnSet.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int counter = 0;

				final String dayData = comboBoxDay.getItemAt(comboBoxDay.getSelectedIndex());
				try {
					if (dayData.equals("Day")) {
						JOptionPane.showMessageDialog(comboBoxDay, "Select Valid Day");
					} else {
						day = dayData;
						counter++;
					}
				} catch (Exception x) {
				}

				final String hourData = comboBoxHour.getItemAt(comboBoxHour.getSelectedIndex());
				try {
					if (hourData.equals("Hour")) {
						JOptionPane.showMessageDialog(comboBoxHour, "Select Valid Hour");
					} else {
						hour = hourData;
						counter++;
					}
				} catch (Exception x) {

				}

				final String minuteData = comboBoxMinute.getItemAt(comboBoxMinute.getSelectedIndex());
				try {
					if (minuteData.equals("Minute")) {
						JOptionPane.showMessageDialog(comboBoxMinute, "Select Valid Minute");
					} else {
						minute = minuteData;
						counter++;
					}
				} catch (Exception x) {
				}

				final String messageData = textMessage.getText();
				try {
					if (messageData.equals(null) || messageData.equals("")) {
						JOptionPane.showMessageDialog(textMessage, "Need Message");
					} else {
						message = messageData;
						counter++;
					}
				} catch (Exception x) {
				}
				if (counter == 4) {
					close();
					GetDateAndTime getdateandtime = new GetDateAndTime();
					getdateandtime.testLocalDateTime();
					Calculation.calculateDistance(dayData, hourData, minuteData);
					comboBoxDay.setSelectedIndex(0);
					comboBoxHour.setSelectedIndex(0);
					comboBoxMinute.setSelectedIndex(0);
					textMessage.setText("");
				}
			}
		});
		frmRemainderclock.getContentPane().add(btnSet);

		JMenuBar menuBar = new JMenuBar();
		frmRemainderclock.setJMenuBar(menuBar);

		JMenu mnAbout = new JMenu("Help");
		menuBar.add(mnAbout);

	}
}
