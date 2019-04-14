//STACKS
class Stack
{
	Node top;
    class Node
    {
        int data;
        Node next;
        Node(int d) {
        	data = d; 
        	next = null; 
        }
    }

    Node push(int data){
    	Node temp = new Node(data);
    	if(top==null){
    		top=temp;	
    	}else{
    		temp.next = top;
    		top = temp;		
    	}
    	return top;
    }

    int pop(){
    	if(top==null){
    		return -1;
    	}
    	Node temp = top;
    	top=top.next;
    	return temp.data;
    }

    boolean isEmpty(){
    	if(top==null){
    		return true;
    	}
    	return false;
    }
    
    void printStack(){
    	Node node = top;
    	while(node!=null){
    		System.out.print(node.data+" ");
    		node= node.next;
    	}
    	System.out.println();
    }
}

// Driver code
class Main
{
	public static void main(String args[])
	{
		Stack s = new Stack();
		System.out.println(s.isEmpty());
		s.push(10);
		s.push(20);
		s.push(30);
		s.printStack();
		System.out.println(s.isEmpty());
		int z =s.pop();
		s.printStack();
	}
}
