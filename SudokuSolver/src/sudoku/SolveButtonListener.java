package sudoku;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class SolveButtonListener extends JPanel implements ActionListener {
	private SudokuSolver solver;
	private SudokuGUI gui;

	/**
	 * Creates a buttonlistener for the 'solve' button
	 * 
	 * @param s and gui where 's' is the Sudoku solver and 'gui' is the GUI
	 * */
	public SolveButtonListener(SudokuSolver s, SudokuGUI gui) {
		solver = s;
		this.gui = gui;
	}

	/**
	 * Prints the solution on the GUI if there is a solution to be printed and
	 * prints a message, otherwise it doesn't show any solution and it prints an
	 * error message
	 * 
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		Integer[][] unSolved = gui.getGrid();

		if (solver.solve(unSolved) != null) {
			Integer[][] grid = solver.solve(unSolved);
			gui.print(grid);
			gui.printMessage("Solved!");
		} else {
			gui.printMessage("Could not be solved!");
		}

	}

}