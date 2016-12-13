package com.abbhasin.ds;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DFS {

	public static class Graph {
		public int V; // number of vertices
		public Map<Integer, List<Integer>> adjacencyList;
		public Integer[][] adjacencyMatrix;

		public Graph(int numberOfVertices) {
			this.V = numberOfVertices;
			adjacencyList = new HashMap<>();
			adjacencyMatrix = new Integer[numberOfVertices][numberOfVertices];
		}

		/**
		 * from u to v
		 * 
		 * @param u
		 * @param v
		 */
		public void addEdge(int u, int v, int weight) {
			if (adjacencyMatrix[u][v] == 0) { // new edge
				adjacencyMatrix[u][v] = weight;

				if (adjacencyList.get(u) == null) {
					List<Integer> l = new LinkedList<>();
					l.add(v);
					adjacencyList.put(u, l);
				} else {
					List<Integer> l = adjacencyList.get(u);
					l.add(v);
				}
			}
		}

		public void DFS() {
			boolean[] visited = new boolean[V];
			for (int i = 0; i < V; i++) {
				if (!visited[i]) {
					DFSUsingMatrix(i, visited);
				}
			}
		}

		private void DFSUsingMatrix(int vertex, boolean[] visited) {
			System.out.println(vertex);
			visited[vertex] = true;
			for (int j = 0; j < V; j++) {
				if (adjacencyMatrix[vertex][j] != 0) {
					if (visited[j])
						continue;

					DFSUsingMatrix(j, visited);
				}

			}
		}

		private void DFSUsingList(int vertex, boolean[] visited) {
			System.out.println(vertex);
			visited[vertex] = true;
			List<Integer> adjacencyListForVertex = adjacencyList.get(vertex);
			for (Integer i : adjacencyListForVertex) {
				if (visited[i])
					continue;
				DFSUsingList(i, visited);
			}
		}

	}

}
