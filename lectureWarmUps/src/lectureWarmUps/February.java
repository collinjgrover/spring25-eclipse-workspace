package lectureWarmUps;

import java.util.ArrayList;
import java.util.Iterator;

public class February {

	// vars for 2/28
	ArrayList<String> list = new ArrayList<String>();

	
	public static void main(String[] args) {
		
		String[] names = {"aa", "bb", "cc" };
		System.out.println(toStringAux(names, 0));
		
//		ArrayList<String> list = new ArrayList<String>(names);
	}
	
	private static String toStringAux(String[] in, int idx) {
		if (idx >= in.length ) {
			// base case
			return "";
		} else {
			return in[idx] + " " + toStringAux(in, idx + 1);
		}
	}
	
	
	private class lengthIteator implements Iterator<String> {
		private int idx = 0;
		private int[] validIdxArray = new int[list.size()];

			@Override
			public String next() {
				return list.get(validIdxArray[idx]);
			}
			
			@Override
			public boolean hasNext() {
				int j = 0;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i).length() < 10) {
						validIdxArray[j++] = i;
					}
				}
				int diff = validIdxArray.length - idx;
				return diff < list.size();
			}
		
	}
	
	
	
	
	
	
	
}
