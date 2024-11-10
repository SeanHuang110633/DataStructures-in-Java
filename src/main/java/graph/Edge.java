package main.java.graph;

/**
 * ClassName: Edge
 * PackageName: main.java.graph
 * Description: 邊類
 */
public class Edge {

    Vertex linked; // 邊指向的頂點
    int weight;

    public Edge(Vertex linked) {
        this(linked,1);
    }

    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
    }
}
