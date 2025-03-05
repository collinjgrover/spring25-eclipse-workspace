package model;

/**
 * 
 * Represents an HTML tag element (<&lt;p&gt;, &lt;ul&gt;, etc.). Each tag has
 * an id (ids start at 1). By default the start tag will have an id (e.g.,
 * <&lt;p id="a1"&gt;&lt;/p&gt;) when the HTML for the tag is generated. This
 * can be disabled by using enableId.
 * 
 * @author UMCP
 *
 */
public class TagElement implements Element {
2
	private final int id;
	private static int idCounter = 0;
	private final boolean hasEndTag;
	private static boolean hideID = false;
	private Element content;
	String attributes;

	String tagName; // solely the name of the tag itself, 'p' for example

	public TagElement(String tagName, boolean hasEndTag, Element content,
			String attributes) {

		if (!tagName.equals("li")) {
			id = ++idCounter;
		} else {
			id = idCounter;
		}
		this.tagName = tagName;
		this.hasEndTag = hasEndTag;
		this.content = content;
		this.attributes = attributes;
		// By default the start tag of a TagElement will have an id attribute
		// consisting of its tagName and its integer id.
	}

	/*
	 * Allow us to enable or disable the generation of ids for tags.
	 * 
	 */
	public static void enableId(boolean choice) {
		hideID = !choice;
	}

	/*
	 * Returns a string that represents the HTML associated with the element.
	 */
	public String genHTML(int indentation) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i <= indentation; i++) {
			out.append(" ");
		}

		out.append(getStartTag() + content.toString() + getEndTag());

		return out.toString();
	}

	/*
	 * Returns the end tag for this TagElement.
	 */
	public String getEndTag() {
		return hasEndTag ? "</" + tagName + ">" : "";
	}

	/*
	 * Returns the integer id associated with this tag.
	 */
	public int getId() {
		return id;
	}

	/*
	 * Returns the start tag. Tags with attributes should also include those
	 * attributes, as in standard HTML.
	 */
	public String getStartTag() {
		return "<" + tagName + getAttributes() + ">";
	}

	/*
	 * Returns a String containing the id attribute for this tag. append the
	 * tagName and the id number (no other characters, no spaces)
	 */
	public String getStringId() {
		return tagName + "" + id;
	}

	/*
	 * Allow us to start assigning ids at 1 again.
	 */
	public static void resetIds() {
		idCounter = 0; // pre-increment in constructor, so next elems ID is one
	}

	public void setAttributes​(String attributes) {
		this.attributes = attributes;
	}

	// private/protected helper method(s)
	protected String getAttributes() { // include id if hideID is false
		String out = "";
		String attrOut = (attributes == null ? "" : attributes);
		if (hideID) {
			if (!attrOut.isBlank())
				out = " " + attrOut;
		} else {
			out = " id=\"" + getStringId() + "\" " + attrOut;
		}

		return out;
	}

	protected boolean getHideIDs() {
		return hideID;
	}

}