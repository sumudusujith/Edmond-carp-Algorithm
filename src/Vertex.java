//H.M.S.S.B.HERATH
//2019582
//W1790114
import java.util.ArrayList;

public class Vertex {

    // attributes for class vertex
    private final int VERTEX_NUMBER; //// number of vertices (NODES) in the graph
    private final ArrayList<Edge> setOfEdges;


    public Vertex(int vertexNumber) {
        this.VERTEX_NUMBER = vertexNumber;
        setOfEdges = new ArrayList<>();
    }

    // class methods
    public void addLinkedVertex(int head, int tail, int capacity) {
        setOfEdges.add(new Edge(head, tail, capacity));
    }

    public String printAllEdges() {
        if (setOfEdges.isEmpty()) {
            return " ->> null";
        } else {
            StringBuilder str = new StringBuilder();
            for (Edge edge : setOfEdges) {
                str.append(" ->> [").append(edge.to()).append(" (").append(edge.capacity()).append(")]");
            }
            return str.toString();
        }
    }

    public int getVertexNumber() {
        return VERTEX_NUMBER;
    }

    public ArrayList<Edge> getEdges() {
        return setOfEdges;
    }
}
