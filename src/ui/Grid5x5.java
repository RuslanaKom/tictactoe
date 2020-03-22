package ui;

import app.CombinationsChecker;
import app.ComputerMove;
import app.Position;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.*;

public class Grid5x5 extends JFrame {

    private JPanel contentPane;
    private char[][] board = new char[5][5];
    private char playingSide;
    private boolean playerX = true;
    private CombinationsChecker checker = new CombinationsChecker();
    private JLabel victoryLabel;
    private java.util.List<JButton> buttonGroup = new ArrayList<>();
    private List<JRadioButton> buttonGroup_1 = new ArrayList<>();
    private ComputerMove computerMove = new ComputerMove();
    private int movesCount;
    private Map<String, JButton> buttonsPositionsInBoard = new HashMap<>();

    public Grid5x5() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 583, 673);
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
        victoryLabel.setBounds(250, 550, 157, 20);
        contentPane.add(victoryLabel);

        JButton btn1 = new JButton("");
        btn1.setBounds(15, 16, 103, 95);

        JButton btn2 = new JButton("");
        btn2.setBounds(120, 16, 103, 95);

        JButton btn3 = new JButton("");
        btn3.setBounds(225, 16, 103, 95);

        JButton btn4 = new JButton("");
        btn4.setBounds(329, 16, 103, 95);

        JButton btn5 = new JButton("");
        btn5.setBounds(434, 16, 103, 95);

        JButton btn6 = new JButton("");
        btn6.setBounds(15, 115, 103, 95);

        JButton btn7 = new JButton("");
        btn7.setBounds(120, 115, 103, 95);

        JButton btn8 = new JButton("");
        btn8.setBounds(225, 115, 103, 95);

        JButton btn9 = new JButton("");
        btn9.setBounds(329, 115, 103, 95);

        JButton btn10 = new JButton("");
        btn10.setBounds(434, 115, 103, 95);

        JButton btn11 = new JButton("");
        btn11.setBounds(15, 213, 103, 95);

        JButton btn12 = new JButton("");
        btn12.setBounds(120, 213, 103, 95);

        JButton btn13 = new JButton("");
        btn13.setBounds(225, 213, 103, 95);

        JButton btn14 = new JButton("");
        btn14.setBounds(329, 213, 103, 95);

        JButton btn15 = new JButton("");
        btn15.setBounds(434, 213, 103, 95);

        JButton btn16 = new JButton("");
        btn16.setBounds(15, 309, 103, 95);

        JButton btn17 = new JButton("");
        btn17.setBounds(120, 309, 103, 95);

        JButton btn18 = new JButton("");
        btn18.setBounds(225, 309, 103, 95);

        JButton btn19 = new JButton("");
        btn19.setBounds(329, 309, 103, 95);

        JButton btn20 = new JButton("");
        btn20.setBounds(434, 309, 103, 95);

        JButton btn21 = new JButton("");
        btn21.setBounds(15, 406, 103, 95);

        JButton btn22 = new JButton("");
        btn22.setBounds(120, 406, 103, 95);

        JButton btn23 = new JButton("");
        btn23.setBounds(225, 406, 103, 95);

        JButton btn24 = new JButton("");
        btn24.setBounds(329, 406, 103, 95);

        JButton btn25 = new JButton("");
        btn25.setBounds(434, 406, 103, 95);

        JRadioButton rdbtnX = new JRadioButton("X");
        rdbtnX.setSelected(true);

        JRadioButton rdbtnO = new JRadioButton("O");

        rdbtnX.addActionListener(e -> {
            playingSide = 'x';
            playerX = true;
            rdbtnO.setEnabled(false);
        });
        rdbtnX.setBounds(15, 550, 52, 29);

        rdbtnO.addActionListener(e -> {
            playingSide = 'o';
            playerX = false;
            rdbtnX.setEnabled(false);
            rdbtnX.setSelected(false);
        });
        rdbtnO.setBounds(66, 550, 52, 29);

        JLabel lblSide = new JLabel("Side:");
        lblSide.setBounds(15, 520, 69, 20);

        JButton btnNewButton = new JButton("New Game");
        btnNewButton.addActionListener(e -> restartGame(rdbtnX));
        btnNewButton.setBounds(15, 590, 115, 29);

        contentPane.add(btnNewButton);
        contentPane.add(rdbtnX);
        contentPane.add(lblSide);
        contentPane.add(rdbtnO);
        contentPane.add(btn1);
        contentPane.add(btn2);
        contentPane.add(btn3);
        contentPane.add(btn4);
        contentPane.add(btn5);
        contentPane.add(btn6);
        contentPane.add(btn7);
        contentPane.add(btn8);
        contentPane.add(btn9);
        contentPane.add(btn10);
        contentPane.add(btn11);
        contentPane.add(btn12);
        contentPane.add(btn13);
        contentPane.add(btn14);
        contentPane.add(btn15);
        contentPane.add(btn16);
        contentPane.add(btn17);
        contentPane.add(btn18);
        contentPane.add(btn19);
        contentPane.add(btn20);
        contentPane.add(btn21);
        contentPane.add(btn22);
        contentPane.add(btn23);
        contentPane.add(btn24);
        contentPane.add(btn25);

        buttonsPositionsInBoard.put("00", btn1);
        buttonsPositionsInBoard.put("01", btn2);
        buttonsPositionsInBoard.put("02", btn3);
        buttonsPositionsInBoard.put("03", btn4);
        buttonsPositionsInBoard.put("04", btn5);
        buttonsPositionsInBoard.put("10", btn6);
        buttonsPositionsInBoard.put("11", btn7);
        buttonsPositionsInBoard.put("12", btn8);
        buttonsPositionsInBoard.put("13", btn9);
        buttonsPositionsInBoard.put("14", btn10);
        buttonsPositionsInBoard.put("20", btn11);
        buttonsPositionsInBoard.put("21", btn12);
        buttonsPositionsInBoard.put("22", btn13);
        buttonsPositionsInBoard.put("23", btn14);
        buttonsPositionsInBoard.put("24", btn15);
        buttonsPositionsInBoard.put("30", btn16);
        buttonsPositionsInBoard.put("31", btn17);
        buttonsPositionsInBoard.put("32", btn18);
        buttonsPositionsInBoard.put("33", btn19);
        buttonsPositionsInBoard.put("34", btn20);
        buttonsPositionsInBoard.put("40", btn21);
        buttonsPositionsInBoard.put("41", btn22);
        buttonsPositionsInBoard.put("42", btn23);
        buttonsPositionsInBoard.put("43", btn24);
        buttonsPositionsInBoard.put("44", btn25);

        buttonGroup.addAll(Arrays.asList(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11,
                btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22, btn23, btn24, btn25));
        buttonGroup_1.addAll(Arrays.asList(rdbtnX,rdbtnO));

        ActionListener pushListener = e -> {
            JButton button = (JButton) e.getSource();
            String pos = getKey(buttonsPositionsInBoard, button);
            int x = Integer.valueOf(pos.substring(0, 1));
            int y = Integer.valueOf(pos.substring(1));
            checkWhichSidePlaysNow();

            if (board[x][y] == 0) {
                board[x][y] = playingSide;
                turnLogic(board, playingSide, button);
                movesCount++;
                computerMove();
            }
        };
        buttonGroup.forEach(b -> b.addActionListener(pushListener));
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

    private void restartGame(JRadioButton button) {
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
        movesCount = 0;
        button.setSelected(true);
    }

    private void victoryDisablesButtons(String result) {
        if (result.contains("Winner")) {
            buttonGroup.forEach(b -> b.setEnabled(false));
        }
    }

    private void computerMove() {
        if (!checker.whoIsTheWinner(board, playingSide).contains("Next turn")) {
            return;
        }
        checkWhichSidePlaysNow();
        Position position = computerMove.makeComputerMove(board, movesCount, playingSide);
        JButton button = buttonsPositionsInBoard.get(position.createXY());
        turnLogic(board, playingSide, button);
        movesCount++;
    }

    private <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }
}