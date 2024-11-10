package main.java.graph;

import java.util.List;

/**
 * ClassName: Vertex
 * PackageName: main.java.graph
 * Description: 頂點類
 *
 * @Create: 2024/10/17-下午 05:22
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
