package checkingAccessAway;

import checkingAccess.ClassA;

//Different package as ClassA, is a subclass of ClassA

public class ClassD extends ClassA {
	public ClassD() {
		publicVis = 41;
		protectedVis = 42;
		//privateVis = 43;
		//packageVis = 44;
	}
	
	public void checkAccess() {
		System.out.println(publicVis);
		System.out.println(protectedVis);
		//System.out.println(privateVis);
		//System.out.println(packageVis);
	
	}
}
