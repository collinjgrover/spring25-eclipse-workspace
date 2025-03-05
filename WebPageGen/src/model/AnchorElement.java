package model;

/**
 * Represents the &lt;a&gt; tag.
 * 
 * @author UMCP
 *
 */
public class AnchorElement extends TagElement {
	private String linkText;
	private String url;
	private int indentation;

	/*
	 * Initializes the tag with the provided parameters. For this project you
	 * can assume we will not update any of the attributes associated with this
	 * tag.
	 * 
	 * Parameters: url - linkText - attributes -
	 */
	public AnchorElement(String url, String linkText, String attributes) {
		super("a", true, new TextElement(""), attributes);
		this.url = url;
		this.linkText = linkText;
	}

	/*
	 * Returns the text used for the link.
	 * 
	 * Returns: text
	 */
	public String getLinkText() {
		return new String(linkText);
	}

	/*
	 * Returns the url associated with the link.
	 * 
	 * Returns: url
	 */
	public String getUrlText() {
		return new String(url);
	}

	/*
	 * Description copied from interface: Element Returns a string that
	 * represents the HTML associated with the element. The string is indented
	 * based on the parameter value.
	 * 
	 * Specified by: genHTML in interface Element Overrides: genHTML in class
	 * TagElement Returns: HTML associated with the element.
	 * 
	 */
	@Override
	public String genHTML(int indentation) {
		this.indentation = indentation;
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < indentation; i++)
			out.append(" ");
		String id = (getHideIDs() ? "" : " id=\"" + getStringId() + "\"");
		out.append("<" + tagName + id + " href=\"" + url + "\">" + linkText
				+ getEndTag());

		return out.toString();
	}

	@Override
	public String toString() {
		return getStartingTagWithID();

	}

	protected String getStartingTagWithID() {
		StringBuilder out = new StringBuilder();

		for (int i = 0; i < indentation; i++)
			out.append(" ");
		out.append("<" + tagName + " id=\"" + getId() + "\" href=\"" + url
				+ "\">" + linkText + getEndTag());

		return out.toString();
	}

}
