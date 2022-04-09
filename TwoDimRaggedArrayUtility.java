import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	// METHODS

	public static double[][] readFile(File data) throws FileNotFoundException {
		int row = 0, column = 0;

		// Scanner to read a line of the .txt file
		Scanner reader = new Scanner(data);

		// Set the values for the row and column counters used as array size declarator
		// Will return true while the specified .txt file contains another valid line
		// Increments the row variable at the start of each repletion
		while (reader.hasNextLine()) {
			row++;
			column = 0;
			// Scanner to read each double within the line
			Scanner colReader = new Scanner(reader.nextLine());
			// Will return true as long as colReader has another double to read
			// False if no valid value can be read
			while (colReader.hasNextDouble()) {
				colReader.nextDouble();// reads the double and advances to the next one
				column++;// increases the column counter after every new value is read
			}
			colReader.close(); // Creates new double array based on the size of the values from the read data
		}
		double[][] twoDArray = new double[row][column];
		reader.close();

		// Instantiating the array with the files data
		// Outer loop goes through the rows
		for (int r = 0; r < twoDArray.length; r++) {
			// Inner loop goes through the columns
			for (int c = 0; c < twoDArray[r].length; c++) {
				reader = new Scanner(data);// re-declare the reader scanner
				if (reader.hasNextDouble()) { // Input validation to ensure you are not over filling a row
					twoDArray[r][c] = reader.nextDouble(); // adds the value to the appropriate index location
				}
			}
		}
		return twoDArray;
	}

	/**
	 * Write the contents of 2D array into the specified file
	 * 
	 * @param data   2D array of doubles that are being written into the file
	 * @param output The file being written into
	 * @throws IOException If file is not found
	 */
	public static void writeToFile(double[][] data, File output) throws IOException {
		PrintWriter writer = new PrintWriter(output.getAbsoluteFile());
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++) {
				writer.print(Double.toString(data[r][c]));
			}
		} // TODO: Add the throw IO Exception if file is not found
	}

	/**
	 * The getTotal method returns the total of all the elements of the 2D array
	 * 
	 * @param data 2D array of doubles that are being totaled
	 * @returns sum The sum of all the elements
	 */
	public static double getTotal(double[][] data) {
		double sum = 0;
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++) {
				sum += data[r][c];
			}
		}
		return sum;
	}

	/**
	 * The getAverage method returns the average of all the elements from the 2D
	 * array
	 * 
	 * @param data The 2D array being averaged
	 * @returns average The average of the 2D array
	 */

	public static double getAverage(double[][] data) {
		double average = 0;
		int counter = 0;

		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++) {
				counter++;
				average += data[r][c];
			}
		}
		return (average / counter);
	}

	/**
	 * The getRowTotal Returns the total of the specified row
	 * 
	 * @param data The 2D array
	 * @param row  The selected row index that will be summed
	 */
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal = 0;
		for (int c = 0; c < data[row].length; c++) {
			rowTotal += data[row][c];
		}
		return rowTotal;
	}

	/**
	 * The getColumnTotal method returns the total of the specified column
	 * 
	 * @param data The array thats being added
	 * @param col  The specified column to be added
	 */

	public static double getColumnTotal(double[][] data, int col) {
		double columnTotal = 0;
		for (int r = 0; r < data.length; r++) {
			if (col >= data[r].length) {
				r++;
			}
			if (r < data.length)
				columnTotal += data[r][col];
		}
		return columnTotal;
	}

	/**
	 * Returns the largest value within the specified row
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = 0;
		for (int c = 0; c < data[row].length; c++) {
			if (highest < data[row][c]) {
				highest = data[row][c];
			}
		}
		return highest;
	}

	/**
	 * The getHighestInRowIndex returns the column
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		int index = 0;
		double highest = 0;

		// data[data.length][(data[index].length)];

		for (int c = 0; c < data[row].length; c++) {
			if (highest < data[row][c]) {
				highest = data[row][c];
				index = c;
			}
		}
		return index;
	}

	/**
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = data[row][0];
		for (int c = 0; c < data[row].length; c++) {
			if (lowest > data[row][c]) {
				lowest = data[row][c];
			}
		}
		return lowest;
	}

	/**
	 * 
	 * @param data
	 * @param row
	 * @return
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		int index = 0;
		double lowest = data[row][0];
		for (int c = 0; c < data[row].length; c++) {
			if (lowest > data[row][c]) {
				lowest = data[row][c];
				index = c;
			}
		}
		return index;
	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = 0;
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (highest < data[row][col]) {
					highest = data[row][col];
				}
			}
		}
		return highest;
	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = 0;
		int index = 0;
		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length)
				if (highest < data[row][col]) {
					highest = data[row][col];
					index = row;
				}
		}
		return index;
	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double low = 1.79769313486231570e+308d;
		for (int row = 0; row < data.length; row++) {
			if (col > data[row].length) {
				++row;
			}
			if (low > data[row][col]) {
				low = data[row][col];
			}
		}
		return low;
	}

	/**
	 * 
	 * @param data
	 * @param col
	 * @return
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int index = 0;
		double low = 1.79769313486231570e+308d;
		for (int row = 0; row < data.length; row++) {
			if (col > data[row].length) {
				++row;
			}
			if (data[row][col] < low) {
				low = data[row][col];
				index = row;
			}
		}
		return index;
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double getHighestInArray(double[][] data) {
		double highest = 0;
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++) {

				if (highest < data[r][c]) {
					highest = data[r][c];
				}
			}
		}
		return highest;
	}

	/**
	 * 
	 * @param data
	 * @return
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = data[0][0];
		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				if (lowest > data[row][col]) {
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}
}
