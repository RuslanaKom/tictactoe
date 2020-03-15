package ui;

import app.CombinationsChecker;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class DefaultGrid extends JFrame {

	private JPanel contentPane;
	private char[][] board = new char[3][3];
	private char playingSide;
	private boolean playerX = true;
	private CombinationsChecker checker = new CombinationsChecker();
	private String result = "";
	private JLabel victoryLabel;
	private List<JButton> buttonGroup = new ArrayList<>();
	private List<JRadioButton> buttonGroup_1 = new ArrayList<>();

	public DefaultGrid() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		victoryLabel = new JLabel("");
		victoryLabel.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				String property = event.getPropertyName();

			}
		});
		victoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		victoryLabel.setForeground(Color.BLUE);
		victoryLabel.setBounds(171, 322, 157, 20);
		contentPane.add(victoryLabel);

		JButton btn1 = new JButton("");
		buttonGroup.add(btn1);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkWhichSidePlaysNow();
				if (board[0][0] == 0) {
					board[0][0] = playingSide;
					turnLogic(board, playingSide, result, btn1);
				}
			}
		});

		btn1.setBounds(15, 16, 103, 95);
		contentPane.add(btn1);

		JButton btn2 = new JButton("");
		buttonGroup.add(btn2);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkWhichSidePlaysNow();
				if (board[1][0] == 0) {
					board[1][0] = playingSide;
					turnLogic(board, playingSide, result, btn2);
				}
			}
		});
		btn2.setBounds(15, 114, 103, 95);
		contentPane.add(btn2);

		JButton btn3 = new JButton("");
		buttonGroup.add(btn3);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkWhichSidePlaysNow();
				if (board[2][0] == 0) {
					board[2][0] = playingSide;
					turnLogic(board, playingSide, result, btn3);
				}
			}
		});
		btn3.setBounds(15, 211, 103, 95);
		contentPane.add(btn3);

		JButton btn4 = new JButton("");
		buttonGroup.add(btn4);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkWhichSidePlaysNow();
				if (board[0][1] == 0) {
					board[0][1] = playingSide;
					turnLogic(board, playingSide, result, btn4);
				}
			}
		});
		btn4.setBounds(120, 16, 103, 95);
		contentPane.add(btn4);

		JButton btn5 = new JButton("");
		buttonGroup.add(btn5);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkWhichSidePlaysNow();
				if (board[1][1] == 0) {
					board[1][1] = playingSide;
					turnLogic(board, playingSide, result, btn5);
				}
			}
		});
		btn5.setBounds(120, 114, 103, 95);
		contentPane.add(btn5);

		JButton btn6 = new JButton("");
		buttonGroup.add(btn6);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkWhichSidePlaysNow();
				if (board[2][1] == 0) {
					board[2][1] = playingSide;
					turnLogic(board, playingSide, result, btn6);
				}
			}
		});
		btn6.setBounds(120, 211, 103, 95);
		contentPane.add(btn6);

		JButton btn7 = new JButton("");
		buttonGroup.add(btn7);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkWhichSidePlaysNow();
				if (board[0][2] == 0) {
					board[0][2] = playingSide;
					turnLogic(board, playingSide, result, btn7);
				}
			}
		});
		btn7.setBounds(225, 16, 103, 95);
		contentPane.add(btn7);

		JButton btn8 = new JButton("");
		buttonGroup.add(btn8);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkWhichSidePlaysNow();
				if (board[1][2] == 0) {
					board[1][2] = playingSide;
					turnLogic(board, playingSide, result, btn8);
				}
			}
		});
		btn8.setBounds(225, 114, 103, 95);
		contentPane.add(btn8);

		JButton btn9 = new JButton("");
		buttonGroup.add(btn9);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkWhichSidePlaysNow();
				if (board[2][2] == 0) {
					board[2][2] = playingSide;
					turnLogic(board, playingSide, result, btn9);
				}
			}
		});

		btn9.setBounds(225, 211, 103, 95);
		contentPane.add(btn9);

		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartGame();
			}
		});
		btnNewButton.setBounds(15, 419, 115, 29);
		contentPane.add(btnNewButton);

		JRadioButton rdbtnX = new JRadioButton("X");
		JRadioButton rdbtnO = new JRadioButton("O");
		buttonGroup_1.add(rdbtnX);
		buttonGroup_1.add(rdbtnO);

		rdbtnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playingSide = 'x';
				playerX = true;
				rdbtnO.setEnabled(false);
			}
		});
		rdbtnX.setBounds(11, 362, 52, 29);
		contentPane.add(rdbtnX);

		rdbtnO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playingSide = 'y';
				playerX = false;
				rdbtnX.setEnabled(false);
			}
		});
		buttonGroup_1.add(rdbtnO);
		rdbtnO.setBounds(59, 362, 95, 29);
		contentPane.add(rdbtnO);
		
		JLabel lblSide = new JLabel("Side:");
		lblSide.setBounds(15, 330, 69, 20);
		contentPane.add(lblSide);
	}

	private void checkWhichSidePlaysNow() {
		if (playerX) {
			playingSide = 'x';
		} else {
			playingSide = 'o';
		}
	}

	private void turnLogic(char[][] board, char playingSide, String result, JButton btn) {
		btn.setText(String.valueOf(playingSide));
		btn.setFont(new Font("Arial", Font.PLAIN, 40));
		result = checker.whoIsTheWinner(board, playingSide);
		playerX = !playerX;
		victoryLabel.setText(result);
		victoryDisablesButtons(result);
	}

	private void restartGame() {
		board = new char[3][3];
		playingSide = 0;
		playerX = true;
		result = "";
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

	public char getPlayingSide() {
		return playingSide;
	}

	public void setPlayingSide(char playingSide) {
		this.playingSide = playingSide;
	}

	public boolean isPlayerX() {
		return playerX;
	}

	public void setPlayerX(boolean playerX) {
		this.playerX = playerX;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public JLabel getVictoryLabel() {
		return victoryLabel;
	}

	public void setVictoryLabel(JLabel victoryLabel) {
		this.victoryLabel = victoryLabel;
	}
}
