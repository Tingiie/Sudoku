package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ClearButtonListener extends JPanel implements ActionListener {
	private SudokuSolver solver;
	private SudokuGUI gui;

	/**
	 * Creates a buttonlistener for the 'clear' button
	 * 
	 * @param s and gui where 's' is the Sudoku solver and 'gui' is the GUI
	 * */
	public ClearButtonListener(SudokuSolver s, SudokuGUI gui) {
		solver = s;
		this.gui = gui;
	}

	/**
	 * Clears the board when the button 'clear' is clicked
	 * 
	 * @param e
	 * */
	@Override
	public void actionPerformed(ActionEvent e) {
		gui.clearBoard(gui.getTextGrid());
		gui.printMessage("   Fill in the numbers you wish to be solved");
	}

}