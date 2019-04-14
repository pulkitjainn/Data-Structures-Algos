========
= Misc =
========

//Bitmasking - Unique Number 2

public static void unique2(int[] a, int n) {
        int ans = 0;
        for(int i=0;i<n;i++){
            ans = ans^a[i];
        }
        int temp=ans;
        int i=0;
        while(temp>0){
            if((temp&1)!=0){
                break;
            }
            i++;
            temp = temp>>1;
        }
        int mask = 1<<i;
        int r1 = 0;
        for(int j=0;j<n;j++){
            if((a[j]&mask)!=0){
                r1 = r1^a[j];
            }
        }
        int r2 = 0;
        r2 = ans^r1;
        System.out.println(r1+" "+r2);
        return;
    }


//Kadane Algo

    static void maxSubArraySum(int a[], int size){

        int max_so_far = Integer.MIN_VALUE, 
        max_ending_here = 0,start = 0, 
        end = 0, s = 0; 
  
        for (int i = 0; i < size; i++)  
        { 
            max_ending_here += a[i]; 
  
            if (max_so_far < max_ending_here)  
            { 
                max_so_far = max_ending_here; 
                start = s; 
                end = i; 
            } 
  
            if (max_ending_here < 0)  
            { 
                max_ending_here = 0; 
                s = i + 1; 
            } 
        } 
        System.out.println("Maximum contiguous sum is " + max_so_far); 
        System.out.println("Starting index " + start); 
        System.out.println("Ending index " + end); 
    } 


//Rotate matrix

static void rotateMatrix(int N, int mat[][]) 
    { 
        // Consider all squares one by one 
        for (int x = 0; x < N / 2; x++) 
        { 
            // Consider elements in group of 4 in  
            // current square 
            for (int y = x; y < N-x-1; y++) 
            { 
                // store current cell in temp variable 
                int temp = mat[x][y]; 
       
                // move values from right to top 
                mat[x][y] = mat[y][N-1-x]; 
       
                // move values from bottom to right 
                mat[y][N-1-x] = mat[N-1-x][N-1-y]; 
       
                // move values from left to bottom 
                mat[N-1-x][N-1-y] = mat[N-1-y][x]; 
       
                // assign temp to left 
                mat[N-1-y][x] = temp; 
            } 
        } 
    } 


// Duplicate in Array

public int repeatedNumber(final List<Integer> a) {
        
        final int x = a.size();
        int count[] = new int[x];
        int i;
 
        for (i = 0; i < x; i++) 
        {
            if (count[a.get(i)] == 1)
                return a.get(i);
            else
                count[a.get(i)]++;
        }
        return -1;
    }


//Sprial print matrix

static void spiralPrint(int m, int n, int a[][]) 
    { 
        int i, k = 0, l = 0; 
        /*  k - starting row index 
        m - ending row index 
        l - starting column index 
        n - ending column index 
        i - iterator 
        */
           
        while (k < m && l < n) 
        { 
            // Print the first row from the remaining rows 
            for (i = l; i < n; ++i) 
            { 
                System.out.print(a[k][i]+" "); 
            } 
            k++; 
   
            // Print the last column from the remaining columns  
            for (i = k; i < m; ++i) 
            { 
                System.out.print(a[i][n-1]+" "); 
            } 
            n--; 
   
            // Print the last row from the remaining rows */ 
            if ( k < m) 
            { 
                for (i = n-1; i >= l; --i) 
                { 
                    System.out.print(a[m-1][i]+" "); 
                } 
                m--; 
            } 
   
            // Print the first column from the remaining columns */ 
            if (l < n) 
            { 
                for (i = m-1; i >= k; --i) 
                { 
                    System.out.print(a[i][l]+" "); 
                } 
                l++;     
            }         
        } 
    }


//Tower of hanoi

static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) 
    { 
        if (n == 1) 
        { 
            System.out.println("Move disk 1 from rod " +  from_rod + " to rod " + to_rod); 
            return; 
        } 
        towerOfHanoi(n-1, from_rod, aux_rod, to_rod); 
        System.out.println("Move disk " + n + " from rod " +  from_rod + " to rod " + to_rod); 
        towerOfHanoi(n-1, aux_rod, to_rod, from_rod); 
    } 
