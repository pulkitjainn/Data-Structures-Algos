Graphs

Dated : July 26

static class Graph
    {
        int V;
        LinkedList<Integer> adjListArray[]; 
        Graph(int V)
        {
            this.V = V;
            adjListArray = new LinkedList[V];
            for(int i = 0; i < V ; i++){
                adjListArray[i] = new LinkedList<>();
            }
        }
    }
     
    static void addEdge(Graph graph, int src, int dest)
    {
        graph.adjListArray[src].addFirst(dest);
        graph.adjListArray[dest].addFirst(src);
    }


//BFS 

void BFS(int s)
    {
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            s = queue.poll();
            System.out.print(s+" ");

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



//DFS

    void DFSUtil(int v,boolean visited[])
    {
        visited[v] = true;
        System.out.print(v+" ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
 
    void DFS(int v)
    {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }
 

 //PRIMS

