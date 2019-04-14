=========
= Trees =
=========



// LCA

Node findLCA(Node node, int n1, int n2) 
    { 
        // Base case 
        if (node == null) 
            return null; 
  
        // If either n1 or n2 matches with root's key, report 
        // the presence by returning root (Note that if a key is 
        // ancestor of other, then the ancestor key becomes LCA 
        if (node.data == n1 || node.data == n2) 
            return node; 
  
        // Look for keys in left and right subtrees 
        Node left_lca = findLCA(node.left, n1, n2); 
        Node right_lca = findLCA(node.right, n1, n2); 
  
        // If both of the above calls return Non-NULL, then one key 
        // is present in once subtree and other is present in other, 
        // So this node is the LCA 
        if (left_lca!=null && right_lca!=null) 
            return node; 
  
        // Otherwise check if left subtree or right subtree is LCA 
        return (left_lca != null) ? left_lca : right_lca; 
    }


// BInary tree to Linked List

// Sol 1

// A simple recursive function to convert a given 
    // Binary tree to Doubly Linked List 
    void BToDLL(Node root)  
    { 
        // Base cases 
        if (root == null) 
            return; 
  
        // Recursively convert right subtree 
        BToDLL(root.right); 
  
        // insert root into DLL 
        root.right = head; 
  
        // Change left pointer of previous head 
        if (head != null) 
            (head).left = root; 
  
        // Change head of Doubly linked list 
        head = root; 
  
        // Recursively convert left subtree 
        BToDLL(root.left); 
    }




// Sol 2


// A simple recursive function to convert a given Binary tree  
    // to Doubly Linked List 
    // root --> Root of Binary Tree 
    void BinaryTree2DoubleLinkedList(Node root)  
    { 
        // Base case 
        if (root == null) 
            return; 
   
        // Recursively convert left subtree 
        BinaryTree2DoubleLinkedList(root.left); 
   
        // Now convert this node 
        if (prev == null)  
            head = root; 
        else
        { 
            root.left = prev; 
            prev.right = root; 
        } 
        prev = root; 
   
        // Finally convert right subtree 
        BinaryTree2DoubleLinkedList(root.right); 
    }




// Print all nodes at distance k from a given node


void printkdistanceNodeDown(Node node, int k)  
    { 
        // Base Case 
        if (node == null || k < 0) 
            return; 
   
        // If we reach a k distant node, print it 
        if (k == 0)  
        { 
            System.out.print(node.data); 
            System.out.println(""); 
            return; 
        } 
   
        // Recur for left and right subtrees 
        printkdistanceNodeDown(node.left, k - 1); 
        printkdistanceNodeDown(node.right, k - 1); 
    } 
   
    // Prints all nodes at distance k from a given target node. 
    // The k distant nodes may be upward or downward.This function 
    // Returns distance of root from target node, it returns -1 
    // if target node is not present in tree rooted with root. 
    int printkdistanceNode(Node node, Node target, int k)  
    { 
        // Base Case 1: If tree is empty, return -1 
        if (node == null) 
            return -1; 
   
        // If target is same as root.  Use the downward function 
        // to print all nodes at distance k in subtree rooted with 
        // target or root 
        if (node == target)  
        { 
            printkdistanceNodeDown(node, k); 
            return 0; 
        } 
   
        // Recur for left subtree 
        int dl = printkdistanceNode(node.left, target, k); 
   
        // Check if target node was found in left subtree 
        if (dl != -1)  
        { 
               
            // If root is at distance k from target, print root 
            // Note that dl is Distance of root's left child from  
            // target 
            if (dl + 1 == k)  
            { 
                System.out.print(node.data); 
                System.out.println(""); 
            } 
               
            // Else go to right subtree and print all k-dl-2 distant nodes 
            // Note that the right child is 2 edges away from left child 
            else
                printkdistanceNodeDown(node.right, k - dl - 2); 
   
            // Add 1 to the distance and return value for parent calls 
            return 1 + dl; 
        } 
   
        // MIRROR OF ABOVE CODE FOR RIGHT SUBTREE 
        // Note that we reach here only when node was not found in left  
        // subtree 
        int dr = printkdistanceNode(node.right, target, k); 
        if (dr != -1)  
        { 
            if (dr + 1 == k)  
            { 
                System.out.print(node.data); 
                System.out.println(""); 
            }  
            else 
                printkdistanceNodeDown(node.left, k - dr - 2); 
            return 1 + dr; 
        } 
   
        // If target was neither present in left nor in right subtree 
        return -1; 
    } 


// Vertical Order


    // Utility function to store vertical order in map 'm' 
    // 'hd' is horizontal distance of current node from root. 
    // 'hd' is initially passed as 0 
    static void getVerticalOrder(Node root, int hd, 
                                TreeMap<Integer,Vector<Integer>> m) 
    { 
        // Base case 
        if(root == null) 
            return; 
          
        //get the vector list at 'hd' 
        Vector<Integer> get =  m.get(hd); 
          
        // Store current node in map 'm' 
        if(get == null) 
        { 
            get = new Vector<>(); 
            get.add(root.key); 
        } 
        else
            get.add(root.key); 
          
        m.put(hd, get); 
          
        // Store nodes in left subtree 
        getVerticalOrder(root.left, hd-1, m); 
          
        // Store nodes in right subtree 
        getVerticalOrder(root.right, hd+1, m); 
    } 
      
    // The main function to print vertical oder of a binary tree 
    // with given root 
    static void printVerticalOrder(Node root) 
    { 
        // Create a map and store vertical oder in map using 
        // function getVerticalOrder() 
        TreeMap<Integer,Vector<Integer>> m = new TreeMap<>(); 
        int hd =0; 
        getVerticalOrder(root,hd,m); 
          
        // Traverse the map and print nodes at every horigontal 
        // distance (hd) 
        for (Entry<Integer, Vector<Integer>> entry : m.entrySet()) 
        { 
            System.out.println(entry.getValue()); 
        } 
    } 


// BST search 

bool iterativeSearch(Node root, int key) 
{ 
    // Traverse untill root reaches to dead end 
    while (root != null) 
    { 
        // pass right subtree as new tree 
        if (key > root.data) 
            root = root.ight; 
  
        // pass left subtree as new tree 
        else if (key < root.data) 
            root = root.left; 
        else
            return true;// if the key is found return 1 
    } 
    return false; 
}


// Bottom View

// Method that prints the bottom view. 
    public void bottomView() 
    { 
        if (root == null) 
            return; 
  
        // Initialize a variable 'hd' with 0 for the root element. 
        int hd = 0; 
  
        // TreeMap which stores key value pair sorted on key value 
        Map<Integer, Integer> map = new TreeMap<>(); 
  
         // Queue to store tree nodes in level order traversal 
        Queue<Node> queue = new LinkedList<Node>(); 
  
        // Assign initialized horizontal distance value to root 
        // node and add it to the queue. 
        root.hd = hd; 
        queue.add(root); 
  
        // Loop until the queue is empty (standard level order loop) 
        while (!queue.isEmpty()) 
        { 
            Node temp = queue.remove(); 
  
            // Extract the horizontal distance value from the 
            // dequeued tree node. 
            hd = temp.hd; 
  
            // Put the dequeued tree node to TreeMap having key 
            // as horizontal distance. Every time we find a node 
            // having same horizontal distance we need to replace 
            // the data in the map. 
            map.put(hd, temp.data); 
  
            // If the dequeued node has a left child add it to the 
            // queue with a horizontal distance hd-1. 
            if (temp.left != null) 
            { 
                temp.left.hd = hd-1; 
                queue.add(temp.left); 
            } 
            // If the dequeued node has a left child add it to the 
            // queue with a horizontal distance hd+1. 
            if (temp.right != null) 
            { 
                temp.right.hd = hd+1; 
                queue.add(temp.right); 
            } 
        } 
  
        // Extract the entries of map into a set to traverse 
        // an iterator over that. 
        Set<Entry<Integer, Integer>> set = map.entrySet(); 
  
        // Make an iterator 
        Iterator<Entry<Integer, Integer>> iterator = set.iterator(); 
  
        // Traverse the map elements using the iterator. 
        while (iterator.hasNext()) 
        { 
            Map.Entry<Integer, Integer> me = iterator.next(); 
            System.out.print(me.getValue()+" "); 
        } 
    } 




// Right View

// Sol 1

    // Recursive function to print right view of a binary tree. 
    void rightViewUtil(Node node, int level, int max_level) { 
  
        // Base Case 
        if (node == null)  
            return; 
  
        // If this is the last Node of its level 
        if (max_level < level) { 
            System.out.print(node.data + " "); 
            max_level = level; 
        } 
  
        // Recur for right subtree first, then left subtree 
        rightViewUtil(node.right, level + 1, max_level); 
        rightViewUtil(node.left, level + 1, max_level); 
    } 
  
    void rightView() 
    { 
        rightView(root); 
    } 
  
    // A wrapper over rightViewUtil() 
    void rightView(Node node) { 
  
        rightViewUtil(node, 1, max); 
    } 


// Sol 2


    // function to print right view of binary tree 
    private static void printRightView(Node root)  
    { 
        if (root == null) 
            return; 
              
        Queue<Node> queue = new LinkedList<>(); 
        queue.add(root); 
          
        while (!queue.isEmpty())  
        {    
            // number of nodes at current level 
            int n = queue.size(); 
              
            // Traverse all nodes of current level  
            for (int i = 1; i <= n; i++) { 
                Node temp = queue.poll(); 
                  
                // Print the right most element at  
                // the level 
                if (i == n) 
                    System.out.print(temp.data + " "); 
                  
                // Add left node to queue 
                if (temp.left != null) 
                    queue.add(temp.left); 
                      
                // Add right node to queue 
                if (temp.right != null) 
                    queue.add(temp.right); 
            } 
        } 
    } 



// Left View


    static int  max_level = 0; 
  
    // recursive function to print left view 
    void leftViewUtil(Node node, int level) 
    { 
        // Base Case 
        if (node==null) return; 
  
        // If this is the first node of its level 
        if (max_level < level) 
        { 
            System.out.print(" " + node.data); 
            max_level = level; 
        } 
  
        // Recur for left and right subtrees 
        leftViewUtil(node.left, level+1); 
        leftViewUtil(node.right, level+1); 
    } 
  
    // A wrapper over leftViewUtil() 
    void leftView() 
    { 
        leftViewUtil(root, 1); 
    } 


// Top View

// Sol 1

static class Pair { 
    Node first; 
    int second; 
    Pair(Node n,int a) 
    { 
        first=n; 
        second=a; 
    } 
}; 
  
// function to create a new node 
static Node newNode(int key) 
{ 
    Node node = new Node(); 
    node.left = node.right = null; 
    node.data = key; 
    return node; 
} 
  
// function should print the topView of 
// the binary tree 
static void topView( Node root) 
{ 
    // Base case 
    if (root == null) { 
        return; 
    } 
  
    // Take a temporary node 
    Node temp = null; 
  
    // Queue to do BFS 
    Queue<Pair > q =  new LinkedList<Pair>(); 
  
    // map to store node at each vartical distance 
    Map<Integer, Integer> mp = new HashMap<Integer, Integer>(); 
  
    q.add(new Pair( root, 0 )); 
  
    // BFS 
    while (q.size()>0) { 
  
        temp = q.peek().first; 
        int d = q.peek().second; 
        q.remove(); 
  
        // If any node is not at that vertical distance 
        // just insert that node in map and print it 
        if (mp.get(d) == null) { 
            System.out.print( temp.data + " "); 
            mp.put(d, temp.data); 
        } 
  
        // Continue for left node 
        if (temp.left!=null) { 
            q.add(new Pair( temp.left, d - 1 )); 
        } 
  
        // Continue for right node 
        if (temp.right!=null) { 
            q.add(new Pair( temp.right, d + 1 )); 
        } 
    } 
} 




// Sol 2

    private void TopView(Node root) { 
        class QueueObj { 
            Node node; 
            int hd; 
  
            QueueObj(Node node, int hd) { 
                this.node = node; 
                this.hd = hd; 
            } 
        } 
        Queue<QueueObj> q = new LinkedList<QueueObj>(); 
        Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>(); 
  
        if (root == null) { 
            return; 
        } else { 
            q.add(new QueueObj(root, 0)); 
        } 
  
        System.out.println("The top view of the tree is : "); 
          
        // count function returns 1 if the container  
        // contains an element whose key is equivalent  
        // to hd, or returns zero otherwise. 
        while (!q.isEmpty()) { 
            QueueObj tmpNode = q.poll(); 
            if (!topViewMap.containsKey(tmpNode.hd)) { 
                topViewMap.put(tmpNode.hd, tmpNode.node); 
            } 
  
            if (tmpNode.node.left != null) { 
                q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1)); 
            } 
            if (tmpNode.node.right != null) { 
                q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1)); 
            } 
  
        } 
        for (Entry<Integer, Node> entry : topViewMap.entrySet()) { 
            System.out.print(entry.getValue().data); 
        } 
    } 


// Construct 

static int preIndex = 0; 
  
    /* Recursive function to construct binary of size len from 
       Inorder traversal in[] and Preorder traversal pre[]. 
       Initial values of inStrt and inEnd should be 0 and len -1.   
       The function doesn't do any error checking for cases where  
       inorder and preorder do not form a tree */
    Node buildTree(char in[], char pre[], int inStrt, int inEnd) 
    { 
        if (inStrt > inEnd) 
            return null; 
  
        /* Pick current node from Preorder traversal using preIndex 
           and increment preIndex */
        Node tNode = new Node(pre[preIndex++]); 
  
        /* If this node has no children then return */
        if (inStrt == inEnd) 
            return tNode; 
  
        /* Else find the index of this node in Inorder traversal */
        int inIndex = search(in, inStrt, inEnd, tNode.data); 
  
        /* Using index in Inorder traversal, construct left and 
           right subtress */
        tNode.left = buildTree(in, pre, inStrt, inIndex - 1); 
        tNode.right = buildTree(in, pre, inIndex + 1, inEnd); 
  
        return tNode; 
    } 
  
    /* UTILITY FUNCTIONS */
  
    /* Function to find index of value in arr[start...end] 
     The function assumes that value is present in in[] */
    int search(char arr[], int strt, int end, char value) 
    { 
        int i; 
        for (i = strt; i <= end; i++) { 
            if (arr[i] == value) 
                return i; 
        } 
        return i; 
    } 
  