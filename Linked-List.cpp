//Linked-List
//Printing elemets of LinkedList
void Print(Node *head)
{
    while(head != NULL ){
    cout<<head->data<<endl;
    head = head->next;
    }
}

//Insert at last
Node* Insert(Node *head,int data)
{
    struct Node* new_node = (struct Node*) malloc(sizeof(struct Node));
    struct Node *last = head; 
    new_node->data  = data;
    new_node->next = NULL;
    if (head == NULL)
    {
       head = new_node;
        return head;
    }  
    while (last->next != NULL)
        last = last->next;
    last->next = new_node;
    return head;
}

//Insert at start
Node* Insert(Node *head,int data)
{
    struct Node* new_node = (struct Node*) malloc(sizeof(struct Node));
    new_node->data=data;
    new_node->next=NULL;
    if(head == NULL){
        head=new_node;
        return head;
    }
    
    new_node->next = head;
    head = new_node;
    return head;
}
//Insert at given postion 
Node* InsertNth(Node *head, int data, int position)
{
    struct Node* new_node = (struct Node*) malloc(sizeof(struct Node));
    new_node -> data = data;
    new_node -> next=NULL;
    
    if(head == NULL){
        head=new_node;
        return head;
    }
    if(position == 0 ){
        new_node->next = head;
        head = new_node;
        return head;
    }
    
    struct Node* node = (struct Node*) malloc(sizeof(struct Node));
    struct Node* node1 = (struct Node*) malloc(sizeof(struct Node));
    node = head;
    node1= head;
    int p=0;
    for(node = head,p=0; node->next!=NULL && p != position;){
        node1=node;
        node=node->next;
        p++; 
    }
    
    new_node->next=node;
    node1->next=new_node;
    
    return head;
    
}
//Delete a node at given position
Node* Delete(Node *head, int position)
{
    if(position == 0){
        head=head->next;
        return head;
    }
    struct Node* node = (struct Node*) malloc(sizeof(struct Node));
    struct Node* node1 = (struct Node*) malloc(sizeof(struct Node));
    node = head;
    node1 = head;
    int p=0;    
    for(node = head,p=0; node->next!=NULL && p != position;){
        node1=node;
        node=node->next;
        p++; 
    }
    node1->next = node->next;
    return head;

}

//Reverse a linked List 
  void ReversePrint(Node *head)
    {
        struct Node* prev   = NULL;
        struct Node* current = head;
        struct Node* next;
        while(current != NULL){
            next=current->next;
            current->next=prev;
            prev = current;
            current = next;
        }
        head = prev;
            struct Node* node = (struct Node*) malloc(sizeof(struct Node));
            node = head;
        while(node != NULL){
            cout<<node->data<<endl;
            node=node->next;
        }
    }

//Compare linkedlist
int CompareLists(Node *headA, Node* headB)
{
    struct Node* nodeA = (struct Node*) malloc(sizeof(struct Node));
    struct Node* nodeB = (struct Node*) malloc(sizeof(struct Node));
    int ctr = 0;
    int chk = 0;
    int ans=0;
    int a=0,b=0;
    nodeA = headA;
    nodeB = headB;
    
    while(nodeA != NULL){
        a++;
        nodeA=nodeA->next;
    }
    
    while(nodeB != NULL){
        b++;
        nodeB=nodeB->next;
    }
    
    nodeA = headA;
    nodeB = headB;
    
    if(a==b)
    {
    while(nodeA != NULL && nodeB != NULL)
    {
        if(nodeA->data == nodeB->data)
        {
            ctr++;
        }
        chk++;
        
        nodeA=nodeA->next;
        nodeB=nodeB->next;
    }
     
    if(chk==ctr)
        ans = 1; 
    else
        ans = 0;
    }
    else
        ans=0;
    
    return ans;

}

// Merge two sorted lIsts
Node* MergeLists(Node *headA, Node* headB)
{
    struct Node* node = (struct Node*) malloc(sizeof(struct Node));
    struct Node* head = (struct Node*) malloc(sizeof(struct Node));

    struct Node* nodeA = (struct Node*) malloc(sizeof(struct Node));
    struct Node* nodeB = (struct Node*) malloc(sizeof(struct Node));
    int a=0,b=0;
    nodeA= headA;
    nodeB= headB;
    
    while(nodeA != NULL){
        a++;
        nodeA=nodeA->next;
    }
    
    while(nodeB != NULL){
        b++;
        nodeB=nodeB->next;
    }
    
    nodeA = headA;
    nodeB = headB;
    
    node->next=NULL;
    head = node;
    
    int d = 0;
    d = a + b ;
  
  //  d--;
    
    while(d){
        if(nodeA==NULL){
            node->next=nodeB;
            nodeB=nodeB->next;
            node=node->next;  
        }
        else if(nodeB==NULL){
          node->next=nodeA;
            nodeA=nodeA->next;
            node=node->next;  
        }
        
        else if(nodeA->data < nodeB->data)
        {
            node->next=nodeA;
            nodeA=nodeA->next;
            node=node->next;
        }
        else
        {
            node->next=nodeB;
            nodeB=nodeB->next;
            node=node->next;
        }    
        d--;
    }
    head=head->next;
    return head;
  
}   
//Get a node value at given position
int GetNode(Node *head,int positionFromTail)
{
    struct Node* node = (struct Node*) malloc(sizeof(struct Node));
    node = head;
    int count = -1;
    while(node!=NULL){
        count++;
        node=node->next;
    }
    int pos = count - positionFromTail;
    node = head;
    int p=0;
    for(node =head,p=0;node!=NULL && p!=pos;node=node->next,p++);
    return node->data;   
}
//Remove dublicate nodes from linkedlist

Node* RemoveDuplicates(Node *head)
{
    struct Node* node = (struct Node*) malloc(sizeof(struct Node));
    node = head;
    while(node->next!=NULL){
        if(node->next->data == node->data){
            node->next = node->next->next;
        }
        else{
            node=node->next;        
        }
    }    
     return head;                                       
}
//Check for cycle in linkedlist
bool has_cycle(Node* head) {
    struct Node* node = (struct Node*) malloc(sizeof(struct Node));    
    int a = 0;
    node = head;
    while(node!=NULL){
        a++;
        node=node->next;
        if(a>100){
            return true;//has cycle
        }
    }
    return false;//does not have cycle
}
//finding merge node
int FindMergeNode(Node *headA, Node *headB)
{
    struct Node* nodeA = (struct Node*) malloc(sizeof(struct Node));    
    struct Node* nodeB = (struct Node*) malloc(sizeof(struct Node));    

    nodeA = headA;
    nodeB = headB;
    int x=0;
    for(nodeA = headA;nodeA!=NULL;nodeA=nodeA->next){
        for(nodeB = headB;nodeB!=NULL;nodeB=nodeB->next){
                if(nodeA==nodeB){
                    return nodeA->data;
                }
        }    
    }
        return 0;      
} 
//Insert in a sorted doubly list
Node* SortedInsert(Node* head,int data)
{
    struct Node* node = (struct Node*) malloc(sizeof(struct Node));    
    node->data = data;
    
    if ( !head )
    {
        return node;
    }
    
    if ( data < head->data )
    {
        node->next = head;
        head->prev = node;
        return node;
    }
    
    struct Node* curr = (struct Node*) malloc(sizeof(struct Node));    
    struct Node* next = (struct Node*) malloc(sizeof(struct Node));    

    curr = NULL;
    next = head;
    while ( next && data >= next->data ) // exit when we hit the end or the next element is larger than data
    {
        curr = next;
        next = next->next;
    }
    
    node->next = curr->next;
    node->prev = curr;
    curr->next = node;
    
    if ( next )
    {
        next->prev = node;
    }
    
    return head;
}
//Insert in a sorted doubly list SOLUTION IS WRONG
Node* SortedInsert(Node *head,int data)
{
	    struct Node* node = (struct Node*) malloc(sizeof(struct Node));    
    node->data = data;
    node->next = NULL;
    node->prev = NULL;
    
    if(head==NULL){
        head = node;
    }
    else if(head->next==NULL)
    {
        head->next=node;
    }
    else
    {
    struct Node* node1 = (struct Node*) malloc(sizeof(struct Node)); 
    struct Node* node2 = (struct Node*) malloc(sizeof(struct Node));    
    
    node2 = head;
    node1 = head;
    
    for(node1 = head; node1->next!=NULL && node1->data >= node->data ;){
        node2=node1;
        node1=node1->next; 
    }  
    
    node->next=node1;
    node2->next=node;
    node->prev=node2;
    node1->prev=node;
    }
        
    return head;
}
//Reverse doubly linked list

Node* Reverse(Node* head)
{
    //struct Node* node = (struct Node*) malloc(sizeof(struct Node));    
        struct Node* prev   = NULL;
        struct Node* current = head;
        struct Node* next;
        while(current != NULL){
            next=current->next;
            current->next=prev;
            current->prev=next; //MOST IMPORTANT LINE
            prev = current;
            current = next;
        }
        head = prev; 
        return head;
}