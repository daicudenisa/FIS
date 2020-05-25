package interfata;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrameCompanie extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCompanie frame = new FrameCompanie();
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
	public FrameCompanie() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 161);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIntroducereCursa = new JButton("Introduceti cursa noua");
		btnIntroducereCursa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IntroducereCursa().setVisible(true);
			}
		});
		btnIntroducereCursa.setBounds(0, 65, 434, 23);
		contentPane.add(btnIntroducereCursa);
		
		JButton btnVizualizareZboruri = new JButton("Vizualizare Zboruri");
		btnVizualizareZboruri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new VizualizareZboruri().setVisible(true);
			}
		});
		btnVizualizareZboruri.setBounds(0, 88, 434, 23);
		contentPane.add(btnVizualizareZboruri);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.ITALIC, 27));
		lblNewLabel.setBounds(0, 11, 434, 43);
		contentPane.add(lblNewLabel);
	}
}
