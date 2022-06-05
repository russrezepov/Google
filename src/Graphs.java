import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Graphs {

    class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }

        // equals and hashCode
    }

    class Graph {
        private Map<Vertex, List<Vertex>> adjVertices;

        // standard constructor, getters, setters


        void addVertex(String label) {
            adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
        }

        void removeVertex(String label) {
            Vertex v = new Vertex(label);
            adjVertices.values().stream().forEach(e -> e.remove(v));
            adjVertices.remove(new Vertex(label));
        }

        void addEdge(String label1, String label2) {
            Vertex v1 = new Vertex(label1);
            Vertex v2 = new Vertex(label2);
            adjVertices.get(v1).add(v2);
            adjVertices.get(v2).add(v1);
        }

        void removeEdge(String label1, String label2) {
            Vertex v1 = new Vertex(label1);
            Vertex v2 = new Vertex(label2);
            List<Vertex> eV1 = adjVertices.get(v1);
            List<Vertex> eV2 = adjVertices.get(v2);
            if (eV1 != null)
                eV1.remove(v2);
            if (eV2 != null)
                eV2.remove(v1);
        }

        List<Vertex> getAdjVertices(String label) {
            return adjVertices.get(new Vertex(label));
        }
    }//Graph
}
