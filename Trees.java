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
void bfs(Node node){
  Queue<Node> queue = new LinkedList<Node>();
  queue.add(node);
  while(!queue.isEmpty()){
    Node temp = queue.poll();  // poll() removws the presnet head 
    System.out.print(temp.data+" ");
    if(temp.left!=null){
      queue.add(temp.left);
    }
    if(temp.right!=null){
      queue.add(temp.right);
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
//Reverse Level Order Traversal (Function Problem)
void reversePrint(Node node){
  Node temp = node;
  Queue<Node> queue = new LinkedList<Node>();
  Stack<Node> s = new Stack<Node>();
  queue.add(temp);
  while(!queue.isEmpty()){
    temp = queue.peek();
    queue.remove();
    s.push(temp);
    if(temp.right!=null){ //NOTE : here right childs are added first
      queue.add(temp.right);
    }
    if(temp.left!=null){
      queue.add(temp.left);
    }
  }
  while(!s.isEmpty()){
    System.out.print(s.pop().data+ " ");
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