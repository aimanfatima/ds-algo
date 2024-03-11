package graphs;

import java.util.Stack;

public class AR_TopologicalSort {
    public static void main(String[] args) {
        int n = 7;

        int[][] graph = {
                {1, 3},
                {2},
                {3},
                {},
                {3, 5, 6},
                {6},
                {}
        };

        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                topologicalSort(graph, i, st, visited);
            }
        }

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }

    private static void topologicalSort(int[][] graph, int i, Stack<Integer> st, boolean[] visited) {
        visited[i] = true;

        for(int nbr: graph[i]) {
            if (!visited[nbr]) {
                topologicalSort(graph, nbr, st, visited);
            }
        }
        st.push(i);
    }
}
