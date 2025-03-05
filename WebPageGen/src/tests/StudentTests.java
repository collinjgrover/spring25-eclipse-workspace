package tests;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.AnchorElement;
import model.HeadingElement;
import model.ImageElement;
import model.ListElement;
import model.ParagraphElement;
import model.TableElement;
import model.TagElement;
import model.TextElement;
import model.WebPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {

	@Test
	public void testTextElementGenHTML() {
		TextElement text = new TextElement("textElem");
		System.out.println(text.genHTML(0));
		assertEquals("textElem", text.genHTML(0));
	}

	@Test
	public void testTagElementGenHTML() {
		TagElement test = new TagElement("test", true,
				new TextElement("content"), "realAttr=100");
		assertEquals("<test id=\"test1\" realAttr=100>content</test>",
				test.genHTML(0));
	}

	@Test
	public void testAnchorElementGenHTML() {
		AnchorElement link = new AnchorElement("http://example.com",
				"Click here", "realAttr=100");
		assertEquals("<a id=\"a1\" href=\"http://example.com\">Click here</a>",
				link.genHTML(0));
	}

	@Test
	public void testListElementGenHTML() {
		ListElement ul = new ListElement(false, "class='list'");
		ul.addItem(new TextElement("Item 1"));
		ul.addItem(new TextElement("Item 2"));

		String expected = "<ul id=\"ul1\" class='list'>\n"
				+ " <li>Item 1</li>\n" + " <li>Item 2</li>\n" + "</ul>";
		assertEquals(expected, ul.genHTML(0));
	}

	@Test
	public void testTableElementGenHTML() {
		TableElement table = new TableElement(2, 2, "border='1'");
		table.addItem(0, 0, new TextElement("Jack"));
		table.addItem(0, 1, new TextElement("Luci"));
		table.addItem(1, 0, new TextElement("Raul"));

		String expected = "<table id=\"table1\" border='1'>\\n"
				+ "  <tr><td>Jack</td><td>Luci</td></tr>\n"
				+ "  <tr><td>Raul</td><td></td></tr>\n" + "</table>";
		System.out.println(table.genHTML(0));
		assertEquals(expected, table.genHTML(0));

		expected = "<table border='1'>\n" + "  <tr><td></td><td></td></tr>\n"
				+ "  <tr><td></td><td></td></tr>\n" + "</table>";
		assertEquals(expected, table.genHTML(0));

	}

	@Test
	public void testParagraphElementGenHTML() {
		ParagraphElement paragraph = new ParagraphElement(
				"This is a legit paragraph");
		String expected = "<p>This is a legit paragraph\n</p>";
		assertEquals(expected, paragraph.genHTML(0));
	}

	@Test
	public void testHeadingElementGenHTML() {
		HeadingElement heading = new HeadingElement(
				new TextElement("This is a heading"), 1, "realAttr=100");
		String expected = " <h1 id=\"h11\" realAttr=100>This is a heading</h1>";
		assertEquals(expected, heading.genHTML(0));
		HeadingElement heading1 = new HeadingElement(
				new TextElement("This is also a heading"), 6, "realAttr=100");
		System.out.println(heading1.genHTML(0));
		expected = " <h6 id=\"h62\" realAttr=100>This is also a heading</h6>";
		assertEquals(expected, heading1.genHTML(0));

	}



}