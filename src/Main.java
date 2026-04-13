
public class Main {
    public static void main(String[] args) {
        String[] etiquetas = {"A", "B", "C", "D", "E", "F", "G"};

        int[][] matriz = {
                {0,1,1,0,0,0,0}, // A conectado con B y C
                {1,0,0,1,0,0,0}, // B conectado con A y D
                {1,0,0,0,1,0,0}, // C conectado con A y E
                {0,1,0,0,0,1,0}, // D conectado con B y F
                {0,0,1,0,0,1,1}, // E conectado con C, F y G
                {0,0,0,1,1,0,0}, // F conectado con D y E
                {0,0,0,0,1,0,0}  // G conectado con E
        };

        Grafo grafo = new Grafo(matriz, etiquetas);

        grafo.bfs("A");
        grafo.dfs("A");
    }
}
