package sudoku;

public class SudokuSolver {
	private Integer grid[][];

	/** 
	 * Creates a Sudoku solver*/
	public SudokuSolver() {
	}

	/** 
	 * Solves the Sudoku
	 * @param userGrid[][], the grid to be solved
	 * @return grid if it could be solved
	 * @return null if the userGrid could not be solved
	 * */
	public Integer[][] solve(Integer userGrid[][]) {
		grid = userGrid;
		boolean solved = false;

		if (isEmpty() == false) {
			if (duplicatesCheck() == true) {
				return null;
			}
		}

		solved = solve(0, 0);
		if (solved == true) {
			return grid;
		} else {
			return null;
		}
	}

	private boolean solve(int i, int j) {

		if (j == 9) {
			j = 0;
			if (++i == 9)
				return true;
		}
		if (grid[i][j] != 0)
			return solve(i, j + 1);

		for (int numb = 1; numb < 10; numb++) {
			if (checkAll(i, j, numb)) {
				grid[i][j] = numb;
				if (solve(i, j + 1))
					return true;
			}
		}
		grid[i][j] = 0;
		return false;
	}

	private boolean isEmpty() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean duplicatesCheck() {
		for (int i = 0; i < 9; i++) {
			if (checkRowDuplicates(i) || checkColDuplicates(i)) {
				return true;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (checkSquareDuplicates(i, j) == true) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkSquareDuplicates(int row, int column) {
		for (int numb = 1; numb < 10; numb++) {
			int counter = 0;
			for (int i = row * 3; i < row * 3 + 3; i++) {
				for (int j = column * 3; j < column * 3 + 3; j++) {
					if (grid[i][j] == numb) {
						counter++;
					}
					if (counter > 1) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean checkRowDuplicates(int row) {
		for (int numb = 1; numb < 10; numb++) {
			int counter = 0;
			for (int col = 0; col < 9; col++) {
				if (numb == grid[row][col]) {
					counter++;
				}
				if (counter > 1) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkColDuplicates(int col) {
		for (int numb = 1; numb < 10; numb++) {
			int counter = 0;
			for (int row = 0; row < 9; row++) {
				if (numb == grid[row][col]) {
					counter++;
				}
				if (counter > 1) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean columnCheck(int col, int numb) {
		for (int i = 0; i <= 8; i++) {
			if (grid[i][col] == numb) {
				return false;
			}
		}
		return true;
	}

	private boolean rowCheck(int row, int numb) {
		for (int i = 0; i <= 8; i++) {
			if (grid[row][i] == numb) {
				return false;
			}
		}
		return true;
	}

	private boolean boxCheck(int row, int col, int numb) {
		row = (row / 3) * 3;
		col = (col / 3) * 3;

		for (int x = 0; x < 3; x++){
			for (int y = 0; y < 3; y++){
				if (grid[row + x][col + y] == numb){
					return false;
				}
			}
		}
		return true;
	}


	private boolean checkAll(int row, int col, int numb) {
		if (boxCheck(row, col, numb) && rowCheck(row, numb)
				&& columnCheck(col, numb)) {
			return true;
		}
		return false;
	}

	/**
	 * Sets the value
	 * @post the number 'num' is inserted
	 * @param num, row, and col
	 * where 'num' is the number you wish to insert in
	 *  the place with the row 'row' and column 'col'
	 * */
	public void setValue(int num, int row, int col) {
		grid[row][col] = num;
	}

	/**
	 * Returns the value
	 * @param row, col
	 * where 'row' is the row and 'col' is the column of the value
	 * @return the value
	 */
	public int getValue(int row, int col) {
		return grid[row][col];
	}
}