==========
= Graphs =
==========

// Basics

static class Graph 
    { 
        int V; 
        LinkedList<Integer> adjListArray[]; 
          
        // constructor  
        Graph(int V) 
        { 
            this.V = V; 
              
            // define the size of array as  
            // number of vertices 
            adjListArray = new LinkedList[V]; 
              
            // Create a new list for each vertex 
            // such that adjacent nodes can be stored 
            for(int i = 0; i < V ; i++){ 
                adjListArray[i] = new LinkedList<>(); 
            } 
        } 
    } 
      
    // Adds an edge to an undirected graph 
    static void addEdge(Graph graph, int src, int dest) 
    { 
        // Add an edge from src to dest.  
        graph.adjListArray[src].add(dest); 
          
        // Since graph is undirected, add an edge from dest 
        // to src also 
        graph.adjListArray[dest].add(src); 
    } 


// BFS


void BFS(int s) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[V]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    } 


// DFS

    
// A function used by DFS 
void DFSUtil(int v,boolean visited[]) 
    { 
        // Mark the current node as visited and print it 
        visited[v] = true; 
        System.out.print(v+" "); 
  
        // Recur for all the vertices adjacent to this vertex 
        Iterator<Integer> i = adj[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil(n, visited); 
        } 
    } 
  
    // The function to do DFS traversal. It uses recursive DFSUtil() 
    void DFS(int v) 
    { 
        // Mark all the vertices as not visited(set as 
        // false by default in java) 
        boolean visited[] = new boolean[V]; 
  
        // Call the recursive helper function to print DFS traversal 
        DFSUtil(v, visited); 
    } 


// Topological Sort

// A recursive function used by topologicalSort 
    void topologicalSortUtil(int v, boolean visited[], 
                             Stack stack) 
    { 
        // Mark the current node as visited. 
        visited[v] = true; 
        Integer i; 
  
        // Recur for all the vertices adjacent to this 
        // vertex 
        Iterator<Integer> it = adj[v].iterator(); 
        while (it.hasNext()) 
        { 
            i = it.next(); 
            if (!visited[i]) 
                topologicalSortUtil(i, visited, stack); 
        } 
  
        // Push current vertex to stack which stores result 
        stack.push(new Integer(v)); 
    } 
  
    // The function to do Topological Sort. It uses 
    // recursive topologicalSortUtil() 
    void topologicalSort() 
    { 
        Stack stack = new Stack(); 
  
        // Mark all the vertices as not visited 
        boolean visited[] = new boolean[V]; 
        for (int i = 0; i < V; i++) 
            visited[i] = false; 
  
        // Call the recursive helper function to store 
        // Topological Sort starting from all vertices 
        // one by one 
        for (int i = 0; i < V; i++) 
            if (visited[i] == false) 
                topologicalSortUtil(i, visited, stack); 
  
        // Print contents of stack 
        while (stack.empty()==false) 
            System.out.print(stack.pop() + " "); 
    } 


==================
= Shortest Paths =
==================

// Flyod Warshall 

// Shortest path btw all pair of vertices

void floydWarshall(int graph[][]) 
    { 
        int dist[][] = new int[V][V]; 
        int i, j, k; 
  
        /* Initialize the solution matrix same as input graph matrix. 
           Or we can say the initial values of shortest distances 
           are based on shortest paths considering no intermediate 
           vertex. */
        for (i = 0; i < V; i++) 
            for (j = 0; j < V; j++) 
                dist[i][j] = graph[i][j]; 
  
        /* Add all vertices one by one to the set of intermediate 
           vertices. 
          ---> Before start of an iteration, we have shortest 
               distances between all pairs of vertices such that 
               the shortest distances consider only the vertices in 
               set {0, 1, 2, .. k-1} as intermediate vertices. 
          ----> After the end of an iteration, vertex no. k is added 
                to the set of intermediate vertices and the set 
                becomes {0, 1, 2, .. k} */
        for (k = 0; k < V; k++) 
        { 
            // Pick all vertices as source one by one 
            for (i = 0; i < V; i++) 
            { 
                // Pick all vertices as destination for the 
                // above picked source 
                for (j = 0; j < V; j++) 
                { 
                    // If vertex k is on the shortest path from 
                    // i to j, then update the value of dist[i][j] 
                    if (dist[i][k] + dist[k][j] < dist[i][j]) 
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                } 
            } 
        } 
  
        // Print the shortest distance matrix 
        printSolution(dist); 
    } 



// Bellman–Ford Algorithm

// Shortest path from src to all vertices

/*
========
= Algo =
========

Input  : Graph and a source vertex src
Output : Shortest distance to all vertices from src. 
	     If there is a negative weight cycle, 
		 then shortest distances are not calculated, negative weight cycle is reported.


1) This step initializes distances from source to all vertices as infinite 
   and distance to source itself as 0. Create an array dist[] of size |V| with 
   all values as infinite except dist[src] where src is source vertex.

2) This step calculates shortest distances. Do following |V|-1 times where 
   |V| is the number of vertices in given graph.
	Do following for each edge u-v
		If dist[v] > dist[u] + weight of edge uv, then update dist[v]
			dist[v] = dist[u] + weight of edge uv


3) This step reports if there is a negative weight cycle in graph. 
   Do following for each edge u-v
		If dist[v] > dist[u] + weight of edge uv, 
			then “Graph contains negative weight cycle”

The idea of step 3 is, step 2 guarantees shortest distances 
if graph doesn’t contain negative weight cycle. If we iterate 
through all edges one more time and get a shorter path for any vertex, 
then there is a negative weight cycle
*/


// The main function that finds shortest distances from src 
    // to all other vertices using Bellman-Ford algorithm.  The 
    // function also detects negative weight cycle 
    void BellmanFord(Graph graph,int src) 
    { 
        int V = graph.V, E = graph.E; 
        int dist[] = new int[V]; 
  
        // Step 1: Initialize distances from src to all other 
        // vertices as INFINITE 
        for (int i=0; i<V; ++i) 
            dist[i] = Integer.MAX_VALUE; 
        dist[src] = 0; 
  
        // Step 2: Relax all edges |V| - 1 times. A simple 
        // shortest path from src to any other vertex can 
        // have at-most |V| - 1 edges 
        for (int i=1; i<V; ++i) 
        { 
            for (int j=0; j<E; ++j) 
            { 
                int u = graph.edge[j].src; 
                int v = graph.edge[j].dest; 
                int weight = graph.edge[j].weight; 
                if (dist[u]!=Integer.MAX_VALUE && 
                    dist[u]+weight<dist[v]) 
                    dist[v]=dist[u]+weight; 
            } 
        } 
  
        // Step 3: check for negative-weight cycles.  The above 
        // step guarantees shortest distances if graph doesn't 
        // contain negative weight cycle. If we get a shorter 
        //  path, then there is a cycle. 
        for (int j=0; j<E; ++j) 
        { 
            int u = graph.edge[j].src; 
            int v = graph.edge[j].dest; 
            int weight = graph.edge[j].weight; 
            if (dist[u] != Integer.MAX_VALUE && 
                dist[u]+weight < dist[v]) 
              System.out.println("Graph contains negative weight cycle"); 
        } 
        printArr(dist, V); 
    } 



// Dijkstra

/*

Given a graph and a source vertex in the graph, 
find shortest paths from source to all vertices in the given graph.



========
= Algo =
========
1) Create a set sptSet (shortest path tree set) that keeps track of vertices included 
	in shortest path tree, i.e., whose minimum distance from source is calculated and 
	inalized. Initially, this set is empty.
2) Assign a distance value to all vertices in the input graph. 
	Initialize all distance values as INFINITE. 
	Assign distance value as 0 for the source vertex so that it is picked first.
3) While sptSet doesn’t include all vertices
		a) Pick a vertex u which is not there in sptSet and has minimum distance value.
		b) Include u to sptSet.
		c) Update distance value of all adjacent vertices of u. 
			To update the distance values, iterate through all adjacent vertices. 
			For every adjacent vertex v, if sum of distance value of u (from source) and 
			weight of edge u-v, is less than the distance value of v, then update the distance value of v.
*/

// A utility function to find the vertex with minimum distance value, 
    // from the set of vertices not yet included in shortest path tree 
    static final int V=9; 
    int minDistance(int dist[], Boolean sptSet[]) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index=-1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) 
            { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    // Funtion that implements Dijkstra's single source shortest path 
    // algorithm for a graph represented using adjacency matrix 
    // representation 
    void dijkstra(int graph[][], int src) 
    { 
        int dist[] = new int[V]; // The output array. dist[i] will hold 
                                 // the shortest distance from src to i 
  
        // sptSet[i] will true if vertex i is included in shortest 
        // path tree or shortest distance from src to i is finalized 
        Boolean sptSet[] = new Boolean[V]; 
  
        // Initialize all distances as INFINITE and stpSet[] as false 
        for (int i = 0; i < V; i++) 
        { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
  
        // Distance of source vertex from itself is always 0 
        dist[src] = 0; 
  
        // Find shortest path for all vertices 
        for (int count = 0; count < V-1; count++) 
        { 
            // Pick the minimum distance vertex from the set of vertices 
            // not yet processed. u is always equal to src in first 
            // iteration. 
            int u = minDistance(dist, sptSet); 
  
            // Mark the picked vertex as processed 
            sptSet[u] = true; 
  
            // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int v = 0; v < V; v++) 
  
                // Update dist[v] only if is not in sptSet, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (!sptSet[v] && graph[u][v]!=0 && 
                        dist[u] != Integer.MAX_VALUE && 
                        dist[u]+graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 
  
        // print the constructed distance array 
        printSolution(dist, V); 
    } 


=========================
= Minimum Spanning Tree =
=========================


//	Prims

/*

========
= Algo =
========

1) Create a set mstSet that keeps track of vertices already included in MST.
2) Assign a key value to all vertices in the input graph. Initialize all key values
	as INFINITE. Assign key value as 0 for the first vertex so that it is picked first.
3) While mstSet doesn’t include all vertices
	a) Pick a vertex u which is not there in mstSet and has minimum key value.
	b) Include u to mstSet.
	c) Update key value of all adjacent vertices of u. To update the key values, 
		iterate through all adjacent vertices. For every adjacent vertex v, 
		if weight of edge u-v is less than the previous key value of v, 
		update the key value as weight of u-v
*/


// A utility function to print the  
// constructed MST stored in parent[] 
int printMST(int parent[], int n, int graph[V][V]) 
{ 
printf("Edge \tWeight\n"); 
for (int i = 1; i < V; i++) 
    printf("%d - %d \t%d \n", parent[i], i, graph[i][parent[i]]); 
} 
  
// Function to construct and print MST for  
// a graph represented using adjacency  
// matrix representation 
void primMST(int graph[V][V]) 
{ 
    // Array to store constructed MST 
    int parent[V];  
    // Key values used to pick minimum weight edge in cut 
    int key[V];  
    // To represent set of vertices not yet included in MST 
    bool mstSet[V];  
  
    // Initialize all keys as INFINITE 
    for (int i = 0; i < V; i++) 
        key[i] = INT_MAX, mstSet[i] = false; 
  
    // Always include first 1st vertex in MST. 
    // Make key 0 so that this vertex is picked as first vertex. 
    key[0] = 0;      
    parent[0] = -1; // First node is always root of MST  
  
    // The MST will have V vertices 
    for (int count = 0; count < V-1; count++) 
    { 
        // Pick the minimum key vertex from the  
        // set of vertices not yet included in MST 
        int u = minKey(key, mstSet); 
  
        // Add the picked vertex to the MST Set 
        mstSet[u] = true; 
  
        // Update key value and parent index of  
        // the adjacent vertices of the picked vertex.  
        // Consider only those vertices which are not  
        // yet included in MST 
        for (int v = 0; v < V; v++) 
  
        // graph[u][v] is non zero only for adjacent vertices of m 
        // mstSet[v] is false for vertices not yet included in MST 
        // Update the key only if graph[u][v] is smaller than key[v] 
        if (graph[u][v] && mstSet[v] == false && graph[u][v] < key[v]) 
            parent[v] = u, key[v] = graph[u][v]; 
    } 
  
    // print the constructed MST 
    printMST(parent, V, graph); 
} 


