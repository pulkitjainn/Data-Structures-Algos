Heaps 
Dated : July 27


// Refer : https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/tutorial/

//Max Heap

void build_maxheap (int Arr[ ])
    {
        for(int i = N/2 ; i >= 1 ; i-- )
        {
            max_heapify (Arr, i) ;
        }
    }

void max_heapify (int Arr[ ], int i, int N)
    {
        int left = 2*i                   //left child
        int right = 2*i +1           //right child
        if(left<= N and Arr[left] > Arr[i] )
              largest = left;
        else
             largest = i;
        if(right <= N and Arr[right] > Arr[largest] )
            largest = right;
        if(largest != i )
        {
            swap (Arr[i] , Arr[largest]);
            max_heapify (Arr, largest,N);
        } 
     }


//Min Heap

void build_minheap (int Arr[ ]) 
    {
        for( int i = N/2 ; i >= 1 ; i--)
        min_heapify (Arr, i);
    }

void min_heapify (int Arr[ ] , int i, int N)
    {
    	int left  = 2*i;
    	int right = 2*i+1;
    	int smallest;
    	if(left <= N and Arr[left] < Arr[ i ] )
    	     smallest = left;
    	else
    	    smallest = i;
    	if(right <= N and Arr[right] < Arr[smallest] )
       		smallest = right;
    	if(smallest != i)
    	{
        	swap (Arr[ i ], Arr[ smallest ]);
        	min_heapify (Arr, smallest,N);
    	} 
    }