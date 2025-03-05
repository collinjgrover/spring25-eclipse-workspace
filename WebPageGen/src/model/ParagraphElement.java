package model;

import java.util.ArrayList;import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * Represents a paragraph (&lt;p&gt;) tag.  It relies on an
 * ArrayList in order to keep track of the set of Element objects
 * that are part of the paragraph.
 * @author UMCP
 *
 */
public class ParagraphElement extends TagElement {
	private String text;
	private ArrayList<Element> items;

	public void addItem(Element element) {
		Element newElem = element;
		
		if (newElem != null) {
			items.add(newElem);
		}
		
	}
	
	public ParagraphElement (String attributes) {
		super("p", true, new TextElement(""), attributes);
		this.text = text;
		items = new ArrayList<Element>();
	}
	
	@Override
	public String genHTML(int indentation) {
		StringBuilder out = new StringBuilder();
		
		for (int i = 0; i < indentation; i++)
			out.append(" ");
		
		String indent = new String(out.toString());
		
//		out.append("<" + tagName);
//
//		if (!getHideIDs())
//			out.append(" id=\"" + getStringId() + "\"");
//		out.append(attributes);
		
		out.append(getStartTag());
		
		for (Element currElem : items) {
			
			if (currElem instanceof TextElement) 
				// fixes format issue for TextElement
				out.append("\n" + indent + indent+ currElem.genHTML(indentation));
			else 
			out.append("\n" + indent + currElem.genHTML(indentation));
		}
		
		out.append("\n" + indent + getEndTag());
		return out.toString();
	}
	
}
