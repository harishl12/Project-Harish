package collections;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {
	private int v;
	private LinkedList<Integer>[] adj;

	public DFSGraph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void DFS(int s) {
		boolean[] visited = new boolean[v];
		DFSUtil(s, visited);
	}

	void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");

		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}

	}

	public static void main(String[] args) {
		DFSGraph g = new DFSGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.DFS(2);
	}
}
