==========
= Greedy =
==========

// Activity Selection

// Prints a maximum set of activities that can be done by a single 
    // person, one at a time. 
    //  n   -->  Total number of activities 
    //  s[] -->  An array that contains start time of all activities 
    //  f[] -->  An array that contains finish time of all activities 
    public static void printMaxActivities(int s[], int f[], int n) 
    { 
    int i, j; 
       
    System.out.print("Following activities are selected : n"); 
       
    // The first activity always gets selected 
    i = 0; 
    System.out.print(i+" "); 
       
    // Consider rest of the activities 
    for (j = 1; j < n; j++) 
    { 
         // If this activity has start time greater than or 
         // equal to the finish time of previously selected 
         // activity, then select it 
         if (s[j] >= f[i]) 
         { 
              System.out.print(j+" "); 
              i = j; 
          } 
     } 
    }



// Minimum Number of Platforms Required for a Railway/Bus Station


static int findPlatform(int arr[], int dep[], int n) 
{ 
   // Sort arrival and departure arrays 
   Arrays.sort(arr); 
   Arrays.sort(dep); 
   
   // plat_needed indicates number of platforms 
   // needed at a time 
   int plat_needed = 1, result = 1; 
   int i = 1, j = 0; 
   
   // Similar to merge in merge sort to process  
   // all events in sorted order 
   while (i < n && j < n) 
   { 
      // If next event in sorted order is arrival,  
      // increment count of platforms needed 
      if (arr[i] <= dep[j]) 
      { 
          plat_needed++; 
          i++; 
   
          // Update result if needed  
          if (plat_needed > result)  
              result = plat_needed; 
      } 
   
      // Else decrement count of platforms needed 
      else
      { 
          plat_needed--; 
          j++; 
      } 
   } 
   
   return result; 
} 


//Knapsack 

private static double getMaxValue(int[] wt, int[] val, int capacity){ 
    ItemValue[] iVal = new ItemValue[wt.length]; 
  
        for(int i = 0; i < wt.length; i++){ 
            iVal[i] = new ItemValue(wt[i], val[i], i); 
        } 
  
        //sorting items by value; 
        Arrays.sort(iVal, new Comparator<ItemValue>() { 
            @Override
            public int compare(ItemValue o1, ItemValue o2) { 
                return o2.cost.compareTo(o1.cost) ; 
            } 
        }); 
  
  
        double totalValue = 0d; 
  
        for(ItemValue i: iVal){ 
  
            int curWt = (int) i.wt; 
            int curVal = (int) i.val; 
  
            if (capacity - curWt >= 0){//this weight can be picked while 
                capacity = capacity-curWt; 
                totalValue += curVal; 
  
            }else{//item cant be picked whole 
  
                double fraction = ((double)capacity/(double)curWt); 
                totalValue += (curVal*fraction); 
                capacity = (int)(capacity - (curWt*fraction)); 
                break; 
            } 
  
  
        } 
  
        return totalValue; 
  
    } 