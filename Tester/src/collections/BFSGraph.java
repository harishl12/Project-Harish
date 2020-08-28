package collections;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSGraph {
	private int v;
	private LinkedList<Integer>[] adj;

	public BFSGraph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BFS(int s) {
		boolean[] visited = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

//	void DFS(int v) {
//		boolean[] visited = new boolean[v];
//		DFSUtil(v, visited);
//	}
//
//	void DFSUtil(int v, boolean[] visited) {
//		System.out.print(v + " ");
//		visited[v] = true;
//
//		Iterator<Integer> i = adj[v].listIterator();
//		while (i.hasNext()) {
//			int n = i.next();
//			if (!visited[n])
//				DFSUtil(n, visited);
//		}
//
//	}

	public static void main(String[] args) {
		BFSGraph g = new BFSGraph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		g.BFS(2);

	}
}
