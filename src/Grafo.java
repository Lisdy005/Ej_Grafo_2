import java.util.*;

class Grafo {
    private int[][] matrizAdyacencia;
    private String[] etiquetas;
    private Map<String, Integer> mapaIndices;

    public Grafo(int[][] matriz, String[] etiquetas) {
        this.matrizAdyacencia = matriz;
        this.etiquetas = etiquetas;
        this.mapaIndices = new HashMap<>();
        for (int i = 0; i < etiquetas.length; i++) {
            mapaIndices.put(etiquetas[i], i);
        }
    }

    public void bfs(String inicio) {
        int idxInicio = mapaIndices.get(inicio);
        boolean[] visitados = new boolean[matrizAdyacencia.length];
        Queue<Integer> cola = new LinkedList<>();

        cola.add(idxInicio);
        visitados[idxInicio] = true;

        System.out.print("BFS: ");
        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.print(etiquetas[actual] + " ");

            for (int j = 0; j < matrizAdyacencia.length; j++) {
                if (matrizAdyacencia[actual][j] == 1 && !visitados[j]) {
                    visitados[j] = true;
                    cola.add(j);
                }
            }
        }
        System.out.println();
    }

    public void dfs(String inicio) {
        int idxInicio = mapaIndices.get(inicio);
        boolean[] visitados = new boolean[matrizAdyacencia.length];
        System.out.print("DFS: ");
        dfsRecursivo(idxInicio, visitados);
        System.out.println();
    }

    private void dfsRecursivo(int nodo, boolean[] visitados) {
        visitados[nodo] = true;
        System.out.print(etiquetas[nodo] + " ");

        for (int j = 0; j < matrizAdyacencia.length; j++) {
            if (matrizAdyacencia[nodo][j] == 1 && !visitados[j]) {
                dfsRecursivo(j, visitados);
            }
        }
    }
}
