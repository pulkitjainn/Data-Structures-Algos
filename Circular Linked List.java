Circular Linked List

//Dated : June 27

//Traversal

void traverseCircList(Node node){
	if(node == null)
		return;
	Node first = node;	
	do{
		System.out.println(node.data);
		node = node.next;
	}while(node!=fisrt);
}

//Split a Circular Linked List into two halves

void SlpitIntoTwo(Node head){

	if(head == null){
		return;
	}
	Node temp = head;
	Node slow = head;
	Node fast = head;
	Node head1, head2;

	while(fast.next!=head || fast.next.next!=null){
		slow = slow.next;
		fast = fast.next.next;
	}

	if(fast.next.next == head){
		fast=fast.next;
	}

	head1 = head;

	if(head.next!=null){
		head2 = slow.next;
	}

	fast.next = slow.next;
	slow.next = head;
}

//Check if a linked list is Circular Linked List

boolean isCircular(Node head)
    {
        Node temp = head;
        do{
            if(temp==null){
                return false;
            }
            temp=temp.next;
        }while(temp!=head);
        return true;
    }

//Insertion and deletion in a circular linked list are similar ot that 
//of Songly linked list keeping in mind that "last.next=head"