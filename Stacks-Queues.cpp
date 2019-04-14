//STACKS

//push( x ): Insert element x at the top of a stack
void push (int stack[ ] , int x , int n) {
 if ( top == n-1 ) {            
    cout << “Stack is full.Overflow condition!” ;
    }
    else{
        top = top +1 ;           
        stack[ top ] = x ;  
    }
}

//pop( ): Removes an element from the top of a stack
   void pop (int stack[ ] ,int n ) 
    {

        if( isEmpty ( ) )
        {
            cout << “Stack is empty. Underflow condition! ” << endl ;
        }
        else    
        {
             top = top - 1 ;           
        }
    }

//topElement ( ): Access the top element of a stack
 int topElement ( )
    {
        return stack[ top ];
    }

//isEmpty ( ) : Check whether a stack is empty
    bool isEmpty ( )
    {
        if ( top == -1 ) 
        return true ; 
        else
        return false;
    }

//size ( ): Determines the current size of a stack
   int size ( )
    {
        return top + 1;
    }


//QUEUES

//Enqueue

void enqueue(int queue[], int element, int& rear, int arraySize) {
    if(rear == arraySize)            // Queue is full
            printf(“OverFlow\n”);
    else{
         queue[rear] = element;    // Add the element to the back
         rear++;
    }
}

//Dequeue

void dequeue(int queue[], int& front, int rear) {
    if(front == rear)            // Queue is empty
        printf(“UnderFlow\n”);
    else {
        queue[front] = 0;        // Delete the front element
        front++;
    }
}

//Front

int Front(int queue[], int front) {
    return queue[front];
}

//Size

int size(int front, int rear) {
    return (rear - front);
}

//IsEmpty

bool isEmpty(int front, int rear) {
    return (front == rear);
}    
