package model;

import java.util.ArrayList;

/**
 * Represents the &lt;ul&gt and the &lt;ol&gt; tags. An ArrayList is used to
 * keep track of the Element objects of the list.
 * 
 * @author UMCP
 *
 */
public class ListElement extends TagElement {

	private ArrayList<Element> items;

	public ListElement(boolean ordered, String attributes) {
		super(ordered ? "ol" : "ul", true, new TextElement("<li>"), attributes);

		items = new ArrayList<Element>();
	}

	/*
	 * Adds a list item to the end of the list.
	 */
	public void addItem(Element item) {
		if (item != null) {
			items.add(new TagElement("li", true, item, ""));
		}
	}

	public String genHTML(int indentation) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < indentation; i++)
			out.append(" ");
		String indent = new String(out.toString());
		out.append(getStartTag());
		TagElement.enableId(false);
		for (Element currElem : items) {
			if (currElem instanceof AnchorElement)
				TagElement.enableId(true);
			out.append("\n" + indent + currElem.genHTML(indentation));
		}
		out.append("\n" + indent + getEndTag());
		TagElement.enableId(true);
		return out.toString();
	}

}