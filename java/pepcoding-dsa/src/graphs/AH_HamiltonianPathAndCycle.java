package graphs;

public class AH_HamiltonianPathAndCycle {
    public static void main(String[] args) {
        int n = 7;
        int[][] graph = {
            {1, 3},
            {0, 2},
            {1, 3, 5},
            {0, 2, 4},
            {3, 5, 6},
            {2, 4, 6},
            {4, 5}
        };

        boolean[] visited = new boolean[n];
        printHamiltonianPathAndCycle(graph, 0, visited, ""+0);
    }

    private static void printHamiltonianPathAndCycle(int[][] graph, int source, boolean[] visited, String psf) {
        if (psf.length() == graph.length) {
            System.out.print("Hamiltonian Path = " + psf);
            int firstSource = Integer.parseInt(String.valueOf(psf.charAt(0)));
            for (int nbr : graph[source]) {
                if (nbr == firstSource) {
                    System.out.print(" * Cycle found");
                    break;
                }
            }
            System.out.println();
        }
        visited[source] = true;
        for (int nbr: graph[source]) {
            if (!visited[nbr]) {
                printHamiltonianPathAndCycle(graph, nbr, visited, psf + nbr);
            }
        }
        visited[source] = false;
    }
}
