=======================
= Dynamic Programming =
=======================


// Count all paths in board from start to end point when dice is thrown

static int path(int start,int end,int storage[])
	{
		int count=0;
		if(start==end){	
			return 1;
		}
		
		if(start>end)
			return 0;
		
		if(storage[start]!=0)
			return storage[start];
		
		
		for(int i=1;i<=6 && start+i<=end;i++){
			count=count+path(start+i,end,storage);
		}
		storage[start]=count;
		return count;
	}





	static int coinchange(int coins[], int sum, int totalsum, int index,int strg[][]) {

		int count = 0;
		if (sum == totalsum) {
			return 1;
		}


		if (sum > totalsum)
			return 0;

		if(strg[sum][index]!=0)
		{
			return strg[sum][index];
		}
			
		
		for (int i = index; i < coins.length; i++) {
			count = count + coinchange(coins, sum + coins[i], totalsum,i,strg);
			
		}


		strg[sum][index]=count;
		return count;
	}



// Edit Distance

/*

Given two strings str1 and str2 and below operations that can performed on str1. 
Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace

*/

	public static int Editdist(String s1, String s2, int storage[][]) { // storage is of length+1 size


		if (s1.length() == 0 || s2.length() == 0)
			return Math.max(s1.length(), s2.length());

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if (storage[s1.length()][s2.length()] != 0) {
			return storage[s1.length()][s2.length()];
		}

		int ans = 0;
		if (ch1 == ch2) {
			ans = Editdist(ros1, ros2, storage);
		}

		else {
			int insert = Editdist(ros1, s2, storage);
			int del = Editdist(s1, ros2, storage);
			int rep = Editdist(ros1, ros2, storage);
			ans = Math.min(rep, Math.min(insert, del)) + 1;
		}

		storage[s1.length()][s2.length()] = ans;
		return ans;

	}


// Knapsack 0-1

	static public int knapsack(int prices[], int weights[], int cap, int vidx, int strg[][]) { // [prices.length+1][cap+1]
		
		if (vidx >= prices.length) {
			return 0;
		}

		if (cap < 0) {
			return 0;
		}
		
		if(strg[vidx][cap]!=0){
			return strg[vidx][cap];
		}

		int count1=0;

		if(cap>=weights[vidx])
			count1 = knapsack(prices, weights, cap - weights[vidx], vidx + 1,strg)+ prices[vidx];
		
		int count2 = knapsack(prices, weights, cap, vidx + 1,strg);
		
		
		strg[vidx][cap]=Math.max(count1, count2);
		
		return Math.max(count1, count2);

		
	}



// Number of ways to reach end point from start, when you can move only left or right

	static int MazePath(int cr,int cc,int er,int ec,int storage[][]){ 
		
		int count=0;
		if(cr>er){
			return 0;
		}

		if(cc>ec ){
			return 0;
		}
				
		if(ec==cc && cr==er){				
			return 1;
		}
		
		
		if(storage[cr][cc]!=0)
		{
			return storage[cr][cc];
		}
		
		count=count+MazePath(cr+1,cc,er,ec,storage);
		count=count+MazePath(cr,cc+1,er,ec,storage);
		
		storage[cr][cc]=count;
	
		return count;
	}


// Matrix Chain Multplication 

public static int mcm(int arr[],int start,int end,int storage[][]){
		
		if(start+1==end){
			return 0;
		}
		
		if(storage[start][end]!=0)
			return storage[start][end];
		
		
		int min=Integer.MAX_VALUE;
		
		for(int k=start+1;k<=end-1;k++)
		{
			int fp=mcm(arr,start,k,storage);
			int sp=mcm(arr,k,end,storage);
			int sw=arr[start]*arr[k]*arr[end];
			
			int sum=fp+sp+sw;
			
			if(sum<min)
				min=sum;
		}
		
		storage[start][end]=min;
		return min;
	}


// Rod Cutting

	static int rodcutting(int prices[], int len, int strg[]) {

		if (strg[len] != 0) {
			return strg[len];
		}

		int left = 1;
		int right = len - 1;
		int max = prices[len];
		while (left <= right) {
			int fp = rodcutting(prices, left, strg);
			int sp = rodcutting(prices, right, strg);
			left++;
			right--;

			if (max < fp + sp) {
				max = fp + sp;
			}
		}

		strg[len] = max;
		return max;
	}


// Ugly Number 

/*
Ugly numbers are numbers whose only prime factors are 2, 3 or 5. 
The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … 
shows the first 11 ugly numbers. By convention, 1 is included.
*/

int getNthUglyNo(int n) 
    { 
        int ugly[] = new int[n];  // To store ugly numbers 
        int i2 = 0, i3 = 0, i5 = 0; 
        int next_multiple_of_2 = 2; 
        int next_multiple_of_3 = 3; 
        int next_multiple_of_5 = 5; 
        int next_ugly_no = 1; 
          
        ugly[0] = 1; 
          
        for(int i = 1; i < n; i++) 
        { 
            next_ugly_no = Math.min(next_multiple_of_2, 
                                  Math.min(next_multiple_of_3, 
                                        next_multiple_of_5)); 
              
            ugly[i] = next_ugly_no; 
            if (next_ugly_no == next_multiple_of_2) 
            { 
               i2 = i2+1; 
               next_multiple_of_2 = ugly[i2]*2; 
            } 
            if (next_ugly_no == next_multiple_of_3) 
            { 
               i3 = i3+1; 
               next_multiple_of_3 = ugly[i3]*3; 
            } 
            if (next_ugly_no == next_multiple_of_5) 
            { 
               i5 = i5+1; 
               next_multiple_of_5 = ugly[i5]*5; 
            } 
        } /*End of for loop (i=1; i<n; i++) */
        return next_ugly_no; 
    }


// LCS


public static int Lcs(String s1,String s2,int strg [][])
	{
		if(s1.length()==0||s2.length()==0){
			return 0;
		}
		
		if(strg[s1.length()-1][s2.length()-1]!=0)
			return strg[s1.length()-1][s2.length()-1];
		
		char ch1=s1.charAt(0);
		char ch2=s2.charAt(0);
		String ros1=s1.substring(1);
		String ros2=s2.substring(1);
		
		int ans;
		if(ch1==ch2)
			ans=Lcs(ros1,ros2,strg)+1;
		
		else
		{
			int ans1=Lcs(s1,ros2,strg);
			int ans2=Lcs(ros1,s2,strg);
			ans=Math.max(ans1, ans2);
		}
		
		strg[s1.length()-1][s2.length()-1]=ans;		
			return ans;
	}


// Longest Square Matrix

public static void largestonesquarematrix(int[][] arr){
		int[][] strg = new int[arr.length][arr[0].length];
		int maxi = strg.length - 1, maxj = strg[0].length - 1;
		
		for(int i = strg.length - 1; i >= 0; i--){
			for(int j = strg[0].length - 1; j >= 0; j--){
				if(i == strg.length - 1 && j == strg[0].length - 1){
					strg[i][j] = arr[i][j];
				} else if(i == strg.length - 1){
					strg[i][j] = arr[i][j];
				} else if(j == strg[0].length - 1){
					strg[i][j] = arr[i][j];
				} else {
					if(arr[i][j] == 1){
						int rp1 = i + 1;
						int cp1 = j + 1;
						strg[i][j] = 1 + Math.min(strg[rp1][j], 
										 Math.min(strg[rp1][cp1], 
												  strg[i][cp1]));
						
						if(strg[i][j] > strg[maxi][maxj]){
							maxi = i;
							maxj = j;
						}
					}
				}
			}
		}
		
		System.out.println(strg[maxi][maxj] + " at [" + maxi + ", " + maxj + "]");
	}


//LIS

public static void lis(int[] arr){
		// length of lis ending at i
		int[] strg = new int[arr.length];
		
		strg[0] = 1;
		int omax = 0;
		for(int i = 1; i < strg.length; i++){
			strg[i] = 1;			
			for(int j = 0; j < i; j++){
				if(arr[j] < arr[i]){
					strg[i] = Math.max(strg[j] + 1, strg[i]);
				}
			}			
			omax = Math.max(omax, strg[i]);
		}
		
		for(int val: strg){
			System.out.print(val + " ");
		}
		System.out.println(".");
		System.out.println(omax);
	}



// Eggdrop


static int counter = 0;
	public static int eggdrop(int e, int f, int[][] qb){
		if(e == 1 || f ==1 || f == 0){
			return f;
		}
		if(qb[e][f] != 0){
			return qb[e][f];
		}
		System.out.println(++counter + ". (" + e + ", " + f + ")");
		
		int minofthemaxes = Integer.MAX_VALUE;
		for(int k = 1; k <= f; k++){
			int maweb = eggdrop(e - 1, k - 1, qb);
			int mawes = eggdrop(e, f - k, qb);
			int worstmina = Math.max(maweb, mawes);
			minofthemaxes = Math.min(minofthemaxes, worstmina);
		}
		
		qb[e][f] = minofthemaxes + 1;
		return minofthemaxes + 1;
	}


// Palindromic SS

public static void countPalindromicSS(String s){
		boolean[][] strg = new boolean[s.length()][s.length()];
		
		for(int gap = 0; gap <= s.length() - 1; gap++){
			for(int i = 0; i + gap < s.length(); i++){
				int j = i + gap;
				
				if(gap == 0){
					strg[i][j] = true;
				} else if(gap == 1){
					strg[i][j] = s.charAt(i) == s.charAt(j);
				} else {
					strg[i][j] = s.charAt(i) == s.charAt(j) &&
							     strg[i + 1][j - 1];
				}
				
				if(strg[i][j]){
					System.out.println(s.substring(i, j + 1));
				}
			}
		}
	}


// Minimum Palindromic Cut Mem


public static int minimumPalindromicCutMem(String s, int i, int j, 
											   Integer[][] qb){
		if(IsPalindrome(s, i, j) == true){
			return 0;
		}
		
		if(qb[i][j] != null){
			return qb[i][j];
		}
		
		int mic = Integer.MAX_VALUE;
		for(int cp = i; cp < j; cp++){
			int c1 = minimumPalindromicCutMem(s, i, cp, qb);
			int c2 = minimumPalindromicCutMem(s, cp + 1, j, qb);
			int tc = c1 + c2 + 1;
			mic = Math.min(mic, tc);
		}
		
		qb[i][j] = mic;
		return mic;
	}

	
	private static boolean IsPalindrome(String s, int i, int j) {
		int left = i;
		int right = j;
		while(left < right){
			if(s.charAt(left) != s.charAt(right)){
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}




// Goldmine Problem
	
public static int goldmine(int[][] arr){
		int[][] strg = new int[arr.length][arr[0].length];
		
		for(int j = arr[0].length - 1; j >= 0; j--){
			for(int i = 0; i < arr.length; i++){
				if(j == arr[0].length - 1){
					strg[i][j] = arr[i][j];
				} else {
					if(i == 0){
						strg[i][j] = arr[i][j] + 
						Math.max(strg[i][j + 1], 
								 strg[i + 1][j + 1]);
					} else if(i == arr.length - 1){
						strg[i][j] = arr[i][j] + 
						Math.max(strg[i - 1][j + 1],
								 strg[i][j + 1]);
					} else {
						strg[i][j] = arr[i][j] + 
								Math.max(strg[i - 1][j + 1],
								Math.max(strg[i][j + 1], 
									     strg[i + 1][j + 1]));
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < strg.length; i++){
			max = Math.max(max, strg[i][0]);
		}
		
		return max;
	}	
	

// Coin Change Permutation Problem

	public static void coinchangeperm(int[] coins, int tar){
		int[] strg = new int[tar + 1];
		
		strg[0] = 1;
		for(int i = 1; i <= tar; i++){
			for(int coin: coins){
				if(i >= coin){
					strg[i] += strg[i - coin];
				}
			}
		}
		
		System.out.println(strg[tar]);
	}
	

// Coin Change Combination Problem 

	public static void coinchangecomb(int[] coins, int tar){
		int[] strg = new int[tar + 1];
		
		strg[0] = 1;
		for(int coin: coins){
			for(int i = 1; i <= tar; i++){
				if(i >= coin){
					strg[i] += strg[i - coin];
				}
			}
		}
		
		System.out.println(strg[tar]);
	}
	
	
// Minimum Jumps Problems 
	
	public static void minJumps(int[] arr){
		Integer[] strg = new Integer[arr.length];
		
		strg[arr.length - 1] = 0;
		for(int i = strg.length - 2; i >= 0; i--){
			for(int j = i + 1; j <= i + arr[i] && j < arr.length; j++){
				if(strg[j] != null){
					if(strg[i] == null || strg[j] + 1 < strg[i]){
						strg[i] = strg[j] + 1;
					}
				}
			}
		}
		
		System.out.println(strg[0]);
	}
	

