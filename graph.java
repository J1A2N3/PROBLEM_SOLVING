package DSA_PRBLMS;
import java.util.*;
public class graph {
	    static class Edge {
	        int to, weight;
	        Edge(int to, int weight) {
	            this.to = to;
	            this.weight = weight;
	        }
	    }

	    int V;
	    ArrayList<ArrayList<Edge>> graph;

	    graph(int V) {
	        this.V = V;
	        graph = new ArrayList<>();
	        for (int i = 0; i < V; i++) {
	            graph.add(new ArrayList<>());
	        }
	    }

	    void addEdge(int from, int to, int weight) {
	        graph.get(from).add(new Edge(to, weight));
	    }

	    void printGraph() {
	        for (int i = 0; i < V; i++) {
	            System.out.print("Node " + i + " -> ");
	            for (Edge edge : graph.get(i)) {
	                System.out.print("(" + edge.to + ", " + edge.weight + ") ");
	            }
	            System.out.println();
	        }
	    }

	  /*  public static void main(String[] args) {
	        graph g = new graph(4);

	        g.addEdge(0, 1, 5);
	        g.addEdge(0, 2, 10);
	        g.addEdge(1, 2, 3);
	        g.addEdge(2, 3, 1);

	        g.printGraph(); } */
	}

