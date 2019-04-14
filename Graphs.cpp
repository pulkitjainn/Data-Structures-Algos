//GRAPHS

//ADJ-MATRIX

	#include <iostream>
    using namespace std;

    bool A[10][10];

    void initialize()
    {
        for(int i = 0;i < 10;++i)
            for(int j = 0;j < 10;++j)
                A[i][j] = false;
    }

    int main()
    {
        int x, y, nodes, edges;
        initialize();       //Since there is no edge initially
        cin >> nodes;       //Number of nodes
        cin >> edges;       //Number of edges
        for(int i = 0;i < edges;++i)
        {
            cin >> x >> y;
            A[x][y] = true;     //Mark the edges from vertex x to vertex y
       }
      return 0;
    }

//ADJ-LIST
 
     #include<iostream >
     #include < vector >

    using namespace std;

    vector <int> adj[10];

    int main()
    {
        int x, y, nodes, edges;
        cin >> nodes;       //Number of nodes
        cin >> edges;       //Number of edges
        for(int i = 0;i < edges;++i)
        {
                cin >> x >> y;
            adj[x].push_back(y);        //Insert y in adjacency list of x
         }
    for(int i = 1;i <= nodes;++i)
    {   
        //METHOD 1    
    /*    cout << "Adjacency list of node " << i << ": ";
        for(int j = 0;j < adj[i].size();++j)
            {
            if(j == adj[i].size() - 1)
                    cout << adj[i][j] << endl;
            else
                cout << adj[i][j] << " --> ";
    		}
    
    */	
        //METHOD 2
        cout << endl << "Adjacency list of node " << i << ": ";
        for(int n : adj[i])
            {
                    cout<<n<<" ";
            }
        	
    }
    return 0;
    }

//BFS

void bfs(int src){
	queue <int> q;
	bool visited[1000];

	q.push(src);
	visited[src]=true;

	while(!q.empty()){
		int node = q.front();
		cout<<node<<" ";
		q.pop();
		for(int neighbour : adj[node]){
			if(!visited[neighbour]){
				q.push(neighbour);
				visited[neighbour]=true;
			}
		}
	}
}


//DFS 
bool visited[100]; // Make this GLOBAL, this wont be decleared in the function
void dfs(int src,bool visited[]){
	visited[src]=true;
	cout<<src<<" ";
	for (int i : adj[src])
	{
		if(visited[i]==false){
				dfs(i,visited);		
		}
	}
}

