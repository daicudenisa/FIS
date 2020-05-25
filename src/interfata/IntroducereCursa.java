package interfata;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class IntroducereCursa extends JFrame {

	private JPanel contentPane;
	private JTextField txtOrasPlecare;
	private JTextField txtOrasSosire;
	private JTextField txtOraPlecare;
	private JTextField txtOraSosire;

	Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntroducereCursa frame = new IntroducereCursa();
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
	public IntroducereCursa() {
		con=conectareDB.Connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Oras Plecare");
		lblNewLabel.setBounds(10, 32, 90, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Oras Sosire");
		lblNewLabel_1.setBounds(10, 65, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ora Plecare");
		lblNewLabel_2.setBounds(10, 100, 69, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ora Sosire");
		lblNewLabel_3.setBounds(10, 132, 69, 14);
		contentPane.add(lblNewLabel_3);
		
		txtOrasPlecare = new JTextField();
		txtOrasPlecare.setBounds(99, 29, 277, 20);
		contentPane.add(txtOrasPlecare);
		txtOrasPlecare.setColumns(10);
		
		txtOrasSosire = new JTextField();
		txtOrasSosire.setBounds(99, 62, 277, 20);
		contentPane.add(txtOrasSosire);
		txtOrasSosire.setColumns(10);
		
		txtOraPlecare = new JTextField();
		txtOraPlecare.setBounds(99, 97, 277, 20);
		contentPane.add(txtOraPlecare);
		txtOraPlecare.setColumns(10);
		
		txtOraSosire = new JTextField();
		txtOraSosire.setBounds(99, 129, 277, 20);
		contentPane.add(txtOraSosire);
		txtOraSosire.setColumns(10);
		
		JButton btnAdaugare = new JButton("Adaugare");
		btnAdaugare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into Zboruri (OrasPlecare,OrasSosire,OraPlecare,OraSosire)values(?,?,?,?)";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setString(1, txtOrasPlecare.getText());
					pst.setString(2, txtOrasSosire.getText());
					pst.setString(3, txtOraPlecare.getText());
					pst.setString(4, txtOraSosire.getText());
					
					pst.execute();
					dispose();
					new FrameCompanie().setVisible(true);
					JOptionPane.showConfirmDialog(null, "salvat");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdaugare.setBounds(167, 197, 89, 23);
		contentPane.add(btnAdaugare);
	}
}
