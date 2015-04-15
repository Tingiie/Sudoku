package sudoku;

import javax.swing.*;

public class View extends JFrame {

	/**
	 * Creates a GUI with a square with a text field that can only contain a
	 * digit
	 */
	public View() {
		super("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextField field = new OneDigitField();
		add(field);

		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new View();
	}
}
