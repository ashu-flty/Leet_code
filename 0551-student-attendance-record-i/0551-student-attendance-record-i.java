class Solution {
    	public boolean checkRecord(String s) {
		int abcount = 0;
		int lateCount = 0;
		char[] ch = s.toCharArray();
		for (char letter : ch) {
			if (letter == 'A') {
				++abcount;
				if (abcount == 2)
					return false;
			}
			if (letter == 'L')
				++lateCount;
			if (letter == 'A' || letter == 'P')
				lateCount = 0;
			if (lateCount > 2)
				return false;
		}
		return true;
	}
}