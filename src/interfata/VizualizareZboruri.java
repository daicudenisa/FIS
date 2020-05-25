package interfata;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class VizualizareZboruri extends JFrame {

	private JPanel contentPane;
	Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VizualizareZboruri frame = new VizualizareZboruri();
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
	public VizualizareZboruri() {
		con =conectareDB.Connect();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUpdateTable = new JButton("Incarcare date despre zboruri");
		btnUpdateTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
				String query="select OrasPlecare,OrasSosile,DataPlecare,DataSosire,OraPlecare,OraSosire from Rezervari";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				JOptionPane.showConfirmDialog(null, "Incarcare date reusita");
				
				}
				catch(Exception e) {
					
					JOptionPane.showConfirmDialog(null, e);
				}
			}
		});
		btnUpdateTable.setBounds(0, 0, 784, 23);
		contentPane.add(btnUpdateTable);
		
		table = new JTable();
		table.setBounds(0, 22, 784, 239);
		contentPane.add(table);
	}
}
