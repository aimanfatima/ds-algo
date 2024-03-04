package graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class AF_PerfectFriends {
    public static class Edge {
        int vertex;
        int neighbour;

        Edge(int vertex, int neighbour) {
            this.vertex = vertex;
            this.neighbour = neighbour;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<k; i++) {
            int src = scanner.nextInt();
            int nbr = scanner.nextInt();

            graph.get(src).add(new Edge(src, nbr));
            graph.get(nbr).add(new Edge(nbr, src));
        }
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                getConnectedComponents(graph, i, visited, comp);
                connectedComponents.add(comp);
            }
        }

        int pairs = 0;
        for (int i=0; i< connectedComponents.size(); i++) {
            for (int j=i+1; j<connectedComponents.size(); j++) {
                pairs += connectedComponents.get(i).size() * connectedComponents.get(j).size();
            }
        }
        System.out.println(pairs);
    }

    private static void getConnectedComponents(ArrayList<ArrayList<Edge>> graph, int src, boolean[] visited, ArrayList<Integer> comp) {
        visited[src] = true;
        comp.add(src);
        for (Edge edge : graph.get(src)) {
            if (!visited[edge.neighbour]) {
                getConnectedComponents(graph, edge.neighbour, visited, comp);
            }
        }
    }
}
