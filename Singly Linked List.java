Singly Linked List

// Dated : June 25

//LinkedList
class LinkedList
{
    Node head;
    class Node
    {
        int data;
        Node next;
        Node(int d) {
        	data = d; 
        	next = null; 
        }
    }
}

//Insertion at front
public void push(int new_data)
{
    Node new_node = new Node(new_data);
    new_node.next = head;
    head = new_node;
}

//Insertion after a given node
public void insertAfter(Node prev_node, int new_data)
{
    if (prev_node == null)
    {
        System.out.println("The given previous node cannot be null");
        return;
    }
 	Node new_node = new Node(new_data);
 	new_node.next = prev_node.next;
 	prev_node.next = new_node;
}

//Insertion at the end
public void append(int new_data)
{
    Node new_node = new Node(new_data);
 	if (head == null)
    {
        head = new Node(new_data);
        return;
    }
 	new_node.next = null;
 	Node last = head; 
    while (last.next != null)
        last = last.next;
 	last.next = new_node;
    return;
}

//Deleting a node
void deleteNode(int key){
	Node temp = head, prev = null;
 	if (temp != null && temp.data == key)
    {
   	    head = temp.next;
        return;
    }
 	while (temp != null && temp.data != key)
    {
        prev = temp;
        temp = temp.next;
    }    
 	if (temp == null) 
        return;
 	prev.next = temp.next;
}

//Delete a Linked List node at a given position
    //Starting pos is 0 in this code
void deleteNode(int position)
    {
    	if (head == null)
            return;

 		Node temp = head;
 		if (position == 0)
        {
            head = temp.next;   // Change head
            return;
        }

        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;

 		if (temp == null || temp.next == null)
            return;
 		
        Node next = temp.next.next;
 		temp.next = next;  
 	}

//Write a function to delete a Linked List

void deleteList()
    {
        head = null;
    }


//Cal length of linkedlist
 	//iterative
public int getCount()
    {
        Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    //recursive
public int getCountRec(Node node)
    {
        if (node == null)
            return 0;
 		return 1 + getCountRec(node.next);
    }

    /* Wrapper over getCountRec() */
    public int getCount()
    {
        return getCountRec(head);
    }


//Search an element
    //iterative
public boolean search(Node head, int x)
    {
        Node current = head;    
        while (current != null)
        {
            if (current.data == x)
                return true;    //data found
            current = current.next;
        }
        return false;    //data not found
    }
    
    //recursive
public boolean search(Node head, int x)
    {
        // Base case
        if (head == null)
            return false;
 
        // If key is present in current node,
        // return true
        if (head.data == x)
            return true;
 
        // Recur for remaining list
        return search(head.next, x);
    }


//Function to get Nth node in a Linked List
public int GetNth(int index)
    {
        Node current = head;
        int count = 0; 
        while (current != null)
        {
            if (count == index)
                return current.data;
            count++;
            current = current.next;
        }
        return 0;
    }

//Program for n’th node from the end of a Linked List
int getNthFromLast(Node head, int n)
    {
        Node temp = head;
        Node tempp = head;
        
        for(int i =0;i<n && temp!=null;i++){
            temp=temp.next;
        }
        while(temp!=null){
            temp=temp.next;
            tempp=tempp.next;
        }
        return tempp.data;
    }

//Finding middle element in a linked list
int getMiddle(Node head)
    {
        if(head==null){
            return 0;
        }
        Node fast = head;
        Node slow = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;    
    }

//Write a function that counts the number of times a given int occurs in a Linked List
int count(Node head, int searchFor){
    Node temp = head;
    int c=0;
    while(temp!=null){
        if(temp.data == searchFor){
            c++;
        }
        temp=temp.next;
    }
    return c;
}

//Detect Loop in linked list
int detectLoop(Node head)
  {
    Node temp = head;  
    HashSet<Node> s = new HashSet<Node>();

    while(temp!=null){
        if(s.contains(temp)){
            return 1;
        }
        s.add(temp);
        temp = temp.next;
    }
    return 0;
    }

//Dated : June 26

//Remove duplicate element from sorted Linked List

Node removeDuplicates(Node head)
    {
        if(head==null){
            return null;
        }
        Node temp = head;
        while(temp.next!=null){
            if(temp.data==temp.next.data){
                temp.next=temp.next.next;
            }
            else{
                temp=temp.next;    
            }
        }
        return head;
    }    

//Remove duplicates from an unsorted linked list

Node removeDuplicates(Node head)
    {
        if(head==null){
            return null;
        }
        Node temp=head.next;
        Node prev = head;
        HashSet<Integer> s = new HashSet<Integer>();
        
        s.add(head.data);
        while(temp!=null){
            if(s.contains(temp.data)){
                temp=temp.next;
                prev.next = temp;
                
            }
            else{
                s.add(temp.data);
                prev=temp;
                temp=temp.next;
            }
        }
        return head;
    }

//Swap nodes in a linked list without swapping data
public void swapNodes(int x, int y)
    {
        if (x == y) return; 
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x)
        {
            prevX = currX;
            currX = currX.next;
        } 
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y)
        {
            prevY = currY;
            currY = currY.next;
        }
        if (currX == null || currY == null)
            return;
        if (prevX != null)
            prevX.next = currY;
            head = currY; 
        if (prevY != null)
            prevY.next = currX;
        else
            head = currX;
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

//Pairwise swap elements of a given linked list

void pairWiseSwap()
    {
        Node temp = head;
 
        while (temp != null && temp.next != null) {
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
         }
    }    


//Move last element to front of a given Linked List

 void moveToFront()
    {
        if(head == null || head.next == null) 
              return;
 
        Node secLast = null;
        Node last = head;

        while (last.next != null)  
        {
           secLast = last;
           last = last.next; 
        }
        secLast.next = null;
        last.next = head;
        head = last;
    }          
           

//Write a function to get the intersection point of two Linked Lists.

int intersectPoint(Node headA, Node headB)
    {
        HashSet<Integer> s = new HashSet<Integer> ();
        
        while(headA!=null){
            s.add(headA.data);
            headA=headA.next;
        }
        while(headB!=null){
            if(s.contains(headB.data)){
                return headB.data;
            }
            headB=headB.next;
        }
        
        return -1;
    }



//Reverse a linked list
    // IMPORTANT QUESTION : https://www.geeksforgeeks.org/reverse-a-linked-list/
    
    //iterative
Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    //recursive
void printRecRevList(Node head){
    if (node==null) {
        return; 
    }
    printRecRevList(head.next);
    System.out.print(head.data+" ");
}



----

//Merge two sorted Linkedlists
Node MergeLists(Node headA, Node headB) {
    if (headA == null){
        return headB;
    }
    if (headB == null){
        return headA;
    }
    if (headA.data < headB.data){
        headA.next = MergeLists(headA.next, headB);
        return headA;
    }
    else {
        headB.next = MergeLists(headA, headB.next);
        return headB;
    }
}

//Funtion to Delete alternate nodes of a Linked List
Node DeleteAlt(Node head){
	Node prev = head;
	Node current = head.next;
	while(prev!=null && current!=null){
		prev.next=current.next;
		current=null;
		prev=prev.next;
		if(prev!=null){
			current=prev.next;
		}
	}
}
//Funtion to check Identical Linked Lists
boolean checkIdentical(Node headA, Node headB){
	while(headA!=null && headB!=null){
		if(headA.data != headB.data){
			return false;
		}
		headA=headA.next;
		headB=headB.next;
	}
	if (headA!=null && headB!=null) {
		return true;
	}
	return false;
}
//Function to Reverse a Linked List in groups of given size
Node reverseSize(Node head, int k){
	Node current=head;
	Node next = null;
	Node prev = null;

	int count=0;

	while(current!=null && k<count){
		next = current.next;
        current.next = prev;
        prev = current;
        current = next;
        count++;
	}
	/* next is now a pointer to (k+1)th node 
	          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
    if (next != null) 
        head.next = reverse(next, k);
 
      // prev is now head of input list
    return prev;
}
//Delete nodes which have a greater value on right side
void delLesserNodes(){
	Node h = head;
	while(h.data<h.next.data){
		h=h.next;
	}
	Node prev=h;
	Node current=prev.next;
	while(current.next!=null){
		if(current.data<current.next.data){
			prev.next=current.next;
			current=current.next;
		}
		else{
			prev=current;
			current=current.next;
		}
	}
	head=h;
}
//Segregate even and odd nodes in a Linked List
void segregateEvenOdd(){
    	Node l = head;
    	Node h = head;

    	while(l.next!=null){
    		l=l.next;
    	}
    	Node lst = l;

	    while(h.data%2!=0){
	    	Node temp = h;
	    	h=h.next;
	    	lst.next=temp;
	    	lst.next.next=null;
	    	lst = lst.next;
	    }
	    Node prev = h;
	    Node e = h.next;

	    while(e!=l){
	       if(e.data%2!=0){
			    prev.next= e.next;	
			    e.next=null;
			    lst.next=e;
			    lst.next.next=null;
			    lst = lst.next;
			    e=prev.next;
	    	}else{
	    	    prev=prev.next;
	    	    e=e.next;
	    	}
	    }
	    head = h;
	}

//Remove loop in Linked List //import java.util.*; use this please
int removeTheLoop(Node node) {
	      Node h = node;
    	Node prev = null;
    	HashSet<Node> s = new HashSet<Node>();
	    while(h!=null){
		    if(s.contains(h)){
	    		prev.next=null;
		    	return 1; //1 for true
		    }
		    s.add(h);
		    prev=h;
		    h=h.next;
	    }
	    return 0;
    }
 //Node addTwoLists(Node headA, Node headB){
        int c = 0;
        Node res = null;
        Node curr = new Node(0);
        res = curr;
        while(){

                curr.next = new Node(s);
        
        }
        return head;
    }
//Add two numbers represented by linked lists
Node addTwoLists(Node headA, Node headB){
        int c = 0;
        Node head = null;
        Node curr = null;
        while(headA!=null || headB!=null){
            int s = 0;
            if(headA!=null && headB!=null){
                 s = headA.data + headB.data + c;
                 headA=headA.next;
                 headB=headB.next;   
            }
            else if(headA==null && headB!=null){
                 s = headB.data + c;
                headB=headB.next;
            }
            else if(headA!=null && headB==null){
                 s = headA.data + c;
                 headA=headA.next;
            }
            
            if(s>=10){
                s=s-10;
                c=1;
            }else{
                c=0;
            }
            Node temp = new Node(s);
            if (head == null) {
                head = temp;
                curr = head;
            }
            else {
                curr.next = temp;
                curr = curr.next;
            }
        }
        if(c!=0){
            Node temp = new Node(c);
            curr.next = temp;
        }
        return head;
    }

//Intersection of two Linked Lists  --- NOT TESTED
Node getInteresection(Node headA, Node headB){
	Hashset<Integer> s = new Hashset<Integer>();
	Node head = null;
	Node curr = null;
	while(headA!=null){
		s.add(headA.data);
		headA=headA.next;
	}
	while(headB!=null){
		if(s.contains(headB.data)){
			Node temp = new Node(headB.data);
			if(head==null){
				head = temp;
				curr = temp;
			}else {
				curr.next=temp;
				curr=curr.next;
			}
		}
	}
	return head;
}
//Union of two Linked Lists    ---NOT TESTED
Node getUnion(Node headA, node headB){
	Hashset<Integer> s = new Hashset<Integer>();
	Node head = null;
	Node curr = null;
	while(headA!=null){
		s.add(headA.data);
		headA=headA.next;
		Node temp = new Node(headA.data);
		if(head==null){
				head = temp;
				curr = temp;
			}else {
				curr.next=temp;
				curr=curr.next;
			}
		headA=headA.next;	
	}
	while(headB!=null){
		if(!s.contains(headB.data))
		{
			Node temp = new Node(headB.data);
			if(head==null)
			{
				head = temp;
				curr = temp;
			}else 
			{
				curr.next=temp;
				curr=curr.next;
			}
		}
		headB=headB.next;
	}
	return head;
}
//Find a triplet from three linked lists with sum equal to a given number
 boolean isSumSorted((Node headA, Node headB, Node headC, int givenNumber)
   {
      Node a = headA;
      while (a != null)
      {
          Node b = headB;
          Node c = headC;
          while (b != null && c!=null)
          {
              int sum = a.data + b.data + c.data;
              if (sum == givenNumber)
              {
               return true;
              }
 			   else if (sum < givenNumber)
                b = b.next;
              else
                c = c.next;
          }
          a = a.next;
      }
      return false;
   }
//Rotate a Linked List
public void rotate(Node head,int k)
        {
            if (k == 0) return;
            
            Node last = head;
            while(last.next!=null){
                last= last.next;
            }
            while(k>0 && head!=null){
                Node temp = new Node(head.data);
                head = head.next;
                last.next = temp;
                last = last.next;
                k--;
            }
            
            Node temp = head;
		    while(temp != null)
	    	{
		    	System.out.print(temp.data+" ");
		    	temp = temp.next;
		    }   
         }
//Flattening a Linked List --- THIS QUESTION SUCKS nodes to be added at bottom not to the right

/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
        Node sortedMerge(Node a, Node b) 
    {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;
 
        /* Pick either a or b, and recur */
        if (a.data <= b.data) 
        {
            result = a;
            result.bottom = sortedMerge(a.bottom, b);
        } 
        else
        {
            result = b;
            result.bottom = sortedMerge(a, b.bottom);
        }
        return result;
 
    }
 
    Node mergeSort(Node h) 
    {
        // Base case : if head is null
        if (h == null || h.bottom == null)
        {
            return h;
        }
 
        // get the middle of the list
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.bottom;
 
        // set the next of middle Node to null
        middle.bottom = null;
 
        // Apply mergeSort on left list
        Node left = mergeSort(h);
 
        // Apply mergeSort on right list
        Node right = mergeSort(nextofmiddle);
 
        // Merge the left and right lists
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }
 
    // Utility function to get the middle of the linked list
    Node getMiddle(Node h) 
    {
        //Base case
        if (h == null)
            return h;
        Node fastptr = h.bottom;
        Node slowptr = h;
         
        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle Node
        while (fastptr != null)
        {
            fastptr = fastptr.bottom;
            if(fastptr!=null)
            {
                slowptr = slowptr.bottom;
                fastptr=fastptr.bottom;
            }
        }
        return slowptr;
    }
    Node flatten(Node root){
        if(root==null || root.next==null){
            return root;
        }
    	Node node = root;
    	Node last = root;
    	while(last.bottom!=null){
    		last = last.bottom;
    	}
    	node = node.next;
    	while(node.next!=null){
    		Node b = node;
    		last.bottom = b;
    		while(b.bottom!=null){
    			b=b.bottom;
	    	}
	    	last = b;
	    	node=node.next;
	    }
	    last.bottom = node;
	    return mergeSort(root);
    }
}         

