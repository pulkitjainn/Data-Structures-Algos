===================
= Stacks - Queues =
===================


// Implement Stack using Queues

class GfG { 
  
static class Stack  
{  
    // Two inbuilt queues  
    static Queue<Integer> q1 = new LinkedList<Integer>(); 
    static Queue<Integer> q2 = new LinkedList<Integer>();  
      
    // To maintain current number of  
    // elements  
    static int curr_size;  
  
    Stack()  
    {  
        curr_size = 0;  
    }  
  
    static void push(int x)  
    {  
        curr_size++;  
  
        // Push x first in empty q2  
        q2.add(x);  
  
        // Push all the remaining  
        // elements in q1 to q2.  
        while (!q1.isEmpty())  
        {  
            q2.add(q1.peek());  
            q1.remove();  
        }  
  
        // swap the names of two queues  
        Queue<Integer> q = q1;  
        q1 = q2;  
        q2 = q;  
    }  
  
    static void pop(){  
  
        // if no elements are there in q1  
        if (q1.isEmpty())  
            return ;  
        q1.remove();  
        curr_size--;  
    }  
  
    static int top()  
    {  
        if (q1.isEmpty())  
            return -1;  
        return q1.peek();  
    }  
  
    static int size()  
    {  
        return curr_size;  
    }  
};  
  
// driver code  
public static void main(String[] args)  
{  
    Stack s = new Stack();  
    s.push(1);  
    s.push(2);  
    s.push(3);  
  
    System.out.println("current size: " + s.size());  
    System.out.println(s.top());  
    s.pop();  
    System.out.println(s.top());  
    s.pop();  
    System.out.println(s.top());  
  
    System.out.println("current size: " + s.size());  
} 
}  



// Queue using Stacks


class GFG  
{  
static class Queue  
{  
    static Stack<Integer> s1 = new Stack<Integer>();  
    static Stack<Integer> s2 = new Stack<Integer>();  
  
    static void enQueue(int x)  
    {  
        // Move all elements from s1 to s2  
        while (!s1.isEmpty()) 
        {  
            s2.push(s1.pop());  
            //s1.pop();  
        }  
  
        // Push item into s1  
        s1.push(x);  
  
        // Push everything back to s1  
        while (!s2.isEmpty())  
        {  
            s1.push(s2.pop());  
            //s2.pop();  
        }  
    }  
  
    // Dequeue an item from the queue  
    static int deQueue()  
    {  
        // if first stack is empty  
        if (s1.isEmpty())  
        {  
            System.out.println("Q is Empty");  
            System.exit(0);  
        }  
  
        // Return top of s1  
        int x = s1.peek();  
        s1.pop();  
        return x;  
    }  
};  
  
// Driver code  
public static void main(String[] args)  
{  
    Queue q = new Queue();  
    q.enQueue(1);  
    q.enQueue(2);  
    q.enQueue(3);  
  
    System.out.println(q.deQueue());  
    System.out.println(q.deQueue()); 
    System.out.println(q.deQueue()); 
}  
}  


// Histogram Area

static int getMaxArea(int hist[], int n)  
    { 
        // Create an empty stack. The stack holds indexes of hist[] array 
        // The bars stored in stack are always in increasing order of their 
        // heights. 
        Stack<Integer> s = new Stack<>(); 
          
        int max_area = 0; // Initialize max area 
        int tp;  // To store top of stack 
        int area_with_top; // To store area with top bar as the smallest bar 
       
        // Run through all bars of given histogram 
        int i = 0; 
        while (i < n) 
        { 
            // If this bar is higher than the bar on top stack, push it to stack 
            if (s.empty() || hist[s.peek()] <= hist[i]) 
                s.push(i++); 
       
            // If this bar is lower than top of stack, then calculate area of rectangle  
            // with stack top as the smallest (or minimum height) bar. 'i' is  
            // 'right index' for the top and element before top in stack is 'left index' 
            else
            { 
                tp = s.peek();  // store the top index 
                s.pop();  // pop the top 
       
                // Calculate the area with hist[tp] stack as smallest bar 
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1); 
       
                // update max area, if needed 
                if (max_area < area_with_top) 
                    max_area = area_with_top; 
            } 
        } 
       
        // Now pop the remaining bars from stack and calculate area with every 
        // popped bar as the smallest bar 
        while (s.empty() == false) 
        { 
            tp = s.peek(); 
            s.pop(); 
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1); 
       
            if (max_area < area_with_top) 
                max_area = area_with_top; 
        } 
       
        return max_area; 
  
    }


// Stock span problem


static void calculateSpan(int price[], int n, int S[]) 
    { 
        // Create a stack and push index of first element 
        // to it 
        Stack<Integer> st= new Stack<>(); 
        st.push(0);  
          
        // Span value of first element is always 1 
        S[0] = 1; 
          
        // Calculate span values for rest of the elements 
        for (int i = 1; i < n; i++) 
        { 
  
            // Pop elements from stack while stack is not  
            // empty and top of stack is smaller than  
            // price[i] 
            while (!st.empty() && price[st.peek()] <= price[i]) 
                st.pop(); 
      
            // If stack becomes empty, then price[i] is  
            // greater than all elements on left of it, i.e.,  
            // price[0], price[1],..price[i-1]. Else price[i] 
            // is greater than elements after top of stack 
            S[i] = (st.empty())? (i + 1) : (i - st.peek()); 
      
            // Push this element to stack 
            st.push(i); 
        } 
    }



// Infix to Postfix
    
static String infixToPostfix(String exp) 
    { 
        // initializing empty String for result 
        String result = new String(""); 
          
        // initializing empty stack 
        Stack<Character> stack = new Stack<>(); 
          
        for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i); 
              
             // If the scanned character is an operand, add it to output. 
            if (Character.isLetterOrDigit(c)) 
                result += c; 
               
            // If the scanned character is an '(', push it to the stack. 
            else if (c == '(') 
                stack.push(c); 
              
            //  If the scanned character is an ')', pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')') 
            { 
                while (!stack.isEmpty() && stack.peek() != '(') 
                    result += stack.pop(); 
                  
                if (!stack.isEmpty() && stack.peek() != '(') 
                    return "Invalid Expression"; // invalid expression                 
                else
                    stack.pop(); 
            } 
            else // an operator is encountered 
            { 
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) 
                    result += stack.pop(); 
                stack.push(c); 
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.isEmpty()) 
            result += stack.pop(); 
       
        return result; 
    } 


//Sliding window 

    static void printMax(int arr[],int n, int k) 
    { 
        // Create a Double Ended Queue, Qi that will store indexes of array elements 
        // The queue will store indexes of useful elements in every window and it will 
        // maintain decreasing order of values from front to rear in Qi, i.e.,  
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order 
        Deque<Integer> Qi = new LinkedList<Integer>(); 
          
        /* Process first k (or first window) elements of array */
        int i; 
        for(i = 0; i < k; ++i) 
        { 
            // For every element, the previous smaller elements are useless so 
            // remove them from Qi 
            while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) 
                Qi.removeLast();   // Remove from rear 
              
            // Add new element at rear of queue 
            Qi.addLast(i); 
        } 
          
        // Process rest of the elements, i.e., from arr[k] to arr[n-1] 
        for( ;i < n; ++i) 
        { 
            // The element at the front of the queue is the largest element of 
            // previous window, so print it 
            System.out.print(arr[Qi.peek()] + " "); 
              
            // Remove the elements which are out of this window 
            while((!Qi.isEmpty()) && Qi.peek() <= i-k) 
                Qi.removeFirst(); 
              
            // Remove all elements smaller than the currently 
            // being added element (remove useless elements) 
            while((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()]) 
                Qi.removeLast(); 
              
  
            // Add current element at the rear of Qi 
            Qi.addLast(i); 
              
        } 
          
        // Print the maximum element of last window 
        System.out.print(arr[Qi.peek()]); 
    }


// Sort Stack using temporary stack

public static Stack<Integer> sortstack(Stack<Integer>  
                                             input) 
    { 
        Stack<Integer> tmpStack = new Stack<Integer>(); 
        while(!input.isEmpty()) 
        { 
            // pop out the first element 
            int tmp = input.pop(); 
          
            // while temporary stack is not empty and 
            // top of stack is greater than temp 
            while(!tmpStack.isEmpty() && tmpStack.peek()  
                                                 > tmp) 
            { 
                // pop from temporary stack and  
                // push it to the input stack 
            input.push(tmpStack.pop()); 
            } 
              
            // push temp in tempory of stack 
            tmpStack.push(tmp); 
        } 
        return tmpStack; 
    }


// Sort Stack using rec

// Recursive Method to insert an item x in sorted way 
    static void sortedInsert(Stack<Integer> s, int x) 
    { 
        // Base case: Either stack is empty or newly inserted 
        // item is greater than top (more than all existing) 
        if (s.isEmpty() || x > s.peek()) 
        { 
            s.push(x); 
            return; 
        } 
       
        // If top is greater, remove the top item and recur 
        int temp = s.pop(); 
        sortedInsert(s, x); 
       
        // Put back the top item removed earlier 
        s.push(temp); 
    } 
       
    // Method to sort stack 
    static void sortStack(Stack<Integer> s) 
    { 
        // If stack is not empty 
        if (!s.isEmpty()) 
        { 
            // Remove the top item 
            int x = s.pop(); 
       
            // Sort remaining stack 
            sortStack(s); 
       
            // Push the top item back in sorted stack 
            sortedInsert(s, x); 
        } 
    }