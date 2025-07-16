package DSA_PRBLMS;

import java.util.*;
//stack
public class DFS {
	public static void dfs(int node,boolean[] visited,ArrayList<ArrayList<graph.Edge>> graph) {
		visited[node]=true;
		System.out.print(node+" ");
		for(graph.Edge edge : graph.get(node)) {
			if(!visited[edge.to])
				dfs(edge.to,visited,graph);
		}
	}	
	
public static void main(String[] args) {
			graph g=new graph(18);
			g.addEdge(0, 1, 1);
		    g.addEdge(0, 2, 4);
		    g.addEdge(0, 3, 5);

		    g.addEdge(1, 0, 1);
		    g.addEdge(1, 4, 2);
		    g.addEdge(1, 5, 3);

		    g.addEdge(2, 0, 4);
		    g.addEdge(2, 6, 1);

		    g.addEdge(3, 0, 5);
		    g.addEdge(3, 7, 2);

		    g.addEdge(4, 1, 2);
		    g.addEdge(4, 8, 3);

		    g.addEdge(5, 1, 3);
		    g.addEdge(5, 9, 6);

		    g.addEdge(6, 2, 1);
		    g.addEdge(6, 9, 2);

		    g.addEdge(7, 3, 2);
		    g.addEdge(7, 9, 5);

				boolean visited[]= new boolean[18];
				dfs(0,visited,g.graph);	        
	}
}
