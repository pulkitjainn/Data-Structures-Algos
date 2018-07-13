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