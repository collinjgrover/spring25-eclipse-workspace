package model;

/**
 * Represents the &lt;table&gt tag. A two dimensional array is used to keep
 * track of the Element objects of table.
 * 
 * @author UMCP
 *
 */
public class TableElement extends TagElement {
	private Element[][] items;

	public TableElement(int rows, int cols, String attributes) {
		super("table", true, new TextElement(""), attributes);
		// hideID? name? content?
		items = new Element[rows][cols];
	}

	/*
	 * Adds/updates the element with the specified indices.
	 */
	public void addItem(int rowIndex, int colIndex, Element item) {
		if (rowIndex < items.length && rowIndex >= 0) {
			if (colIndex < items[rowIndex].length && colIndex >= 0) {
				items[rowIndex][colIndex] = item;
			}
		}
	}

	/*
	 * Returns a string that represents the HTML associated with the element.
	 */
	@Override
	public String genHTML(int indentation) {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < indentation; i++) {
			out.append(" ");
		}
		String indent = new String(out.toString());
		out.append(getStartTag());

		out.append(indent + getTableBody(indentation));

		out.append("\n" + indent + getEndTag()); // closing table tag

		return out.toString();
	}

	/*
	 * Returns the percentage of table cells currently in used (those storing
	 * references to objects).
	 */
	public double getTableUtilization() {
		double numOccupied = 0;
		double totalCells = items.length * items[0].length; // works only if
															// each row same
															// length
		for (Element[] currRow : items) {
			for (Element currElem : currRow) {
				if (currElem != null)
					++numOccupied;
			}
		}
		return (numOccupied / totalCells) * 100;
	}

	/*
	 * private/protected method(s) below
	 */

	private String getTableBody(int indentation) {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < items.length; i++) {
			out.append("\n  <tr>");
			for (int j = 0; j < items[0].length; j++) {
				if (items[i][j] != null) {
					out.append("<td>");
					out.append(items[i][j].genHTML(indentation));
					out.append("</td>");
				} else {
					out.append("<td></td>"); // empty cell
				}
			}
			out.append("</tr>");
		}

		return out.toString();
	}

}
