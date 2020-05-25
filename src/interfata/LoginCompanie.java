package interfata;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class LoginCompanie extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

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
					LoginCompanie frame = new LoginCompanie();
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
	public LoginCompanie() {
		con =conectareDB.Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 382, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 14, 31, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(41, 11, 116, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Parola");
		lblNewLabel_1.setBounds(185, 14, 58, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(241, 11, 116, 20);
		contentPane.add(passwordField);
		
		JButton btnConectare = new JButton("Conectare");
		btnConectare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id=textField.getText();
				String pass=passwordField.getText();
				
				try {
					
					String query="select ID,Parola from Companie where (ID=? and Parola=?)";
					PreparedStatement pst=con.prepareStatement(query);
					
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs=pst.executeQuery();
					int i=0;
					while(rs.next()) {
						i++;
					}
					if(i==1) {
						JOptionPane.showMessageDialog(null, "Autentificare Reusita");
						new FrameCompanie().setVisible(true);
						dispose();
					}
					else if(i>1) {
						JOptionPane.showMessageDialog(null, "Try again");
					}
					else {
						JOptionPane.showMessageDialog(null, "Autentificare esuata");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnConectare.setBounds(127, 59, 118, 23);
		contentPane.add(btnConectare);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Denisa\\eclipse-workspace\\FIS\\login_icon.png"));
		lblNewLabel_2.setBounds(10, 39, 245, 260);
		contentPane.add(lblNewLabel_2);
	}
}
