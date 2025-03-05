package testing;

import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import university.*;

public class PublicTests {

	@Test
	public void pub01PersonConstructor() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		StringBuffer results = new StringBuffer();
		
		String name = "Name";
		int id = 1234;
		
		Person p = new Person(name, id);
		results.append(p);
		
		System.out.println(TestingSupport.isResultCorrect(testName, results.toString(), true));
		//System.out.println(testName);
		//System.out.println(results.toString());
	}
	
	@Test
	public void pub02PersonGetName() {
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		StringBuffer results = new StringBuffer();
		
		String name = "Name";
		int id = 1234;
		
		Person p = new Person(name, id);
		
		results.append("getName(): ");
		results.append(p.getName());
		results.append("\ngetId(): ");
		results.append(p.getId());
		
		System.out.println(TestingSupport.isResultCorrect(testName, results.toString(), true));
	}

}
