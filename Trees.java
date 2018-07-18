//TREES
/* Class containing left and right child of current
   node and key value*/
class Node
{
    int key;
    Node left, right;
 
    public Node(int item)
    {
        key = item;
        left = right = null;
    }
}
 
class BinaryTree
{
    Node root;
    BinaryTree(int key)
    {
        root = new Node(key);
    }
    BinaryTree()
    {
        root = null;
    }
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
 
        /*create root*/
        tree.root = new Node(1);
 
        /* following is the tree after above statement
 
              1
            /   \
          null  null     */
 
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
 
        /* 2 and 3 become left and right children of 1
               1
             /   \
            2      3
          /    \    /  \
        null null null null  */
 
 
        tree.root.left.left = new Node(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
    }
}


//Inorder Traversal

void printInorder(Node node){
	if(node==null){
		return;
	}
	printInorder(node.left);
	System.out.print(node.key+" ");
	printInorder(node.right);
}
void printInorder(){
    printInorder(root);   
}


//Preorder Traversal

void printPreorder(Node node){
	if(node==null){
		return;
	}
	System.out.print(node.key+" ");
	printPreorder(node.left);
	printPreorder(node.right);
}
void printPostorder(){
    printPostorder(root);  
}


//Postorder Traversal

void printPostorder(Node node){
	if(node==null){
		return;
	}
	printPostorder(node.left);
	printPostorder(node.right);
	System.out.print(node.key+" ");
}
void printPostorder(){     
	printPostorder(root);  
}


//Level Order--Breadth First Traversal

void printLevelOrder() 
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
 
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

//Level Order in seperate lines--Breadth First Traversal

void levelOrderLineByLine(Node root)
    {
        if(root == null)
            return;
        Queue<Node> q =new LinkedList<Node>();
        q.add(root);
        while(true)
        {

            int nodeCount = q.size();
            if(nodeCount == 0)
                break;
            
            while(nodeCount > 0)
            {
                Node node = q.peek();
                System.out.print(node.data + " ");
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.print("$ ");//as per the question of gfgs
        }
    }


//Inorder Tree Traversal without Recursion

void printInorderUsingStack(Node node){
    if(node==null){
        return;
    }
    Node curr = node;
    Stack<Node> s = new Stack<Node>();
    while(curr!=null){
        s.push(curr);
        curr=curr.left;
    }
    while(s.size()>0){
        curr = s.pop();
        System.out.print(curr.data+" ");
        if(curr.right!=null){
            curr = curr.right;
            while(curr!=null){
                s.push(curr);
                curr=curr.right;
            }
        }      
    }
}

//Construct Tree from given Inorder and Preorder traversals

static int preIndex = 0;
Node buildTree(char in[],char pre[],int inStrt, int inEnd){
	if(inStrt>inEnd){
		return null;
	}
	Node tNode = new Node(pre[preIndex++]);

	if(inStrt==inEnd){
		return tNode;
	}

	int inIndex = search(in,inStrt,inEnd,tNode.data);

	tNode.left = buildTree(in, pre, inStrt,inIndex-1);
	tNode.right = buildTree(in, pre, inIndex+1, inEnd);

	return tNode;
}


//Search method for the above

int search(char arr[], int strt, int end, char value) 
    {
        int i;
        for (i = strt; i <= end; i++) 
        {
            if (arr[i] == value)
                return i;
        }
        return i;
    }


//Construct a tree from Inorder and Level order traversals

Node constructTree(Node startNode, int[] levelOrder, int[] inOrder, int inStart, int inEnd) {
	if(inStart>inEnd){
		return;
	}

	if(inStart==inEnd){
		return new Node(levelOrder[inStart]);	
	}

	boolean found = false;
	int index = 0;

	for(int i =0;i<levelOrder.length -1;i++){
		int data = levelOrder[i];

		for(int j = inStart ; j < inEnd ; j++){
			if(in[j] == data){
				startNode = new Node(data);
				index = j;
				found = true;
				break;
			}
		}
		if(found == true){
			break;
		}
	}

	startNode.left = constructTree(startNode, levelOrder, inOrder, inStart, index - 1);
	startNode.right = constructTree(startNode, levelOrder, inOrder, index+1, inEnd);
}


//Construct Complete Binary Tree from its Linked List Representation

BinaryTreeNode convertList2Binary(BinaryTreeNode node){
	Queue<BinaryTreeNode> q = new Queue<BinaryTreeNode>();

	if(head==null){ //head is for linkedlist
		node = null; //node for binaeryTree
		return null;
	}

	node = new BinaryTreeNode(head.data);
	q.add(node);

	head=head.next;

	while(head!=null){
		BinaryTreeNode parent = q.peek();
		BinaryTreeNode pp = q.poll();

		BinaryTreeNode leftChild = null, rightChild = null;
		leftChild = new BinaryTreeNode(head.data);
		q.add(leftChild);
		head=head.next;
		if(head != null){
			rightChild = new BinaryTreeNode(head.data);
			q.add(rightChild);
			head= head.next;
		} 	
		parent.left = leftChild;
		parent.right = rightChild;
	}	
}


//Delete a tree

void DeleteTree(Node node){
	if(node == null){
		return;
	}

	DeleteTree(node.left);
	DeleteTree(node.right);

	System.out.println("Node Deleted :" + node.data);
	node = null;
}


//Max depth or height of a tree

int height(Node node){
	if(node == null){
		return 0;
	}
	int lDepth = height(node.left);
	int rDepth = height(node.right);

	if(lDepth>rDepth)
		return (lDepth+1);
	else
		return (rDepth+1);
}


//Check whether two trees are identical

boolean isIdentical(Node a, Node b){
	if(a==null && b==null){
		return true;
	}
	if(a!=null && b!=null){
		return (a.data==b.data && isIdentical(a.left, b.left) && isIdentical(a.right,b.right));
	}
	return false;
}


//Calculate the size

int size(Node node){
	if (node == null){
		return 0;
	}
	return (size(node.left) + 1 + size(node.right));
}



Dated : July 11

//level order traversal 

void levelOrder(Node node) 
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(temp.data+" ");
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
    }

Dated : July 14 

//Find sum of all left leaves in a given Binary Tree

public int leftLeafSum(Node node)
    {
        if(node == null){
            return 0;
        }
        int ans = 0;
        if(check(node.left)){
            ans = node.left.data;
        }
        return ans + leftLeafSum(node.left) + leftLeafSum(node.right);
    }
    public static boolean check(Node node){
        if(node==null){
            return false;
        }
        if(node.left==null && node.right == null){
            return true;
        }
        return false;
    }

//Find sum of all right leaves in a given Binary Tree

public int rightLeafSum(Node node)
    {
        if(node == null){
            return 0;
        }
        int ans = 0;
        if(check(node.right)){
            ans = node.right.data;
        }
        return ans + rightLeafSum(node.left) + rightLeafSum(node.right);
    }
    public static boolean check(Node node){
        if(node==null){
            return false;
        }
        if(node.left==null && node.right == null){
            return true;
        }
        return false;
    }

// Count number of leaf nodes

int countLeaves(Node node) 
    {
         if(node ==null){
             return 0;
         }
         int ans = 0;
         if(isLeaf(node)){
             ans++;
         }
         return ans + countLeaves(node.left) + countLeaves(node.right);
    }
    
    static boolean isLeaf(Node node){
        if(node==null){
            return false;
        }
        if(node.left==null && node.right==null){
            return true;
        }
        return false;
    }

//Count full nodes

    int countFullNodes(Node node) 
    {
         if(node ==null){
             return 0;
         }
         int ans = 0;
         if(isFull(node)){
             ans++;
         }
         return ans + countFullNodes(node.left) + countFullNodes(node.right);
    }
    
    static boolean isFull(Node node){
        if(node==null){
            return false;
        }
        if(node.left!=null && node.right!=null){
            return true;
        }
        return false;
    }

//Count number of nodes greater than x
public static int numNodeGreater(Node root,int x){
  if(root==null){
    return 0;
  }
  int ans =0;
  if(root.key>x){
    ans++;
  }

  return ans + numNodeGreater(root.left,x) + numNodeGreater(root.right,x);

    }


//Check if leaf order traversal is same or not

public static boolean leafTraversal(Node node1,Node node2){
  if(node1 == null || node2==null){
    return false;
  }
  ArrayList<Integer> arr1 = new ArrayList<Integer>();
  ArrayList<Integer> arr2 = new ArrayList<Integer>();

  getInorder(node1,arr1);
  getInorder(node2,arr2);

  if(arr1.size()!=arr2.size()){
    return false;
  }
  else{
    for(int i = 0;i<arr1.size();i++){
      if(arr1.get(i)!=arr2.get(i)){
        return false;
      }
    }
    return true;
  }
}

public static void getInorder(Node node,ArrayList<Integer> arr){
        if (node == null)
            return;
        getInorder(node.left,arr);

        if(isLeaf(node)){
          arr.add(node.key);
        }
        getInorder(node.right,arr);
    }
    
public static boolean isLeaf(Node node){
  if(node==null){
    return false;
  }
  if(node.left==null && node.right==null){
    return true;
  }
  return false;
}

//Check whether a given tree is perfect or not

public static boolean returnAns(Node node){
    if(nodeCount(node) == perfect(node,node,findDepth(node))){
        return true;
    }
    return false;
}

public static int nodeCount(Node node)
    {
        if (node == null)
            return 0;
        else
            return(nodeCount(node.left) + 1 + nodeCount(node.right));
    }
 
public static int getLevelUtil(Node node, int key, int level) {
        if (node == null)
            return 0;
  
        if (node.key == key)
            return level;
  
        int downlevel = getLevelUtil(node.left, key, level + 1);
        if (downlevel != 0)
            return downlevel;
  
        downlevel = getLevelUtil(node.right, key, level + 1);
        return downlevel;
    }
  
public static int getLevel(Node node, int key) {
        return getLevelUtil(node, key, 1);
    }

public static int findDepth(Node node){
  int d = 0;
    while (node != null)
    {
      d++;
      node = node.left;
  }
    return d;
}

public static boolean isLeaf(Node node){
  if(node==null){
    return false;
  }
  if(node.left==null && node.right==null){
    return true;
  }
  return false;
}

public static boolean isFull(Node node){
  if(node==null){
    return false;
  }
  if(node.left!=null && node.right!=null){
    return true;
  }
  return false;
}

public static int perfect(Node root, Node node, int dep){
    int ans = 0;
  if(node != null){
      if(isLeaf(node) && dep==getLevel(root,node.key)){
            ans++;
      }
        else if(isFull(node)){
            ans++;
        }
        else{
            ans = 0;
        }
        return ans + perfect(root,node.left,dep) + perfect(root,node.right,dep);
    }
  return ans;

}

//check if it is a full tree or not

  boolean isFullTree(Node node)
    {
        if(node ==null){
            return true;
        }
        if( (node.left==null && node.right==null) || (node.left!=null && node.right!=null)){
            return isFullTree(node.left) && isFullTree(node.right);
        }
        
        return false;
        
    }

//check for duplicate values in tree

static boolean check(Node root, HashSet<Integer> h){
        if(root ==null){
            return false;
        }
        if(h.contains(root.key)){
          return true;
        }else{
            h.add(root.key);
        }
        return check(root.left,h) || check(root.right,h);
    }

//Check whether two treees are Mirror or not
boolean areMirror(Node a, Node b) 
    {
        if (a == null && b == null)
            return true;
 
        if (a == null || b == null) 
            return false;

        return a.data == b.data
                && areMirror(a.left, b.right)
                && areMirror(a.right, b.left);
    }

Dated : July 15

//Print level of all nodes

    public static int getLevelUtil(Node node, int data, int level) {
        if (node == null)
            return 0;
        if (node.key == data)
            return level;
        int downlevel = getLevelUtil(node.left, data, level + 1);
        if (downlevel != 0)
            return downlevel;
        downlevel = getLevelUtil(node.right, data, level + 1);
        return downlevel;
    }
  
    public static int getLevel(Node node, int data,int i) {
        return getLevelUtil(node, data, i);
    }

public static void printAllNodesLevel(Node root,int i){
    if(root == null){
        return;
    }
    i++;
    System.out.println("Level of Node "+root.key+" is "+getLevel(root,root.key,i));
    printAllNodesLevel(root.left,i);
    printAllNodesLevel(root.right,i);
}

//Print all leaf nodes of a Binary Tree from left to right

public static void printLeafLeftToRight(Node node){
    if(node==null){
        return;
    }

    if(isLeaf(node)){
        System.out.println(node.key);
    }
    printLeafLeftToRight(node.left);
    printLeafLeftToRight(node.right);
}

public static boolean isLeaf(Node node){
    if(node == null){
        return false;
    }
    if(node.left==null && node.right==null){
        return true;
    }
    return false;
}

//Print Binary Tree levels in sorted order

public static void sortedLevelOrder(Node root)
    {
        if(root == null)
            return;
        TreeSet<Integer> ts = new TreeSet<Integer>();
        Queue<Node> q =new LinkedList<Node>();
        q.add(root);
        while(true)
        {
            int nodeCount = q.size();
            if(nodeCount == 0)
                break;   
            while(nodeCount > 0)
            {
                Node node = q.peek();
                ts.add(node.key);
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            System.out.println(ts);
            ts.clear();
        }
    }

//LeftView of a binary tree

int maxlevel =0;
    void leftView(Node root){
        View(root,1);
    }
    void View(Node node,int level){
        if(node == null){
            return;
        }
        if(maxlevel<level){
            System.out.print(node.data + " ");
            maxlevel=level;
        }
        View(node.left,level+1);
        View(node.right,level+1);
    }


//RightView of binary tree

//recursive
    int maxlevel=0;
    void rightView(TreeNode node) {
        View(node,1);
    }
    
    void View(TreeNode node,int level){
        if(node == null){
            return;
        }
        if(maxlevel<level){
            System.out.print(node.data + " ");
            maxlevel=level;
        }
        View(node.right,level+1);
        View(node.left,level+1);
    }

//iterative
    void rightView(TreeNode root) 
    {
        if (root == null)
            return;
             
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {   
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                TreeNode temp = queue.poll();
                if (i == 1)
                    System.out.print(temp.data + " ");
                if (temp.right != null)
                    queue.add(temp.right);
                if (temp.left != null)
                    queue.add(temp.left);
            }
        }
    }


//Print nodes at odd
void nodeAtOdd(Node root){
        if(root == null)
            return;
        Queue<Node> q =new LinkedList<Node>();
        q.add(root);
        int level=1;
        while(true)
        {
            int nodeCount = q.size();
            if(nodeCount == 0)
                break;
            while(nodeCount > 0)
            {
                Node node = q.peek();
                if(level%2!=0){
                    System.out.print(node.data + " ");
                }
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            level++;
        }
    }

Dated : July 16

//Print middle level of perfect binary tree without finding height

void printLevelBinaryTree(Node node){
    printIt(node,node);
}

void printIt(Node a,Node b){
    if(a==null && b==null){
        return;
    }
    if(b.left==null && b.right==null){
        System.out.print(a.key+" ");
        return;
    }
    printIt(a.left,a.left.left);
    printIt(a.right,a.right.right);
}

//Print nodes at k distance from root

//Iterative
void printKdistance(Node root, int k)
     {
        if(root == null)
            return;
        Queue<Node> q =new LinkedList<Node>();
        int level =0;
        q.add(root);
        while(true)
        {

            int nodeCount = q.size();
            if(nodeCount == 0)
                break;
            
            while(nodeCount > 0)
            {
                Node node = q.peek();
                if(level==k){
                    System.out.print(node.data + " ");
                }
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }   
             level++;
        }
         
     }

//Recursive
void printKDistant(Node node, int k) 
    {
        if (node == null)
            return;
        if (k == 0) 
        {
            System.out.print(node.data + " ");
            return;
        } 
        else
        {
            printKDistant(node.left, k - 1);
            printKDistant(node.right, k - 1);
        }
    }


Dated : July 17

//Print all nodes that don’t have sibling

void printSibling(Node root)
    {
        if(root == null)
            return;
        Queue<Node> q =new LinkedList<Node>();
        TreeSet<Integer> t = new TreeSet<Integer>();
        q.add(root);
        while(true)
        {

            int nodeCount = q.size();
            if(nodeCount == 0)
                break;
            
            while(nodeCount > 0)
            {
                Node node = q.peek();
                if(node.left!=null && node.right==null){
                    t.add(node.left.data);
                }
                if(node.left==null && node.right!=null){
                    t.add(node.right.data);
                }
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
        }
        if(t.isEmpty()){
            System.out.print(-1);
            return ;
        }
        Iterator<Integer> itr=t.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next() +" ");
        }
    }

// Check if all leaf nodes are at same level or not

boolean check(Node root){
        if(root == null)
            return true;
        Queue<Node> q =new LinkedList<Node>();
        int level=1,ans=-1;
        q.add(root);
        while(true)
        {
            int nodeCount = q.size();
            if(nodeCount == 0)
                break;
            while(nodeCount > 0)
            {
                Node node = q.peek();
                if(isLeaf(node)){
                    if(ans ==-1){
                        ans =level;
                    }
                    else{
                        if(ans!=level){
                            return false;
                        }
                    }
                }
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
            level++;
        }
        return true;
    }

//Print corner nodes at each level // Print leftmost and rightmost nodes of a Binary Tree

void printCorner(Node root) 
    {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {   
            int n = queue.size();
            for (int i = 1; i <= n; i++) {
                Node temp = queue.poll();
                if (i == 1 || i==n)
                    System.out.print(temp.key + " ");
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            }
        }
    }

//Given a binary tree, print all root-to-leaf paths

void printPaths(Node node) 
    {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }
    void printPathsRecur(Node node, int path[], int pathLen) 
    {
        if (node == null)
            return;
        path[pathLen] = node.data;
        pathLen++;
        if (node.left == null && node.right == null)
            printArray(path, pathLen);
        else
        {
            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.right, path, pathLen);
        }
    }
    void printArray(int ints[], int len) 
    {
        int i;
        for (i = 0; i < len; i++) 
        {
            System.out.print(ints[i] + " ");
        }
        System.out.println("");
    }

//Print nodes between two given level numbers of a binary tree

void printLevels(Node root, int low,int high)
     {
        if(root == null)
            return;
        Queue<Node> q =new LinkedList<Node>();
        int level =1;
        q.add(root);
        while(true)
        {

            int nodeCount = q.size();
            if(nodeCount == 0)
                break;
            
            while(nodeCount > 0)
            {
                Node node = q.peek();
                if(level>=low && level<=high){
                    System.out.print(node.data + " ");
                }
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }   
             level++;
        }
         
     }

//Nodes at Odd Levels
public void nodeAtOdd(Node root)
     {
        if(root == null)
            return;
        Queue<Node> q =new LinkedList<Node>();
        int level =1;
        q.add(root);
        while(true)
        {

            int nodeCount = q.size();
            if(nodeCount == 0)
                break;
            
            while(nodeCount > 0)
            {
                Node node = q.peek();
                if(level%2!=0){
                    System.out.print(node.data + " ");
                }
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }   
             level++;
        }
         
     }

//Check whether a binary tree is a full binary tree or not | Iterative Approach 

boolean isFullTree(Node root)
    {
        if(root == null)
            return false;
        Queue<Node> q =new LinkedList<Node>();
        q.add(root);
        while(true)
        {

            int nodeCount = q.size();
            if(nodeCount == 0)
                break;
            
            while(nodeCount > 0)
            {
                Node node = q.peek();
                if(!isLeaf(node) && !isFull(node)){
                    return false;
                }
                q.remove();
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                nodeCount--;
            }
        }
        return true;
    }
    
//Check if a given Binary Tree is SumTree

int isSumTree(Node node) 
    {
        int ls, rs;
  
        if ((node == null) || (node.left == null && node.right == null))
            return 1;
  
        ls = sum(node.left);
        rs = sum(node.right);
  
        if ((node.data == ls + rs) && (isSumTree(node.left) != 0)
                && (isSumTree(node.right)) != 0)
            return 1;
  
        return 0;
    }


//Print Postorder traversal from given Inorder and Preorder traversals

void printPostOrder(int in[], int pre[], int n)
{
   int root = search(in, pre[0], n);
    if (root != 0)
      printPostOrder(in, pre+1, root);
    if (root != n-1)
      printPostOrder(in+root+1, pre+root+1, n-root-1);
    cout << pre[0] << " ";
}

int search(int arr[], int x, int n)
{
    for (int i = 0; i < n; i++)
      if (arr[i] == x)
         return i;
    return -1;
}


//Populate Inorder Successor for all nodes

static Node next = null;

    void populateNext(Node node) 
    {
        if (node != null) 
        {
            populateNext(node.right);
            node.next = next;
            next = node;
            populateNext(node.left);
        }
    }

    //my method

class GFG
{
    public static void populateNext(Node root)
    {
        ArrayList<Node> arr = new ArrayList<Node>();
        storeInorder(root,arr);
        populateNextNode(root,arr);
    }
    static void storeInorder(Node node, ArrayList<Node> arr) {
        if (node == null) {
            return;
        }
        storeInorder(node.left, arr);
        arr.add(node);
        storeInorder(node.right, arr);
    }
    static int getIndex(ArrayList<Node> arr,Node x){
      int i =-1,ans=0;
      for(i=0;i<arr.size();i++){
        if(arr.get(i)==x){
          ans =  i;
        }
      }
      return ans;
    }
    public static void populateNextNode(Node node,ArrayList<Node> arr){
      if (node == null) {
            return;
        }
        populateNextNode(node.left, arr);
        int i = getIndex(arr,node);
        if(i < arr.size()-1){
            node.next = arr.get(i+1);
        }
        else if(i==arr.size()-1){
            node.next = null;
        }
        populateNextNode(node.right, arr);
    } 
}


//Replace each node in binary tree with the sum of its inorder predecessor and successor NOT TESTED

ArrayList<Integer> arr = new ArrayList<Integer>();
arr.add(0);
void printInorder(Node node,ArrayList<Integer> arr){
  if(node==null){
    return;
  }
  printInorder(node.left);
  arr.add(node.key);
  printInorder(node.right);
}
arr.add(0);


void myMainFunct(Node node, ArrayList<Integer> arr){
  if(node==null){
    return;
  }
  
  myMainFunct(node.left,arr);
  int j = getIndex(arr,node.key)
  node.key = arr.get(j-1) + arr.get(j+1);
  myMainFunct(node.right,arr);  
}


int getIndex(ArrayList<Integer> arr,int x){
  int i =-1;
  for(i=0;i<arr.size();i++){
    if(arr.get(i)==x){
      return i;
    }
  }
  return i;
}


Dated : July 18

//Find n-th node of inorder traversal     NOT TESTED

static int count = 0;
void NthInorder(Node node, int n)
{
    if (node == NULL)
        return;
    if (count <= n) {
        NthInorder(node.left, n);
        count++;
 
        if (count == n)
            System.out.print(node.data);
 
        NthInorder(node.right, n);
    }
}


//Find n-th node in Postorder traversal of a Binary Tree

static int count = 0;
void NthPostordernode(Node root, int N)
{
    if (root == NULL)
        return;
 
    if (count <= N) {
 
        NthPostordernode(root.left, N);
        NthPostordernode(root.right, N);
 
        count++;
        if (count == N)
            System.out.print(root.data);
    }
}


//ZigZag Level Order Traversal BT

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        if(A==null){
            return null;
        }
        Stack<TreeNode> current = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subans = new ArrayList<Integer>();
      
        current.push(A);
        boolean lefttoright = true;
        
        while(!current.isEmpty()){
            TreeNode temp = current.pop();
            subans.add(temp.val);
            
            if(lefttoright){
                if(temp.left!=null){
                    next.push(temp.left);
                }
                if(temp.right!=null){
                    next.push(temp.right);
                }
            }
            else{
                if(temp.right!=null){
                    next.push(temp.right);
                }
                if(temp.left!=null){
                    next.push(temp.left);
                }
            }
            if(current.isEmpty()){
                lefttoright=!lefttoright;
                
                Stack<TreeNode> tempo = current;
                current = next;
                next = tempo;
                ans.add(subans);
                subans = new ArrayList<Integer>();  
            }
        }
        return ans;
    }
}


//Level order traversal in spiral form

void printSpiral(Node node) 
    {
        if (node == null) 
            return;   
 
        Stack<Node> s1 = new Stack<Node>(); 
        Stack<Node> s2 = new Stack<Node>();
 
        s1.push(node);
 
        while (!s1.empty() || !s2.empty()) 
        {
            while (!s1.empty()) 
            {
                Node temp = s1.peek();
                s1.pop();
                System.out.print(temp.data + " ");
 
                if (temp.right != null) 
                    s2.push(temp.right);
                 
                if (temp.left != null) 
                    s2.push(temp.left);
                 
            }

            while (!s2.empty()) 
            {
                Node temp = s2.peek();
                s2.pop();
                System.out.print(temp.data + " ");
 
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }
    }

//Level Order Traversal Line by Line

static void levelOrder(Node root) {
    if (root == null)
      return;
 
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    q.add(null);

    while (!q.isEmpty()) 
    {
      Node curr = q.poll();
      if (curr == null) 
      {
        if (!q.isEmpty()) 
        {
          q.add(null);
          System.out.println();
        }
      } 
      else 
      {
        if (curr.left != null)
          q.add(curr.left);
 
        if (curr.right != null)
          q.add(curr.right);
 
        System.out.print(curr.data + " ");
      }
    }
  }

//Reverse Level Order Traversal

  void reverseLevelOrder(Node node) 
    {
        Stack<Node> S = new Stack();
        Queue<Node> Q = new LinkedList();
        Q.add(node);
        while (Q.isEmpty() == false) 
        {
            node = Q.peek();
            Q.remove();
            S.push(node);

            if (node.right != null)
                Q.add(node.right); 
                 
            if (node.left != null)
                Q.add(node.left);
        }
  
        while (S.empty() == false) 
        {
            node = S.peek();
            System.out.print(node.data + " ");
            S.pop();
        }
    }

//Dont remember which question is this



ArrayList<Integer> arr = new ArrayList<Integer>();
arr.add(0);
void printInorder(Node node,ArrayList<Integer> arr){
  if(node==null){
    return;
  }
  printInorder(node.left);
  arr.add(node.key);
  printInorder(node.right);
}
arr.add(0);


void myMainFunct(Node node, ArrayList<Integer> arr){
  if(node==null){
    return;
  }
  
  myMainFunct(node.left,arr);
  int j = getIndex(arr,node.key)
  node.key = arr.get(j-1) + arr.get(j+1);
  myMainFunct(node.right,arr);  
}


int getIndex(ArrayList<Integer> arr,int x){
  int i =-1;
  for(i=0;i<arr.size();i++){
    if(arr.get(i)==x){
      return i;
    }
  }
  return i;
}