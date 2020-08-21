package edu.amrita.cb.cen.mtech2019.sads;

public class Graph {

	int [][]graph;
	int V;
	
	public Graph(int [][]g) {
		graph = g;
		V = g.length;
	}
	
	public int minV(int[]cost, boolean []proc ) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;		
		
		for (int i = 0; i<cost.length; i++)
			if(min > cost[i] && !proc[i]) {
				min = cost[i];
				minIndex = i;
			}
		
		return minIndex;
	}
	
	public int[] dijkstras (int src) {
		int []dist = new int[V];
		boolean []spt = new boolean[V];
		
		for(int i=0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			spt[i] = false;
		}
		
		dist[src] = 0;
		
		
		for(int c=0; c<V-1; c++) {
			
			int u = minV(dist,spt);
			spt[u] = true;
			
			for(int v=0; v<V; v++)
				if(!spt[v] && 
						graph[u][v]!= 0 && 
							dist[v] > dist[u] + graph[u][v]) {
					dist[v] = dist[u]+graph[u][v];
				}
			
		}
		return dist;
	}
	
	public int[] prims() {
		int []key = new int[V];
		boolean []mst = new boolean[V];
		int parent[] = new int[V];
		
		for(int i=0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mst[i] = false;
		}
		
		key[0] = 0;
		parent[0] = -1;
		
		for(int c=0; c<V-1; c++) {
			
			int u = minV(key,mst);
			mst[u] = true;
			
			for(int v=0; v<V; v++)
				if(!mst[v] && 
						graph[u][v]!= 0 && 
							key[v] > graph[u][v]) {
					key[v] = graph[u][v];
					parent[v] = u;
				}	
		}
		return parent;
	}
	
	public void dfs(int root, boolean []visited) {
		for(int i = 0; i<V; i++) {
			if(!visited[i] && graph[root][i] !=0) {
				visited[i] = true;
				dfs(i,visited);
			}
		}
		System.out.println(root+" vertex visited");				
	}
	
	public void bfs(int root) throws Exception {
		Queue qu = new QueueArray(11);
		boolean []v = new boolean[V];
		for(int i = 0; i<v.length; i++) v[i] = false;
		
		qu.enqueue(root);
		v[root] = true;
		
		while (!qu.isEmpty()) {
			root = qu.dequeue();

			for(int i=0; i< V; i++)
				if(!v[i] && graph[root][i] !=0 ) {
					qu.enqueue(i);
					v[i] = true;
				}
			System.out.println(root+" vertex visited");	
			
		}
	}
	
	public void dfs_nr(int root) throws Exception {
		Stack s = new StackList();
		boolean []v = new boolean[V];
		for(int i = 0; i<v.length; i++) v[i] = false;
		
		s.push(root);
		v[root] = true;
		
		while (!s.isEmpty()) {
			for(int i=0; i< V; i++)
				if(!v[i] && graph[root][i] !=0 ) {
					s.push(i);
					v[i] = true;
					//break;
				}
			root = s.pop();
			System.out.println(root+" vertex visited");	
		}
	}
	public static void main(String [] args) throws Exception {
		
		int graph[][] = {
			{0, 4, 0, 0, 0, 0, 0, 8, 0}, 
            {4, 0, 8, 0, 0, 0, 0, 11, 0}, 
            {0, 8, 0, 7, 0, 4, 0, 0, 2}, 
            {0, 0, 7, 0, 9, 14, 0, 0, 0}, 
            {0, 0, 0, 9, 0, 10, 0, 0, 0}, 
            {0, 0, 4, 14, 10, 0, 2, 0, 0}, 
            {0, 0, 0, 0, 0, 2, 0, 1, 6}, 
            {8, 11, 0, 0, 0, 0, 1, 0, 7}, 
            {0, 0, 2, 0, 0, 0, 6, 7, 0} 
           }; 	
		
		
			int [][]graph1 = {
					{0, 3,10, 0, 0, 0, 0, 6},
					{3, 0, 7, 0, 0, 0, 0, 0},
					{10,7, 0, 2, 0, 0, 0, 0},
					{0, 0, 2, 0, 5, 0, 5, 9},
					{0, 0, 0, 5, 0, 3, 6, 0},
					{0, 0, 0, 0, 3, 0, 0,12},
					{0, 0, 0, 5, 6, 0, 0, 7},
					{6, 0, 0, 9, 0,12, 7, 0},
					
			};
			
			Graph d = new Graph(graph);
			int[]dist = d.dijkstras(8);
			
			for (int i= 0 ; i< dist.length; i++ ) 
				System.out.println(dist[i]);
			
			int []parent = d.prims();
			
			for (int i= 0 ; i< parent.length; i++ ) 
				System.out.println(parent[i]+"---"+i);
			/*
			boolean[] v = new boolean[graph.length];
			for(int i = 0; i<v.length; i++) v[i] = false;
			v[0] = true;
			d.dfs(0,v);
			System.out.println("***********");
			//d.dfs_nr(0);
			d.bfs(0);*/
	}	
}
