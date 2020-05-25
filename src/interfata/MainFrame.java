package interfata;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setForeground(Color.BLACK);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 175);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(SystemColor.controlHighlight);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnClient = new JButton("Client");
		btnClient.setBackground(SystemColor.controlHighlight);
		btnClient.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnClient.setForeground(Color.BLACK);
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new RezervariClienti().setVisible(true);
			}
		});
		btnClient.setBounds(58, 102, 135, 23);
		contentPane.add(btnClient);
		
		JButton btnCompanie = new JButton("Companie");
		btnCompanie.setBackground(SystemColor.controlHighlight);
		btnCompanie.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnCompanie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginCompanie().setVisible(true);
			}
		});
		btnCompanie.setBounds(249, 102, 135, 23);
		contentPane.add(btnCompanie);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Denisa\\eclipse-workspace\\FIS\\Webp.net-resizeimage (1).png"));
		lblNewLabel.setBounds(160, 0, 119, 91);
		contentPane.add(lblNewLabel);
	}
}
