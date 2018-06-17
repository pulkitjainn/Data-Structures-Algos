Arrays
// Dated : June 15

//Rearrange an array such that arr[i] = i
#include <iostream>
using namespace std;
int main() {
	int t,s,x;
	cin>>t;
	for(int s=0;s<t;s++){
	    int n;
	    cin>>n;
	    int a[n];
        for(int i=0;i<n;i++){
            a[i]=-1;
        }
	    for(int i=0;i<n;i++){
	        cin>>x;
	        if(x>-1 && x<n){
	            a[x]=x;
	        }
	    }
	    for(int i=0;i<n;i++){
	        cout<<a[i]<<" ";
	    }
	    cout<<endl;
	}
	return 0;
}


//Reverse a String

#include <iostream>
using namespace std;

int main() {
    int t,q;
    cin>>t;
    for(int q=0;q<t;q++){
        string s;
        cin>>s;
        int x = s.length();
        for(int i=0;i<x/2;i++){
            char temp = s[i];
            s[i]=s[x-1-i];
            s[x-1-i]=temp;
        }
        cout<<s<<endl;
    }
	return 0;
}

//Rotating an Array by d

#include <iostream>
using namespace std;

int main() {
	int t,s;
	cin>>s;
	for(int t=0;t<s;t++){
	    int n;
	    cin>>n;
	    int a[n];
	    for(int i=0;i<n;i++){
	        cin>>a[i];
	    }
	    int d;
	    cin>>d;
	    int x = n-d;
	    int b[n];
	    for(int i=0;i<n;i++){
	        b[(i+x)%n] = a[i];
	        
	    }
	    for(int i=0;i<n;i++){
	        cout<<b[i]<<" ";
	    }
	    cout<<endl;
	}
	return 0;
}


//Cyclically rotate an array by one

#include <iostream>
using namespace std;

int main() {
	int t,s;
	cin>>t;
	for(int s=0;s<t;s++){
	    int n;
	    cin>>n;
	    int a[n];
	    int j;
	    for(int i=0;i<n;i++){
	        cin>>a[i];
	    }
	    int temp = a[n-1];
	    for(int j=n-1;j>0;j--){
	        a[j]=a[j-1];
	    }
	    a[0]=temp;
	    for(int i=0;i<n;i++){
	        cout<<a[i]<<" ";
	    }
	    cout<<endl;
	}
	return 0;
}

//Given an array A[] and a number x, check for pair in A[] with sum as x

#include <iostream>
using namespace std;
void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}
 
void bubbleSort(int arr[], int n)
{
   int i, j;
   for (i = 0; i < n-1; i++)      
 
       for (j = 0; j < n-i-1; j++) 
           if (arr[j] > arr[j+1])
              swap(&arr[j], &arr[j+1]);
}

int main() {
    int t,s;
    cin>>s;
    for(int t=0;t<s;t++){
        int n;
        cin>>n;
        int sum;
        cin>>sum;
        int a[n];
        for(int i=0;i<n;i++){
            cin>>a[i];
        }
        bubbleSort(a,n);
        int l=0;
        int r=n-1;
        int c=0;
        while(l<r){
            if(a[l]+a[r]==sum){
                cout<<"Yes"<<endl;
                c++;
                break;
            }
            else if(a[l]+a[r]>sum)
                r--;
            else if(a[l]+a[r]<sum)
                l++;
        }
        if(c==0){
            cout<<"No"<<endl;
        }   
    }
	return 0;
}


//Given a sorted and rotated array, find if there is a pair with a given sum

#include <iostream>
using namespace std;

int main() {
	int n;
	cin>>n;
	int a[n];
	int sum;
	cin>>sum;
	int i;
	for(i=0;i<n;i++){
	    cin>>a[i];
	}
	for(i = 0;i<n;i++){
	    if(a[i]>a[i+1])
	        break;
	}
	int r = i;
	int l = (i+1)%n;
	int c=0;
	while(l!=r){
	    if(a[l]+a[r]==sum){
	        cout<<"Yes"<<endl;
	        c++;
	        break;
	    }
	    else if(a[l]+a[r]<sum)
	        l = (l + 1)%n;
	    else if(a[l]+a[r]>sum)
	        r = (n+r-1)%n;
	}
	if(c==0){
	    cout<<"No"<<endl;
	}
	
	return 0;
}


//Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed

#include <iostream>
using namespace std;

int main(){
	int n;
	cin>>n;
	int a[n];
	int arrsum=0;
	int arrsumwithindex = 0;
	for(int i=0;i<n;i++){
		cin>>a[i];
		arrsum = arrsum+ a[i];
		arrsumwithindex = arrsumwithindex + i*a[i];
	}
	int maxvalue = arrsumwithindex;
	for(int i=1;i<n;i++){
		arrsumwithindex = arrsumwithindex + arrsum - n*a[n-j];
		if(arrsumwithindex>maxvalue)
			maxvalue = arrsumwithindex;
	}
	return maxvalue;
}


//Given a sorted array which is rotated 'N' times. Find the value of 'N'.


#include <iostream>
using namespace std;
int main() {
	int t,s;
	cin>>t;
	for(s=0;s<t;s++){
	    int n;
	    cin>>n;
	    int a[n];
	    for(int i=0;i<n;i++){
	        cin>>a[i];
	    }
	    int i=0;
	    int c=0;
	    while(i<n){
	        if(a[i]>a[i+1]){
	            c=i+1;
	            break;
	        }
	        i++;
	    }
	    cout<<c%n<<endl;
	}
	return 0;
}

//Given an array of size n and multiple values around which we need to left rotate the array.


#include <iostream>
using namespace std;

int main() {
	int t,s;
	cin>>t;
	for(int s=0;s<t;s++){
	    int n;
	    cin>>n;
	    int d;
	    cin>>d;
	    int a[n];
	    
	    for(int i=0;i<n;i++){
	        cin>>a[i];
	    }
	    
	    int b[n];
	    d=d%n;
	    for(int i=0;i<n;i++){
	        b[(n+i-d)%n]=a[i];
	    }
	    
	    for(int i=0;i<n;i++){
	        cout<<b[i]<<" ";
	    }
	    cout<<endl;
	}
	return 0;
}

//A sorted array A[ ] with distinct elements is rotated at some unknown point, the task is to find the minimum element in it.

#include <iostream>
using namespace std;

int main() {
    int t,s;
    cin>>s;
    for(int t=0;t<s;t++){
        int n;
	    cin>>n;
    	int a[n];
	    
	    for(int i=0;i<n;i++){
	        cin>>a[i];
	    }
	    int i=-1;
	    for(i = 0;i<n;i++){
	        if(a[i]>a[i+1])
	            break;
	    }
	    if(i==n){
	        cout<<a[0]<<endl;
	    }
	    else{
	        cout<<a[(i+1)%n]<<endl;
	    }
	 }
	return 0;
}


//Reversal algorithm for right rotation of an array

#include <iostream>
using namespace std;

int main() {
	int t,s;
	cin>>t;
	for(int s=0;s<t;s++){
	    int n;
	    cin>>n;
	    int d;
	    cin>>d;
	    int a[n];
	    
	    for(int i=0;i<n;i++){
	        cin>>a[i];
	    }
	    
	    int b[n];
	    d=d%n;
	    for(int i=0;i<n;i++){
	        b[(n+i+d)%n]=a[i];
	    }
	    
	    for(int i=0;i<n;i++){
	        cout<<b[i]<<" ";
	    }
	    cout<<endl;
	}
	return 0;
}


//Print left rotation of array in O(n) time and O(1) space

#include <iostream>
using namespace std;

int main() {
	int t,s;
	cin>>t;
	for(int s=0;s<t;s++){
	    int n;
	    cin>>n;
	    int d;
	    cin>>d;
	    int a[n];
	    
	    for(int i=0;i<n;i++){
	        cin>>a[i];
	    }
	    
	    d=d%n;
	    for(int i=0;i<n;i++){
	        cout<<a[(n+i+d)%n]<<" ";
	    }
	    
	    cout<<endl;
	}
	return 0;
}

// Dated : June 16

//Split the array and add the first part to the end

#include <iostream>
using namespace std;

int main() {
	int n;
	cin>>n;
	int k;
	cin>>k;
	int a[n];
	for(int i=0;i<n;i++){
	    cin>>a[i];
	}
	for(int i=k;i<n;i++){
	    cout<<a[i]<<" ";
	}
	for(int i=0;i<k;i++){
	    cout<<a[i]<<" ";
	}
	return 0;
}

//Move all zeroes to end of array

#include <iostream>
using namespace std;

int main() {
    int t,s;
    cin>>s;
    for(int t=0;t<s;t++){
        int n;
        cin>>n;
        int a[n];
        int x,j=n-1;
        int k=0;
        for(int i=0;i<n;i++){
            cin>>x;
            if(x==0){
                a[j]=x;
                j--;
            }
            else{
                a[k]=x;
                k++;
            }
        }
        for(int i=0;i<n;i++){
            cout<<a[i]<<" ";
        }
        cout<<endl;
    }
	return 0;
}

//Rearrange positive and negative numbers

#include <iostream>
using namespace std;

int main() {
    int n;
    cin>>n;
    int a[n],x,j=0;
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    for(int i=0;i<n;i++){
        if(a[i]<0)
            cout<<a[i]<<" ";
    }
    
    for(int i=0;i<n;i++){
        if(!(a[i]<0))
            cout<<a[i]<<" ";
    }
    
	return 0;
}

//Rearrange array such that even positioned are greater than odd

#include <iostream>
using namespace std;

void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}
 
void bubbleSort(int arr[], int n)
{
   int i, j;
   for (i = 0; i < n-1; i++)      
 
       for (j = 0; j < n-i-1; j++) 
           if (arr[j] > arr[j+1])
              swap(&arr[j], &arr[j+1]);
}

int main() {
	int t,s,temp;
	cin>>t;
	for(int s=0;s<t;s++){
	    int n;
	    cin>>n;
	    int a[n];
	    for(int i = 0;i<n;i++){
	        cin>>a[i];
	    }
	    bubbleSort(a,n);
	    int b[n];
	    int y;
	    if(n%2==0){
	         y = n/2;
	    }
	    else{
	         y = (n+1)/2;
	    }
	    for(int i=0;i<y;i++){
	        b[2*i]=a[i];
	        b[2*i+1]=a[n-i-1];
	    }
	    for(int i = 0;i<n;i++){
	        cout<<b[i]<<" ";
	    }
	    cout<<endl;
	}
	return 0;
}

//Given an array of integers, task is to print the array in the order – 
//smallest number, Largest number, 2nd smallest number, 2nd largest number, so on..

#include <iostream>
using namespace std;

void swap(int *xp, int *yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}
 
void bubbleSort(int arr[], int n)
{
   int i, j;
   for (i = 0; i < n-1; i++)      
 
       for (j = 0; j < n-i-1; j++) 
           if (arr[j] > arr[j+1])
              swap(&arr[j], &arr[j+1]);
}

int main() {
	int t,s,temp;
	cin>>t;
	for(int s=0;s<t;s++){
	    int n;
	    cin>>n;
	    int a[n];
	    for(int i = 0;i<n;i++){
	        cin>>a[i];
	    }
	    bubbleSort(a,n);
	    int b[n];
	    int y;
	    if(n%2==0){
	         y = n/2;
	    }
	    else{
	         y = (n+1)/2;
	    }
	    for(int i=0;i<y;i++){
	        b[2*i]=a[i];
	        b[2*i+1]=a[n-i-1];
	    }
	    for(int i = 0;i<n;i++){
	        cout<<b[i]<<" ";
	    }
	    cout<<endl;
	}
	return 0;
}


//Double the first element and move zero to end

#include <iostream>
using namespace std;

int main() {
	int t,s;
	cin>>t;
	for(s=0;s<t;s++){
	    int n,j,temp;
	    cin>>n;
	    int a[n];
	    for(int i=0;i<n;i++){
	        cin>>a[i];
	    }
	    for(int i=0;i<n;i++){
	        if(a[i]==a[i+1] && a[i]!=0){
	            a[i]=2*a[i];
	            a[i+1]=0;
	        }
	    }
	    int ctr=0;
	    for(int i=0;i<n;i++){
	        if(a[i]!=0){
	            cout<<a[i]<<" ";
	            ctr++;
	        }
	    }
	    for(int i=0;i<n-ctr;i++){
	        cout<<0<<" ";
	    }
	    cout<<endl;
	}
	return 0;
}

//Reorder an array according to given indexes

#include <iostream>
using namespace std;
int main() {
    int n ;
    cin>>n;
    int a[n];
    int idx[n];
    int b[n];
    for(int i = 0;i<n;i++){
        cin>>a[i];
    }
    for(int i = 0;i<n;i++){
        cin>>idx[i];
    }
    for(int i = 0;i<n;i++){
       b[idx[i]]=a[i];
    }
    for(int i = 0;i<n;i++){
        cout<<b[i]<<" ";
    }
    
}

//Rearrange an array such that ‘arr[j]’ becomes ‘i’ if ‘arr[i]’ is ‘j’ 

/*Another Method: 
The idea is to store each element’s new and old value as quotient and remainder of n, respectively (n being the size of the array).
For example, Suppose an element’s new value is 2, the old value is 1 and n is 3, 
then the element’s value is stored as 1 + 2*3 = 7. 
We can retrieve its old value by 7%3 = 1 and its new value by 7/3 = 2.
Thanks Prateek Oraon for suggesting this method.*/

#include <bits/stdc++.h>
using namespace std;
 

void rearrange(int arr[], int n)
{
    for(int i = 0; i < n; i++)
    {
        arr[arr[i] % n] = arr[arr[i] % n]  + i * n; 
    }
     
    for(int i = 0; i < n; i++)
    {
         
        arr[i] = arr[i]/n;
    }
}
 
int main()
{
    int arr[] = {2, 0, 1, 4, 5, 3};
    int n = sizeof(arr)/sizeof(arr[0]);
    rearrange(arr, n);
     
    for (int i = 0; i < n; i++)
    cout << arr[i] << " ";
    cout << endl; 
    return 0;
}

//Rearrange Array Alternately

#include <iostream>
using namespace std;

int main() {
    int t,s;
    cin>>t;
    for(int s=0;s<t;s++){
        int n;
        cin>>n;
        int a[n];
        for(int i=0;i<n;i++){
            cin>>a[i];
        } 
        int b[n];
        int i,j;
        for(i=0;i<n;i++){
            b[2*i]=a[n-1-i];
            b[2*i+1]=a[i];
        }
        
        for(int i=0;i<n;i++){
            cout<<b[i]<<" ";
        } 
        cout<<endl;
    }
	return 0;
}


// Rearrange an array in maximum minimum form  O(1) space & O(n) space
#include <bits/stdc++.h>
using namespace std;
 
void rearrange(int arr[], int n)
{
    int max_idx = n-1 , min_idx = 0 ;
    int max_elem = arr[n-1] + 1 ;
    for (int i=0; i < n ; i++)
    {
        if (i % 2 == 0)
        {
            arr[i] += (arr[max_idx] % max_elem ) * max_elem;
            max_idx--;
        }
        else
        {
            arr[i] += (arr[min_idx] % max_elem ) * max_elem;
            min_idx++;
        }
    }
 
    for (int i = 0 ; i < n; i++)
        arr[i] = arr[i] / max_elem ;
}
 
int main() {
	int t,s;
	cin>>t;
	for(int s=0;s<t;s++){
	    int n;
	    cin>>n;
	    int a[n];
	    for(int i=0;i<n;i++){
	        cin>>a[i];
	    }
	    rearrange(a,n);
	    for(int i=0;i<n;i++){
	        cout<<a[i]<<" ";
	    }
	    cout<<endl;
	}
	return 0;
	
}

//Move all negative elements to end in order with extra space allowed

#include <iostream>
using namespace std;

int main() {
	int t,s;
	cin>>t;
	for(s=0;s<t;s++){
	    int n;
	    cin>>n;
	    int a[n];
	    for(int i=0;i<n;i++){
	        cin>>a[i];
	    }
	    int b[n];
	    int k=0;
	    for(int i=0;i<n;i++){
	        if(a[i]>-1){
	            b[k]=a[i];
	            k++;
	        }
	    }
	    for(int i=0;i<n;i++){
	        if(a[i]<0){
	            b[k]=a[i];
	            k++;
	        }
	    }
	    for(int i=0;i<n;i++){
	        cout<<b[i]<<" ";
	    }
	    cout<<endl;
	}
	
	return 0;
}