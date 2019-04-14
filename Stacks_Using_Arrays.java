Stacks using Arrays 

class Stack
{
    static final int MAX = 1000;
    int top=-1;
    int a[] = new int[MAX]; // Maximum size of Stack
 
    boolean isEmpty(){
        if(top==-1){
        	return true;
        }
        return false;
    }
 
    boolean push(int x){
        if (top >= (MAX-1)){
            System.out.println("Stack Overflow");
            return false;
        }
        else{
        	top++;
            a[top] = x;
            return true;
        }
    }
 
    int pop(){
        if (top==-1){
            System.out.println("Stack Underflow");
            return -1;
        }
        else{
            int x = a[top];
            top--;
            return x;
        }
    }
}
 