// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	   // System.out.println(plus(-2,-2));   // 2 + 3
	   //System.out.println(minus(7,2));  // 7 - 2
   		//System.out.println(minus(-15,-3));  // 2 - 7
 		//System.out.println(times(3,4));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(5,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
		//System.out.println(div(12,3));   // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   		//System.out.println(div(25,7));   // 25 / 7
   		//System.out.println(mod(25,7));   // 25 % 7
   		//System.out.println(mod(120,6));  // 120 % 6     
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum=x1;
		if (x1==0) return x2;
		if (x2==0) return x1;
		if (x1<0&&x2<0) {
			for (int i=0;i>x2;i--) {
				sum--;
			}
			return sum;
		}
		else if (x1<0) {
			for (int i=0;i<x2;i++) {
				sum++;
			}
			return sum;
		}
		else if (x2<0) {
			for (int i=0;i>x2;i--) {
				sum--;
			}
			return sum;
		}
		else {
			for(int i=0;i<x2;i++) {
			sum++;
		}
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int quotient=x1;
		if (x1<=0&&x2<=0) {
			for(int i=0;i>x2;i--) {
				quotient++;
			}
			return quotient;
		}
		else if (x2==0) {
			return x1;
		}
		else {
			for(int i=0;i<x2;i++) {
				quotient--;
			}
		}
		return quotient; 
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int multi=x1;
		if (x1==0 || x2==0) {
			return 0;
		}
		if (x1<0 && x2<0) {
			
			multi=0;
			for (int i=x2;i<0;i++) {
				multi= minus (multi,x1);
			}
			return multi;
		}
		if (x1<0) {
			for (int i=1;i<x2;i++) {
				multi= plus(multi,x1);
			}
			return multi;
		}
		if (x2<0) {
			multi=x2;
			for (int i=1;i<x1;i++) {
				multi= plus(multi,x2);
			}
			return multi;
		}
		else {
			for (int i=1;i<x2;i++) {
				multi = plus (multi,x1);
			}
		}
		return multi;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int power=x;
		if (n==0) {
			return 1;
		}
		for(int i=1;i<n;i++) {
			power = times (power,x);
		}
		return power;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int count=0;
		int d=x1;
		if (x1==0){
			return 0;
		}
		else if (x1<0&&x2<0) {
				while (d<0) {
					d=minus(d,x2);
					count++;
				}
				return count;
			}
		else if (x1<0) {
			while (d<0) {
				d=plus(d, x2);
				count--;
			}
			return count;
		}
		else if (x2<0) {
			while (d>0) {
				d=plus(d, x2);
				count--;
			}
			return count;
		}
		else while (d>=0) {
			d=minus(d, x2);
			count++;
		}
		count--;
		return count;
 	}
	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int d=x2;
		if (x1==0) return 0;
		for(int i=1;i<x1;i++) {
			if (times(i,d)==x1) {
				return 0;
			}
			if (times(i,d)>x1) {
				int n1 = minus (i,1);
				int n2=times(n1,d);
				return minus (x1,n2);
			}
		}
		return 0;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		for (int i=1;i<x;i++) {
			if(times(i,i)==x) {
				return i;
			}
			else if (plus(times(i,i), i)>x) {
				return minus(i,1);
			}
		} 
		return 0;
	}	  	  
}