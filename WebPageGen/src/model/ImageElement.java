package model;

import javax.swing.JEditorPane;

/**
 * Represents an &lt;img&gt; tag. For this project you can assume we will not
 * update any of the attributes associated with this tag.
 * 
 * @author UMCP
 *
 */
public class ImageElement extends TagElement {
	private String imageURL;
	private String alt;
	private int width;
	private int height;

	public ImageElement(String imageURL, int width, int height, String alt,
			String attributes) {
		super("img", false, new TextElement(""), attributes);
		this.imageURL = imageURL;
		this.alt = alt;
		this.width = width;
		this.height = height;

	}

	public String getImageURL() {
		return new String(imageURL);
	}

	@Override
	public String genHTML(int indentation) {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < indentation; i++)
			out.append(" ");

		out.append("<" + tagName);

		if (!getHideIDs())
			out.append(" id=\"" + getStringId() + "\"");

		out.append(" src=\"" + imageURL + "\" width=\"" + width + "\" height=\""
				+ height + "\" alt=\"" + alt + "\">");

		return out.toString();
	}
}
