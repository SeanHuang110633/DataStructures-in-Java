package main.java.graph;

import java.util.List;

/**
 * ClassName: Vertex
 * PackageName: main.java.graph
 * Description: 頂點類
 *
 */
public class Vertex {
    String name;
    List<Edge> edges;

    public Vertex(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
