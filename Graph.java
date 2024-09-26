import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph {
    private Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

    // Добавление вершины
    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    // Добавление ребра
    public void addEdge(int source, int destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // Неориентированный граф
    }

    // Удаление вершины
    public void removeVertex(int vertex) {
        adjacencyList.remove(vertex);
        adjacencyList.values().forEach(edges -> edges.remove(vertex));
    }

    // Удаление ребра
    public void removeEdge(int source, int destination) {
        Set<Integer> edgesFromSource = adjacencyList.get(source);
        Set<Integer> edgesFromDestination = adjacencyList.get(destination);
        if (edgesFromSource != null) edgesFromSource.remove(destination);
        if (edgesFromDestination != null) edgesFromDestination.remove(source);
    }

    // Проверка наличия вершины
    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    // Проверка наличия ребра
    public boolean hasEdge(int source, int destination) {
        return adjacencyList.getOrDefault(source, new HashSet<>()).contains(destination);
    }

    // Вывод графа
    public void printGraph() {
        adjacencyList.forEach((vertex, edges) -> {
            System.out.print(vertex + ": ");
            edges.forEach(edge -> System.out.print(edge + " "));
            System.out.println();
        });
    }
}
