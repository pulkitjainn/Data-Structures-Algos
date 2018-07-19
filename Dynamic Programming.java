Dynamic Programming

Dated : July 19


//Fibonacci


//Memoized version

void _initialize()
  {
    for (int i = 0; i < MAX; i++)
        lookup[i] = -1;
  }
 
  int fib(int n)
  {
    if (lookup[n] == -1)
    {
      if (n <= 1)
          lookup[n] = n;
      else
          lookup[n] = fib(n-1) + fib(n-2);
    }
    return lookup[n];
  }


//Tabulated version

int fib(int n)
  {
    int f[] = new int[n+1];
    f[0] = 0;
    f[1] = 1;
    for (int i = 2; i <= n; i++)
          f[i] = f[i-1] + f[i-2];
    return f[n];
  }


//Longest Increasing Subsequence

static int longestIncreasingSubsequence(int[] a, int n ){
	    int[] lis = new int[n];
	    for(int i =0;i<n;i++){
	        lis[i]=1;
	    }
	    for(int i =1;i<n;i++){
	    	for(int j=0;j<i;j++){
	    		if(a[i]>a[j] && lis[i]<lis[j]+1){
	    			lis[i]=lis[j]+1;
	    		}
    		}
    	}
    	int max =0;
    	for(int i =0;i<n;i++){
    	    if(lis[i]>max){
    	        max= lis[i];
    	    }
    	}
	    return max;
    }


//Longest Common Subsequence

int longestCommonSubsequence(char[] a,char[] b,int m, int n ){
	    int[][] lcs = new int[m+1][n+1];
		for(int i=0;i<=m;i++){
	    	for(int j=0;j<=n;j++){
	    	    if(i == 0 || j == 0){
                    lcs[i][j] = 0;
	    	    }
	    		else if(a[i-1] == b[j-1]){
	    			lcs[i][j] = lcs[i-1][j-1] + 1;
	    		}
	    		else{
	    			lcs[i][j] = Math.max(lcs[i-1][j] , lcs[i][j-1]);
	    		}
	    	}
	    }
	    return lcs[m][n];
	}


//Edit Distance

static int editDistance(String a,String b,int m, int n ){
	    int[][] dis = new int[m+1][n+1];

	    for(int i =0;i<m+1;i++){
	    	for(int j =0;j<n+1;j++){
	    		if(i==0){
	    			dis[i][j]=j;
	    		}
	    		else if(j==0){
	    			dis[i][j]=i;
	    		}
	    		else if(a.charAt(i-1)==b.charAt(j-1)){
	    			dis[i][j]=dis[i-1][j-1];
	    		}
	    		else{
	    			dis[i][j]=Math.min(dis[i-1][j-1],Math.min(dis[i][j-1],dis[i-1][j])) + 1;
	    		}
	    	}
	    }


//Minimum Cost Path

static int minCostPath(int[][] a,int m, int n ){
	    int[][] tc = new int[m+1][n+1];

	    for(int i =0;i<=m;i++){
	    	for(int j =0;j<=n;j++){
	    	    if(i==0 && j==0){
	    	        tc[i][j]=a[0][0];
	    	    }
	    		else if(i==0 && j>0){
	    			tc[i][j]= tc[i][j-1] + a[i][j];
	    		}
	    		else if(j==0 && i>0){
	    			tc[i][j] = tc[i-1][j] + a[i][j];
	    		}
	    		else{
	    			tc[i][j]=Math.max(tc[i-1][j-1],Math.max(tc[i][j-1],tc[i-1][j])) + a[i][j];
	    		}
	    	}
	    }

	    return tc[m][n];
	}