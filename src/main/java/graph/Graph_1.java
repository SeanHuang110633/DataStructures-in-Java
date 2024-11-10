package main.java.graph;

import java.util.List;

/**
 * ClassName: Graph_1
 * PackageName: main.java.graph
 * Description:
 *
 */
public class Graph_1 {
    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");

        a.edges = List.of(new Edge(b),new Edge(c));
        b.edges = List.of(new Edge(d));
        c.edges = List.of(new Edge(d));
        d.edges = List.of();
    }
}
