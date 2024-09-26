public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Добавляем вершины и ребра
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        // Выводим граф
        System.out.println("Граф:");
        graph.printGraph();

        // Проверяем наличие вершины и ребра
        System.out.println("Вершина 2 существует? " + graph.hasVertex(2));
        System.out.println("Ребро между 1 и 3 существует? " + graph.hasEdge(1, 3));

        // Удаляем ребро и вершину
        graph.removeEdge(1, 2);
        graph.removeVertex(3);

        // Выводим граф после изменений
        System.out.println("Граф после изменений:");
        graph.printGraph();
    }
}
