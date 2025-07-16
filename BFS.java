package DSA_PRBLMS;

public class BFS {
	public static void bfs(int start,boolean visited[],graph g) {
		Queue q=new Queue(18);
		q.enqueue(start);
		visited[start]=true;
		while(q.size>0) {
			int node=q.dequeue();
			System.out.print(node+" ");
			for(graph.Edge edge : g.graph.get(node)) {
				if(!visited[edge.to])
				{
					visited[edge.to]=true;
					q.enqueue(edge.to);
				}
			}
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
	    boolean visited[]=new boolean[18];
	    bfs(0,visited,g);
	}
}
