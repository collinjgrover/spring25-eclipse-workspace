package model;

import java.util.ArrayList;

/**
 * Represents a web page. Web page elements are stored in an ArrayList of
 * Element objects. A title is associated with every page. This class implements
 * the Comparable interface. Pages will be compared based on the title.
 * 
 * @author UMCP
 *
 */
public class WebPage implements Comparable<WebPage> {
	private ArrayList<Element> elements;
	private String title;

	@Override
	public int compareTo(WebPage o) {
		return title.compareTo(o.title);
	}

	/*
	 * Adds an element to the page by adding the element to the end of the
	 * ArrayList.
	 */
	public WebPage(String title) {
		this.title = title;
		elements = new ArrayList<Element>();
	}

	/*
	 * Adds an element to the page by adding the element to the end of the
	 * ArrayList.
	 */
	public int addElement(Element element) {
		if (element instanceof TagElement) {
			elements.add(element);
			return ((TagElement) element).getId();
		}
		return -1;
	}

	public String getWebPageHTML(int indentation) {
		StringBuilder out = new StringBuilder();

		out.append("<!doctype html>\n" + "<html>\n");

		out.append(getHead(indentation));

		out.append(getBody(indentation));

		// add closing html tag
		out.append("\n</html>");

		return out.toString();
	}

	/*
	 * Writes to the specified file the web page page using the provided
	 * indentation. Relies on the Utilities method writeToFile
	 */
	public void writeToFile​(String filename, int indentation) {
		Utilities.writeToFile(filename, getWebPageHTML(indentation));
	}

	/*
	 * Returns a reference to a particular element based on the id
	 */
	public Element findElem​(int id) {
		Element outElement = null;
		for (Element currElement : elements) {
			if (currElement instanceof TagElement) {
				int currID = ((TagElement) currElement).getId();
				if (currID == id)
					outElement = currElement;
			}
		}
		return outElement;
	}

	/*
	 * Returns information about the number of lists, paragraphs, and tables
	 * present in the page. Also, it provide table utilization information. See
	 * public tests for format.
	 */
	public String stats() {

		StringBuilder out = new StringBuilder();

		int countList = 0;
		int countParagraph = 0;
		int countTable = 0;
		double numerator = 0.0;
		double percent = 0.0;

		for (Element currElem : elements) {
			if (currElem instanceof ListElement) {
				countList++;
			} else if (currElem instanceof ParagraphElement) {
				countParagraph++;
			} else if (currElem instanceof TableElement) {
				countTable++;
				TableElement table = (TableElement) currElem;
				numerator += table.getTableUtilization();

				percent = numerator / (double) countTable;
			}
		}

		out.append("List Count: " + countList);
		out.append("\nParagraph Count: " + countParagraph);
		out.append("\nTable Count: " + countTable);
		out.append("\nTableElement Utilization: " + percent);

		return out.toString();
	}

	/*
	 * Enables the ids associated with tag elements.
	 */
	public static void enableId​(boolean choice) {
		TagElement.enableId(choice);
	}

	/*
	 * private/protected method(s)
	 */

	private String getHead(int indentation) {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < indentation; i++)
			out.append(" ");

		String indent = new String(out.toString());

		out.append("<head>" + "\n" + indent + indent
				+ "<meta charset=\"utf-8\"/>");
		out.append("\n" + indent + indent + "<title>" + title + "</title>");
		out.append("\n" + indent + "</head>");

		return out.toString();
	}

	private String getBody(int indentation) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < indentation; i++)
			out.append(" ");

		String indent = new String(out.toString());

		// add body
		out.append("\n" + indent + "<body>");

		for (Element currElem : elements) {
			out.append("\n" + currElem.genHTML(indentation));
		}

		out.append("\n" + indent + "</body>");

		return out.toString();
	}

}
