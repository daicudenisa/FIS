package interfata;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.ImageIcon;

public class RezervariClienti extends JFrame {

	
	Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
	
	private JPanel contentPane;
	private JTextField txtCNP;
	private JTextField txtNume;
	private JTextField txtPrenume;
	private JTextField txtTelefon;
	private JTextField txtEmail;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox comboBoxOrasPlecare;
	private JComboBox comboBoxOraPlecare;
	private JComboBox comboBoxOraSosire;
	private JComboBox comboBoxOrasSosire;
	private JDateChooser datePlecare;
	private JDateChooser dateSosire ;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RezervariClienti frame = new RezervariClienti();
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
	public RezervariClienti() {
		con =conectareDB.Connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 571, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCNP = new JLabel("CNP");
		lblCNP.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblCNP.setBounds(10, 11, 46, 14);
		contentPane.add(lblCNP);
		
		txtCNP = new JTextField();
		txtCNP.setBounds(106, 8, 177, 20);
		contentPane.add(txtCNP);
		txtCNP.setColumns(10);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNume.setBounds(10, 53, 46, 14);
		contentPane.add(lblNume);
		
		txtNume = new JTextField();
		txtNume.setBounds(106, 50, 177, 20);
		contentPane.add(txtNume);
		txtNume.setColumns(10);
		
		JLabel lblPrenume = new JLabel("Prenume");
		lblPrenume.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblPrenume.setBounds(10, 90, 86, 14);
		contentPane.add(lblPrenume);
		
		txtPrenume = new JTextField();
		txtPrenume.setBounds(106, 87, 177, 20);
		contentPane.add(txtPrenume);
		txtPrenume.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblTelefon.setBounds(10, 130, 46, 14);
		contentPane.add(lblTelefon);
		
		txtTelefon = new JTextField();
		txtTelefon.setBounds(106, 127, 177, 20);
		contentPane.add(txtTelefon);
		txtTelefon.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblEmail.setBounds(10, 167, 46, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(106, 164, 177, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblVarsta = new JLabel("Varsta");
		lblVarsta.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblVarsta.setBounds(10, 202, 46, 14);
		contentPane.add(lblVarsta);
		
		textField = new JTextField();
		textField.setBounds(106, 199, 177, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Numerar", "Card"}));
		comboBox.setBounds(412, 87, 102, 20);
		contentPane.add(comboBox);
		
		JLabel lblPlata = new JLabel("Plata");
		lblPlata.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblPlata.setBounds(333, 90, 46, 14);
		contentPane.add(lblPlata);
		
		JLabel lblOrasPlecare = new JLabel("Oras Plecare");
		lblOrasPlecare.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblOrasPlecare.setBounds(10, 240, 86, 14);
		contentPane.add(lblOrasPlecare);
		fillcomboboxOrasPlecare();
		
		comboBoxOrasPlecare = new JComboBox();
		comboBoxOrasPlecare.setBounds(106, 237, 177, 20);
		contentPane.add(comboBoxOrasPlecare);
		
		JLabel lblOrasSosire = new JLabel("Oras Sosire");
		lblOrasSosire.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblOrasSosire.setBounds(10, 277, 66, 14);
		contentPane.add(lblOrasSosire);
		
		comboBoxOrasSosire = new JComboBox();
		comboBoxOrasSosire.setBounds(106, 274, 177, 20);
		contentPane.add(comboBoxOrasSosire);
		
		JLabel lblOraPlecare = new JLabel("Ora Plecare");
		lblOraPlecare.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblOraPlecare.setBounds(10, 313, 66, 14);
		contentPane.add(lblOraPlecare);
		
		JLabel lblOraSosire = new JLabel("Ora Sosire");
		lblOraSosire.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblOraSosire.setBounds(10, 345, 66, 14);
		contentPane.add(lblOraSosire);
		
		JLabel lblDataPlecarii = new JLabel("Data Plecare");
		lblDataPlecarii.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblDataPlecarii.setBounds(333, 130, 89, 14);
		contentPane.add(lblDataPlecarii);
		
		JLabel lblDataSosire = new JLabel("Data Sosire");
		lblDataSosire.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblDataSosire.setBounds(333, 167, 89, 14);
		contentPane.add(lblDataSosire);
		
		JLabel lblNumarLocuri = new JLabel("Numar de locuri");
		lblNumarLocuri.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNumarLocuri.setBounds(333, 202, 122, 14);
		contentPane.add(lblNumarLocuri);
		
		textField_1 = new JTextField();
		textField_1.setBounds(445, 199, 57, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tip Zbor");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel.setBounds(336, 11, 86, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBoxTipZbor = new JComboBox();
		comboBoxTipZbor.setModel(new DefaultComboBoxModel(new String[] {"Dus", "Dus/Intors"}));
		comboBoxTipZbor.setBounds(412, 8, 102, 20);
		contentPane.add(comboBoxTipZbor);
		
		JLabel lblNewLabel_1 = new JLabel("Clasa");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(336, 53, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Business", "Economic"}));
		comboBox_1.setBounds(412, 50, 102, 20);
		contentPane.add(comboBox_1);
		
		JButton btnRezerva = new JButton("Rezerva");
		btnRezerva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="insert into Rezervari (CNP,Nume,Prenume,Telefon,Email,Varsta,OrasPlecare,OrasSosile,DataPlecare,DataSosire,OraPlecare,OraSosire,NumarLocuri,Clasa,TipZbor,Plata)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement pst=con.prepareStatement(query);
					
					
					String strDate =datePlecare.getDate().toString();
					String strDate2=dateSosire.getDate().toString();
					
					pst.setString(1, txtCNP.getText());
					pst.setString(2, txtNume.getText());
					pst.setString(4, txtTelefon.getText());
					pst.setString(3, txtPrenume.getText());
					pst.setString(5, txtEmail.getText());
					pst.setInt(6, Integer.parseInt(textField.getText()));
					pst.setString(7, comboBoxOrasPlecare.getSelectedItem().toString());
					pst.setString(8, comboBoxOrasSosire.getSelectedItem().toString());
					pst.setString(9, strDate);
					pst.setString(10, strDate2);
					pst.setString(11, comboBoxOraPlecare.getSelectedItem().toString());
					pst.setString(12, comboBoxOraSosire.getSelectedItem().toString());
					pst.setInt(13, Integer.parseInt(textField_1.getText()));
					pst.setString(14, comboBox_1.getSelectedItem().toString());
					pst.setString(15, comboBoxTipZbor.getSelectedItem().toString());
					pst.setString(16, comboBox.getSelectedItem().toString());
					
					pst.execute();
					JOptionPane.showConfirmDialog(null, "Confirmati rezervarea?");
					dispose();
					new MainFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnRezerva.setBounds(382, 309, 89, 23);
		contentPane.add(btnRezerva);
		
		comboBoxOraPlecare = new JComboBox();
		comboBoxOraPlecare.setBounds(106, 310, 98, 20);
		contentPane.add(comboBoxOraPlecare);
		
		comboBoxOraSosire = new JComboBox();
		comboBoxOraSosire.setBounds(106, 342, 102, 20);
		contentPane.add(comboBoxOraSosire);
		
		datePlecare = new JDateChooser();
		datePlecare.setDateFormatString("dd.mm.yyyy");
		datePlecare.setBounds(412, 130, 91, 20);
		contentPane.add(datePlecare);
		
		dateSosire = new JDateChooser();
		dateSosire.setDateFormatString("dd.mm.yyyy");
		dateSosire.setBounds(412, 167, 91, 20);
		contentPane.add(dateSosire);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Denisa\\eclipse-workspace\\FIS\\cloud-background-9.jpg"));
		lblNewLabel_2.setBounds(0, 0, 555, 459);
		contentPane.add(lblNewLabel_2);
		
		fillcomboboxOrasPlecare();
		fillcomboboxOrasSosire();
		fillcomboboxOraSosire();
		fillcomboboxOraPlecare();
	}
	
	
	public void fillcomboboxOrasPlecare() {
		try {
			String query="SELECT * FROM Zboruri";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				comboBoxOrasPlecare.addItem(rs.getString(1));
			}
			
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
		}
	}
	
	
	public void fillcomboboxOrasSosire() {
		try {
			String query="SELECT * FROM Zboruri";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				comboBoxOrasSosire.addItem(rs.getString(2));
			}
			
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
		}
	}
	
	
	public void fillcomboboxOraSosire() {
		try {
			String query="SELECT * FROM Zboruri";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				comboBoxOraSosire.addItem(rs.getString(4));
			}
			
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
		}
	}
	
	public void fillcomboboxOraPlecare() {
		try {
			String query="SELECT * FROM Zboruri";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				comboBoxOraPlecare.addItem(rs.getString(3));
			}
			
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, e);
		}
	}
}
