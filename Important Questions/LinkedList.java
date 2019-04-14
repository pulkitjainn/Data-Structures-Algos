===============
= Linked List =
===============

// Reverse

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


// Reverse recu

Node reverseUtil(Node curr, Node prev) { 
  
        /* If last node mark it head*/
        if (curr.next == null) { 
            head = curr; 
  
            /* Update next to prev node */
            curr.next = prev; 
              
            return head; 
        } 
  
        /* Save curr->next node for recursive call */
        Node next1 = curr.next; 
  
        /* and update next ..*/
        curr.next = prev; 
  
        reverseUtil(next1, curr); 
        return head; 
    }


//Print the last k nodes of the linked list in reverse order


static void printLastKRev(Node head, int count, int k)  
{  
    // if list is empty  
    if (head == null)  
        return;  
  
    // Recursive call with the next node  
    // of the list  
    printLastKRev(head.next, c, k);  
  
    // Count variable to keep track of  
    // the last k nodes  
    count++;  
  
    // Print data  
    if (count <= k)  
        System.out.print(head.data + " ");  
}


// K reverse 

Node reverse(Node head, int k) 
    { 
       Node current = head; 
       Node next = null; 
       Node prev = null; 
         
       int count = 0; 
  
       /* Reverse first k nodes of linked list */
       while (count < k && current != null)  
       { 
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



// Reverse alternate K nodes 


Node kAltReverse(Node node, int k) { 
        Node current = node; 
        Node next = null, prev = null; 
        int count = 0; 
  
        /*1) reverse first k nodes of the linked list */
        while (current != null && count < k) { 
            next = current.next; 
            current.next = prev; 
            prev = current; 
            current = next; 
            count++; 
        } 
  
        /* 2) Now head points to the kth node.  So change next  
         of head to (k+1)th node*/
        if (node != null) { 
            node.next = current; 
        } 
  
        /* 3) We do not want to reverse next k nodes. So move the current  
         pointer to skip next k nodes */
        count = 0; 
        while (count < k - 1 && current != null) { 
            current = current.next; 
            count++; 
        } 
  
        /* 4) Recursively call for the list starting from current->next. 
         And make rest of the list as next of first node */
        if (current != null) { 
            current.next = kAltReverse(current.next, k); 
        } 
  
        /* 5) prev is new head of the input list */
        return prev; 
    } 


// Flattening a Linked List


// An utility function to merge two sorted linked lists 
    Node merge(Node a, Node b) 
    { 
        // if first linked list is empty then second 
        // is the answer 
        if (a == null)     return b; 
  
        // if second linked list is empty then first 
        // is the result 
        if (b == null)      return a; 
  
        // compare the data members of the two linked lists 
        // and put the larger one in the result 
        Node result; 
  
        if (a.data < b.data) 
        { 
            result = a; 
            result.down =  merge(a.down, b); 
        } 
  
        else
        { 
            result = b; 
            result.down = merge(a, b.down); 
        } 
  
        return result; 
    } 
  
    Node flatten(Node root) 
    { 
        // Base Cases 
        if (root == null || root.right == null) 
            return root; 
  
        // recur for list on right 
        root.right = flatten(root.right); 
  
        // now merge 
        root = merge(root, root.right); 
  
        // return the root 
        // it will be in turn merged with its left 
        return root; 
    } 