package model;

import java.util.ArrayList;
import java.util.Set;

/**
 * 
 * Represents text that can appear in an HTML document
 * 
 * @author UMCP
 *
 */
public class TextElement implements Element {
	private String text;

	public TextElement(String text) { // null check?
		this.text = text;
	}

	@Override
	public String genHTML(int indentation) {
		StringBuilder out = new StringBuilder();
			
		out.append(text);
		return out.toString(); 
	}
	
	@Override
	public String toString () {
		return text;
	}

}