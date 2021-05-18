//H.M.S.S.B.HERATH
//2019582
//W1790114


import java.util.ArrayList;

public class Dirgraph {

    // declaring variables
    private final int SINK_VERTEX;  //attribute for sink node(end)
    private final int SOURCE_VERTEX = 0;//attribute for source node(start)
    private final ArrayList<Vertex> setOfVertices;

    // constructor
    public Dirgraph(int noOfVertices) {
        this.SINK_VERTEX = noOfVertices - 1;
        // Creating ArrayList with initial Capacity equal to number Of vertices
        setOfVertices = new ArrayList<Vertex>(noOfVertices);
        // Create instances of Vertices in the list
        for (int i = 0; i < noOfVertices; i++) {
            setOfVertices.add(new Vertex(i));
        }
    }
//------------------------------------------------------------------------------------------//

    public void addEdge(int head, int tail, int capacity) {
        setOfVertices.get(head).addLinkedVertex(head, tail, capacity);
    }
    //------------------------------------------------------------------------------------------//
 //print the directed graph
    public void printDirgraph() {
        System.out.println("===================================================================\n" +
                "Directed graph representation as Adjacency List:\n");
        for (Vertex vertex : setOfVertices) {
            System.out.println("Vertex: [" + vertex.getVertexNumber() + "]" + vertex.printAllEdges());
        }
        System.out.println("===================================================================");
    }

    public void resetFlows() {
        for (Vertex v : setOfVertices) {
            for (Edge e : v.getEdges()) {
                e.resetFlow();
            }
        }
    };

    public int getSinkVertex() {
        return SINK_VERTEX;
    }
    public int getSourceVertex() {
        return SOURCE_VERTEX;
    }
    public int getSize() {
        return setOfVertices.size();
    }
    public Vertex getVertex(int v) {
        return setOfVertices.get(v);
    }
}
