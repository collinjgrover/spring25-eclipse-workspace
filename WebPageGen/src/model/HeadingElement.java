package model;

/**
 * Represents a heading. We can have levels 1 thru 6 (e.g., &lt;h1&gt;,
 * &lt;h2&gt;, etc.)
 * 
 * @author UMCP
 *
 */

public class HeadingElement extends TagElement {
	private int level;

	public HeadingElement(Element content, int level, String attributes) {

		super("h" + (level > 0 && level < 7 ? level : "1"), true, content,
				attributes);
		this.level = level;
	}

}
