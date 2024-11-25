/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		if(str1==""&&str2==""){
			return true;
		}
		String newS1=preProcess(str1);
		String newS2=preProcess(str2);
		boolean check=false;
		for(int i=0;i<newS1.length();i++) {
			for(int j=0;j<newS2.length();j++) {
				if (newS1.charAt(i)==newS2.charAt(j)) {
					check = true;
				}
			}
			if (check==false) {
				return false;
			}
		}
		return check;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		String newString = str.toLowerCase();
		int l=newString.length();
		String finalString= "";
		for (int i=0;i<l;i++) {
			char c=newString.charAt(i);
			if((c>='a')&&(c<='z')||(c>='1')&&(c<='9')||c==' ') {
				finalString = finalString + String.valueOf(c);
			}
		}
		return finalString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String newString = "";
		int randomNumber = (int)(Math.random()*str.length());
		char c =str.charAt(randomNumber);
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i)!=c) {
				newString = newString + str.charAt(i);
			}
		}
		newString=newString+c;
		return newString;
	}
}
