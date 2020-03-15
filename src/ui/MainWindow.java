package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenuBar;
import java.awt.List;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Set<Character> uniqueChars = new HashSet<Character>();
		uniqueChars.add('\u0000');
		uniqueChars.forEach(e->System.out.println(e));
		EventQueue.invokeLater(() -> {
			try {
				MainWindow window = new MainWindow();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTicTacToe = new JLabel("TIC TAC TOE");
		lblTicTacToe.setForeground(Color.BLUE);
		lblTicTacToe.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTicTacToe.setBounds(171, 28, 139, 37);
		frame.getContentPane().add(lblTicTacToe);
		
		JLabel lblDevelopedByIkirsanov = new JLabel("Developed by I.Kirsanov Heavy Industries Inc.");
		lblDevelopedByIkirsanov.setForeground(Color.BLACK);
		lblDevelopedByIkirsanov.setBounds(103, 239, 333, 20);
		frame.getContentPane().add(lblDevelopedByIkirsanov);
		
		JButton btnx = new JButton("PLAY");
		btnx.addActionListener(e -> {
			DefaultGrid grid3=new DefaultGrid();
			grid3.setVisible(true);

		});
		btnx.setBounds(164, 123, 161, 37);
		frame.getContentPane().add(btnx);
	}
}
