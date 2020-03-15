package ui;

import app.CombinationsChecker;
import app.ComputerMove;
import app.Position;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultGrid extends JFrame {

	private JPanel contentPane;
	private char[][] board = new char[3][3];
	private char playingSide;
	private boolean playerX = true;
	private CombinationsChecker checker = new CombinationsChecker();
	private JLabel victoryLabel;
	private List<JButton> buttonGroup = new ArrayList<>();
	private List<JRadioButton> buttonGroup_1 = new ArrayList<>();
	private ComputerMove computerMove = new ComputerMove();
	private int movesCount;
	private Map<String, JButton> buttonsPositionsInBoard = new HashMap<>();

	public DefaultGrid() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		victoryLabel = new JLabel("");
		victoryLabel.addPropertyChangeListener(event -> {
			String property = event.getPropertyName();

		});
		victoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		victoryLabel.setForeground(Color.BLUE);
		victoryLabel.setBounds(171, 322, 157, 20);
		contentPane.add(victoryLabel);

		JButton btn1 = new JButton("");
		buttonGroup.add(btn1);
		btn1.addActionListener(e -> {
			checkWhichSidePlaysNow();
			if (board[0][0] == 0) {
				board[0][0] = playingSide;
				turnLogic(board, playingSide, btn1);
				computerMove();
			}
		});
		btn1.setBounds(15, 16, 103, 95);
		contentPane.add(btn1);

		JButton btn2 = new JButton("");
		buttonGroup.add(btn2);
		btn2.addActionListener(e -> {
			checkWhichSidePlaysNow();
			if (board[0][1] == 0) {
				board[0][1] = playingSide;
				turnLogic(board, playingSide, btn2);
				computerMove();
			}
		});
		btn2.setBounds(15, 114, 103, 95);
		contentPane.add(btn2);

		JButton btn3 = new JButton("");
		buttonGroup.add(btn3);
		btn3.addActionListener(e -> {
			checkWhichSidePlaysNow();
			if (board[0][2] == 0) {
				board[0][2] = playingSide;
				turnLogic(board, playingSide, btn3);
				computerMove();
			}
		});
		btn3.setBounds(15, 211, 103, 95);
		contentPane.add(btn3);

		JButton btn4 = new JButton("");
		buttonGroup.add(btn4);
		btn4.addActionListener(e -> {
			checkWhichSidePlaysNow();
			if (board[1][0] == 0) {
				board[1][0] = playingSide;
				turnLogic(board, playingSide, btn4);
				computerMove();
			}
		});
		btn4.setBounds(120, 16, 103, 95);
		contentPane.add(btn4);

		JButton btn5 = new JButton("");
		buttonGroup.add(btn5);
		btn5.addActionListener(e -> {
			checkWhichSidePlaysNow();
			if (board[1][1] == 0) {
				board[1][1] = playingSide;
				turnLogic(board, playingSide, btn5);
				computerMove();
			}
		});
		btn5.setBounds(120, 114, 103, 95);
		contentPane.add(btn5);

		JButton btn6 = new JButton("");
		buttonGroup.add(btn6);
		btn6.addActionListener(e -> {
			checkWhichSidePlaysNow();
			if (board[1][2] == 0) {
				board[1][2] = playingSide;
				turnLogic(board, playingSide, btn6);
				computerMove();
			}
		});
		btn6.setBounds(120, 211, 103, 95);
		contentPane.add(btn6);

		JButton btn7 = new JButton("");
		buttonGroup.add(btn7);
		btn7.addActionListener(e -> {
			checkWhichSidePlaysNow();
			if (board[2][0] == 0) {
				board[2][0] = playingSide;
				turnLogic(board, playingSide, btn7);
				computerMove();
			}
		});
		btn7.setBounds(225, 16, 103, 95);
		contentPane.add(btn7);

		JButton btn8 = new JButton("");
		buttonGroup.add(btn8);
		btn8.addActionListener(e -> {
			checkWhichSidePlaysNow();
			if (board[2][1] == 0) {
				board[2][1] = playingSide;
				turnLogic(board, playingSide, btn8);
				computerMove();
			}
		});
		btn8.setBounds(225, 114, 103, 95);
		contentPane.add(btn8);

		JButton btn9 = new JButton("");
		buttonGroup.add(btn9);
		btn9.addActionListener(e -> {
			checkWhichSidePlaysNow();
			if (board[2][2] == 0) {
				board[2][2] = playingSide;
				turnLogic(board, playingSide, btn9);
				computerMove();
			}
		});

		btn9.setBounds(225, 211, 103, 95);
		contentPane.add(btn9);

		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(e -> restartGame());
		btnNewButton.setBounds(15, 419, 115, 29);
		contentPane.add(btnNewButton);

		JRadioButton rdbtnX = new JRadioButton("X");
		JRadioButton rdbtnO = new JRadioButton("O");
		buttonGroup_1.add(rdbtnX);
		buttonGroup_1.add(rdbtnO);

		rdbtnX.addActionListener(e -> {
			playingSide = 'x';
			playerX = true;
			rdbtnO.setEnabled(false);
		});
		rdbtnX.setBounds(11, 362, 52, 29);
		contentPane.add(rdbtnX);

		rdbtnO.addActionListener(e -> {
			playingSide = 'o';
			playerX = false;
			rdbtnX.setEnabled(false);
		});
		buttonGroup_1.add(rdbtnO);
		rdbtnO.setBounds(59, 362, 95, 29);
		contentPane.add(rdbtnO);

		JLabel lblSide = new JLabel("Side:");
		lblSide.setBounds(15, 330, 69, 20);
		contentPane.add(lblSide);

		buttonsPositionsInBoard.put("00", btn1);
		buttonsPositionsInBoard.put("01", btn2);
		buttonsPositionsInBoard.put("02", btn3);
		buttonsPositionsInBoard.put("10", btn4);
		buttonsPositionsInBoard.put("11", btn5);
		buttonsPositionsInBoard.put("12", btn6);
		buttonsPositionsInBoard.put("20", btn7);
		buttonsPositionsInBoard.put("21", btn8);
		buttonsPositionsInBoard.put("22", btn9);
	}

	private void checkWhichSidePlaysNow() {
		if (playerX) {
			playingSide = 'x';
		} else {
			playingSide = 'o';
		}
	}

	private void turnLogic(char[][] board, char playingSide, JButton btn) {
		btn.setText(String.valueOf(playingSide));
		btn.setFont(new Font("Arial", Font.PLAIN, 40));
		String result = checker.whoIsTheWinner(board, playingSide);
		playerX = !playerX;
		victoryLabel.setText(result);
		victoryDisablesButtons(result);
	}

	private void restartGame() {
		board = new char[3][3];
		playingSide = 0;
		playerX = true;
		victoryLabel.setText("");
		buttonGroup.forEach(b -> {
			b.setEnabled(true);
			b.setText("");
		});
		buttonGroup_1.forEach(b -> {
			b.setEnabled(true);
			b.setSelected(false);
		});
	}

	private void victoryDisablesButtons(String result) {
		if (result.contains("Winner")) {
			buttonGroup.forEach(b -> b.setEnabled(false));
		}
	}

	private void computerMove() {
		checkWhichSidePlaysNow();
		Position position = computerMove.makeComputerMove(board, movesCount, playingSide);
		JButton button = buttonsPositionsInBoard.get(position.createXY());
		turnLogic(board, playingSide, button);
	}
}
