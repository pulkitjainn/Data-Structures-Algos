Doubly Linked List 

// Dated : June 28

public class DLL {
    Node head; // head of list
 
    /* Doubly Linked list Node*/
    class Node {
        int data;
        Node prev;
        Node next;
 
        // Constructor to create a new node
        // next and prev is by default initialized as null
        Node(int d) { data = d; }
    }
}

//Insert a node in Doubly linked list

void addNode(Node head_ref, int pos, int data)
	{
        if(head_ref==null){
            return;
        }
        Node temp = head_ref;
        Node temp_ahead = temp.next;
        Node new_node = new Node();
        new_node.data = data;
        int i=0;
        while(i<pos && temp_ahead!=null){
            temp = temp_ahead;
            temp_ahead = temp_ahead.next;
            i++;
        }
        if(temp_ahead!=null){
            new_node.next = temp_ahead;
            temp_ahead.prev = new_node;
        }
        temp.next = new_node;
        new_node.prev = temp;

	}
}

// Add a node at the front

// Adding a node at the front of the list
public void push(int new_data)
{
    /* 1. allocate node 
    * 2. put in the data */
    Node new_Node = new Node(new_data);
 
    /* 3. Make next of new node as head and previous as NULL */
    new_Node.next = head;
    new_Node.prev = null;
 
    /* 4. change prev of head node to new node */
    if (head != null)
        head.prev = new_Node;
 
    /* 5. move the head to point to the new node */
    head = new_Node;
}

//Add a node after a given node

/* Given a node as prev_node, insert a new node after the given node */
public void InsertAfter(Node prev_Node, int new_data)
{
 
    /*1. check if the given prev_node is NULL */
    if (prev_Node == null) {
        System.out.println("The given previous node cannot be NULL ");
        return;
    }
 
    /* 2. allocate node 
    * 3. put in the data */
    Node new_node = new Node(new_data);
 
    /* 4. Make next of new node as next of prev_node */
    new_node.next = prev_Node.next;
 
    /* 5. Make the next of prev_node as new_node */
    prev_Node.next = new_node;
 
    /* 6. Make prev_node as previous of new_node */
    new_node.prev = prev_Node;
 
    /* 7. Change previous of new_node's next node */
    if (new_node.next != null)
        new_node.next.prev = new_node;
}

//Add a node at the end

// Add a node at the end of the list
void append(int new_data)
{
    /* 1. allocate node 
     * 2. put in the data */
    Node new_node = new Node(new_data);
 
    Node last = head; /* used in step 5*/
 
    /* 3. This new node is going to be the last node, so
     * make next of it as NULL*/
    new_node.next = null;
 
    /* 4. If the Linked List is empty, then make the new
     * node as head */
    if (head == null) {
        new_node.prev = null;
        head = new_node;
        return;
    }
 
    /* 5. Else traverse till the last node */
    while (last.next != null)
        last = last.next;
 
    /* 6. Change the next of last node */
    last.next = new_node;
 
    /* 7. Make last node as previous of new node */
    new_node.prev = last;
}

//Delete node in Doubly Linked List

Node deleteNode(Node head,int x)
    {
	    if(head==null){
	        return null;
	    }
	    if(x==1){
	        head = head.next;
	        head.prev = null;
	        return head;
	    }
	    
	    Node temp = head;
	    Node temp_prev = null;
	    int i=1;
	    while(i<x){
	        temp_prev = temp;
	        temp = temp.next;
	        i++;
	    }
	    if(temp.next !=null){
	        temp.next.prev = temp_prev;
	        temp_prev.next = temp.next;    
	        return head;
	    }
	    temp_prev.next = null;
        return head;
    }

//Reverse a Doubly Linked List

Node reverse(Node head)
    {
        Node temp = null;
        Node current = head;
 
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
 
 
        if (temp != null) {
            head = temp.prev;
        }
        return head;
    }

// Swap Kth node from beginning with Kth node from end in a Linked List

void swapKth(int k)
    {
        int n = countNodes();

        if (n < k)
            return;

        if (2*k - 1 == n)
            return;
 
        Node x = head;
        Node x_prev = null;
        for (int i = 1; i < k; i++)
        {
            x_prev = x;
            x = x.next;
        }

		Node y = head;
        Node y_prev = null;
        for (int i = 1; i < n - k + 1; i++)
        {
            y_prev = y;
            y = y.next;
        } 

        if (x_prev != null)
            x_prev.next = y;
 
        if (y_prev != null)
            y_prev.next = x;
 
        Node temp = x.next;
        x.next = y.next;
        y.next = temp;

        if (k == 1)
            head = y;
 
        if (k == n)
            head = x;
    }

//Dated : June 29

//Find pairs with given sum in doubly linked list

public void findSumPairS(Node head, int x){
	Node last = head;
	while(last.next!=null){
		last=last.next;
	}
	while(head!=last){
		if(head.data+last.data < x)
			head=head.next;
		if(head.data+last.data > x)
			last=last.prev;
		if(head.data + last.data == x){
            System.out.println("(" + head.data + "," + last.data + ")"); 
            head=head.next;
            //last=last.prev;    
        }
	}

//Delete all occurrences of a given key in a doubly linked list

Node deleteNodes(Node head, int x){
	    if(head == null){
	    	return null;
	    }
	    while(head.data==x){
		    head=head.next;
            head.prev = null;
	    }
	    Node temp = head;
	    Node temp_ahead = temp.next;
	    while(temp_ahead!=null){
		    if(temp_ahead.data==x){
		    	temp_ahead.next.prev = temp;
			    temp.next = temp_ahead.next;
		    }
            temp = temp_ahead;
            temp_ahead=temp_ahead.next;
	    }
        return head;
    }

//Remove duplicates from an unsorted doubly linked list

        Node removeDublicates(Node head){
	    HashSet<Integer> s = new HashSet<Integer>();
	    s.add(head.data);
	    Node temp = head;
	    Node temp_ahead = head.next;
	    while(temp_ahead!=null){
	    	if (s.contains(temp_ahead.data)) {
	    	    if(temp_ahead.next!=null){
	    	        temp_ahead = temp_ahead.next;
	    	        temp_ahead.prev = temp;
	    	        temp.next=temp_ahead;
	    	    }
	    	    else{
	    	        temp.next=null;
	    	        temp_ahead.prev=null;
	    	    }
	    	}
		    else{
			    s.add(temp_ahead.data);
		    }
	        temp = temp_ahead;
		    temp_ahead = temp_ahead.next;
	    }
	    return head;
    }

//Sort the biotonic doubly linked list
/* A biotonic doubly linked list is a doubly linked list which is first increasing and then decreasing. 
A strictly increasing or a strictly decreasing list is also a biotonic doubly linked list.*/

    Node sort(Node head){
        Node last = head;
        while(last.next!=null){
            last = last.next;
        }
        while(head.data>last.data || head.data == last.data){
            Node new_node = new Node(last.data);
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
            last = last.prev;
            last.next = null;
        }  
        Node temp = head;
        while(temp!=last){
            if(temp.data>last.data || temp.data==last.data){
                Node new_node = new Node(last.data);
                new_node.prev = temp.prev;
                temp.prev.next = new_node;
                new_node.next = temp;
                temp.prev = new_node;
                last = last.prev;
                last.next = null;
            }
            else{
                temp = temp.next;
            }
        }
        return head;
    }


//Rotate Doubly linked list by N nodes

Node rotateByK(Node head, int x){

	if(head == null){
		return null;
	}
	Node last = head;
	while(last.next!=null){
		last = last.next;
	}
	last.next = head;
	head.prev = last;

	int i=0;
	while(i<x){
		last = head;
		head=head.next;
		i++;
	}
	head.prev = null;
	last.next =null;

	return head;
}