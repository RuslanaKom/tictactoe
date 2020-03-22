package ui;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

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

		JButton btn1 = new JButton("3x3");
		btn1.setBounds(60, 123, 161, 37);
		frame.getContentPane().add(btn1);

		JButton btn2 = new JButton("5x5");
		btn2.setBounds(247, 123, 161, 37);
		frame.getContentPane().add(btn2);

		btn1.addActionListener(e -> {
			DefaultGrid grid3=new DefaultGrid();
			grid3.setVisible(true);
			btn1.setEnabled(false);
			btn2.setEnabled(false);
		});

		btn2.addActionListener(e -> {
			Grid5x5 grid5x5=new Grid5x5();
			grid5x5.setVisible(true);
			btn1.setEnabled(false);
			btn2.setEnabled(false);
		});
	}
}
