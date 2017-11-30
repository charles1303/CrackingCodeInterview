package com.career.cup;

public class CheckPrime {
	
	public static void main(String args[]){
		//check(9);
		System.out.println(largestPrimeFactor(600851475143l));
		//long val = 3000009l;
		//System.out.println(largestPrimeFactor(val));
		//Main();
	}
	
	public static int largestPrimeFactor(long number) {
	    int i;
	    int cnt = 0;
	    for (i = 2; i <= number; i++) {
	    	cnt++;
	        if (number % i == 0) {
	        	System.out.println(number + " ==" + i);
	            number /= i;
	            System.out.println("New Number===="+number);
	            i--;
	            System.out.println("New i===="+i);
	        }
	    }
	    System.out.println("No of iterations===="+cnt);
	    return i;
	}

	public static boolean check(int n){
		boolean isPrime = true;
		for(int i = 2; i < n; i++){
			if(n%i == 0){
				isPrime = false;
				break;
			}
						
		}
		if(!isPrime){
			System.out.println("IS not a Prime");
		}else{
			System.out.println("IS a Prime");
		}
		
		return false;
	}
	
	public static void main2() {
		int cnt = 0;
        long start, end, totalTime;
        long num = 600851475143L;   // odd value is not divided by any even
        long pFactor = 1L;

        start = System.currentTimeMillis();

        for(long i = 3L; i <= num / i; ) 
        {
        	cnt++;
            if( num % i == 0 ) {
                pFactor = i;
                num = num / i;
            }
            else {
                i += 2;
            }
        }
        if( pFactor < num ) { pFactor = num; }

        end = System.currentTimeMillis();
        totalTime = end - start;
        System.out.println( pFactor + " Time: " + totalTime);
        System.out.println("No of iterations 2===="+cnt);
    }
	
	static boolean OddIsPrime (long oddvalue)  // test an odd >= 3 
	{
	    // Only test odd divisors.
		int cnt = 0;
	    for (long i = 3; i <= Math.sqrt(oddvalue); i += 2)
	    {
	    	cnt++;
	        if (oddvalue % i == 0)
	            return false;
	    }
	    System.out.println("No of iterations 1===="+cnt);
	    return true;
	}

	static void Main()
	{
	    long max = 600851475143l;   // an odd value
	    //long max = 3000009;
	    long maxFactor = 0;
	    int cnt = 0;
	    // Only test odd divisors of MAX. Limit search to Square Root of MAX.
	    for (long i = 3; i <= Math.sqrt(max); i += 2)
	    {
	    	cnt++;
	        if (max % i == 0)
	        {
	            if (OddIsPrime(i))  // i is odd
	            {
	                maxFactor = i;
	            }
	        }
	    }
	    System.out.println(maxFactor);
	    System.out.println("No of iterations 2===="+cnt);
	    //Console.WriteLine(maxFactor.ToString());
	    //Console.ReadLine();
	}
}
