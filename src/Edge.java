//H.M.S.S.B.HERATH
//2019582
//W1790114


public class Edge {

    //declaring variable
    private final int CAPACITY;
    private final int HEAD; //source node
    private final int TAIL;//sink node
    private int flow;

    //------------------------------------------------------------------------------------------//
    public Edge(int head, int tail, int capacity) {
        HEAD = head;
        TAIL = tail;
        this.CAPACITY = capacity;
        flow = 0;
    }
    //------------------------------------------------------------------------------------------//

    public int residualCapTo() {
        return CAPACITY - flow;
    }
    public void addResidualFlow(int partialFlow) {
        flow += partialFlow;
    }
    public int capacity() {
        return CAPACITY;
    }
    public int flow() {
        return flow;
    }
    public int from() {
        return HEAD;
    }
    public int to() {
        return TAIL;
    }
    public void resetFlow() { flow = 0; }
}
