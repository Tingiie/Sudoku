package sudoku;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SudokuGUI extends JFrame {
	private SudokuGUI gui;
	private JTextArea messageArea;
	private JTextField[][] JGrid;
	private JPanel sudokuPanel;

	
	/** 
	 * Creates a GUI for the Sudoku
	 * @param s, an object that solves the Sudoku
	 * */
	public SudokuGUI(SudokuSolver s) {
		gui = this;

		sudokuPanel = new JPanel();
		JFrame frame = new JFrame("Sudoku");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// numberPanel
		JPanel numberPanel = new JPanel();
		frame.add(numberPanel, BorderLayout.SOUTH);

		// Buttons
		JButton clear = new JButton("Clear");
		JButton solve = new JButton("Solve");
		numberPanel.add(clear);
		numberPanel.add(solve);
		clear.addActionListener(new ClearButtonListener(s, gui));
		solve.addActionListener(new SolveButtonListener(s, gui));

		// northPanel with messageArea
		JPanel northPanel = new JPanel();
		messageArea = new JTextArea(2, 25);
		messageArea.setEditable(false);
		northPanel.add(new JScrollPane(messageArea));
		messageArea.setText("   Fill in the numbers you wish to be solved");
		frame.add(northPanel, BorderLayout.NORTH);

		// Creates sudoku cells
		JTextField[][] input = gui.sudokuCells(sudokuPanel);
		JGrid = input;

		// Set boxes to grey
		gui.setGrey(input);

		frame.add(sudokuPanel);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Prints the message 's' on the messageArea
	 * @param s, the message to be printed 
	 */
	public void printMessage(String s) {
		messageArea.setText(s);
	}

	/** 
	 * Prints the grid on the SudokuGUI
	 * @param grid, the grid to be printed
	 * */
	public void print(Integer[][] grid) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				JGrid[i][j].setText(grid[i][j].toString());
			}
		}
	}

	/** 
	 * Empties all the squares in the grid on the SudokuGUI
	 * @before the grid can be filled with numbers
	 * @post all the squares are empty
	 * @param JGrid, the grid to be cleared
	 * */
	public void clearBoard(JTextField[][] JGrid) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				JGrid[i][j].setText("");
			}
		}
	}
	
	/** 
	 * Returns the grid of the type JTextField
	 * @return JGrid*/
	public JTextField[][] getTextGrid() {
		return JGrid;
	}

	/**
	 * Returns the grid with Integer objects
	 * @return GUIgrid*/
	public Integer[][] getGrid() {

		Integer[][] GUIgrid = new Integer[9][9];
		String text;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				text = JGrid[i][j].getText();
				if (text.equals("")) {
					GUIgrid[i][j] = 0;
				} else {
					GUIgrid[i][j] = Integer.parseInt(text);
				}
			}
		}
		return GUIgrid;
	}

	private JTextField[][] sudokuCells(JPanel panel) {

		JTextField[][] cells = new JTextField[9][9];
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout(new GridLayout(9, 9));

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cells[i][j] = new OneDigitField();
				cells[i][j].setPreferredSize(new Dimension(30, 30));
				panel.add(cells[i][j]);
			}
		}
		return cells;
	}

	private void setGrey(JTextField[][] cells) {
		Color lightGrey = new Color(169, 169, 169);

		for (int c = 0; c < 3; c++) {
			cells[c][3].setBackground(lightGrey);
			cells[c][4].setBackground(lightGrey);
			cells[c][5].setBackground(lightGrey);
		}

		for (int c = 3; c < 6; c++) {
			cells[c][0].setBackground(lightGrey);
			cells[c][1].setBackground(lightGrey);
			cells[c][2].setBackground(lightGrey);
		}
		for (int c = 6; c < 9; c++) {
			cells[c][3].setBackground(lightGrey);
			cells[c][4].setBackground(lightGrey);
			cells[c][5].setBackground(lightGrey);
		}
		for (int c = 3; c < 6; c++) {
			cells[c][6].setBackground(lightGrey);
			cells[c][7].setBackground(lightGrey);
			cells[c][8].setBackground(lightGrey);
		}
	}

}
