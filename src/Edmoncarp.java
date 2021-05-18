//H.M.S.S.B.HERATH
//2019582
//W1790114

//Edmond Karp algorithm used in this programme to find max flow which is implemented using ford fulkerson algorithm with Breath first search
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Edmoncarp {

    //declaring variables
    private boolean[] visited;
    private Edge[] edgeTo;
    private int result = 0;
    Instant start, end;
    double duration;


    public Edmoncarp(Dirgraph dirgraph) {

        start = Instant.now();// starting logging time
        System.out.println("...\nCalculating Maximum Flow...");
        int s = dirgraph.getSourceVertex(); //source
        int t = dirgraph.getSinkVertex();   //sink
        int pathNo = 1;
//-----------------------------------------------------------------------------------------//

        while (breadthFirstSearch(dirgraph, s, t)) {//  augmenting path from source to sink
            int minCapacity = Integer.MAX_VALUE;

            Stack<Integer> stack = new Stack<>();// Displaying current augmenting path
            for (int v = t; v != s; v = edgeTo[v].from()) {
                stack.push(edgeTo[v].to());
            }
            System.out.print("Path No. " + pathNo +": (0)");
            pathNo++;
            while (!stack.empty()) {
                System.out.print("->>("+stack.pop()+")");
            }
            System.out.println();
   //------------------------------------------------------------------------------------------//
            // Find minimum capacity in the path
            for (int v = t; v != s; v = edgeTo[v].from()) {
                minCapacity = Math.min(minCapacity, edgeTo[v].residualCapTo());
            }
            System.out.println("MIN CAPACITY of this path: " + minCapacity);
            // Add to the flow
            for (int v = t; v != s; v = edgeTo[v].from()) {
                edgeTo[v].addResidualFlow(minCapacity);
            }
            result += minCapacity;
            System.out.println("Adding flow of "+minCapacity+" to the network...");

            System.out.print("Current state of this path: ( 0 )");
            Stack<Edge> path = new Stack<>();
            for (int v = t; v != s; v = edgeTo[v].from()) {
                path.push(edgeTo[v]);
            }
            while (!path.empty()) {
                Edge e = path.peek();
                System.out.print("-"+e.flow()+"/"+e.capacity()+"->( "+e.to()+" )");
                path.pop();
            }
            System.out.println("\nCURRENT TOTAL FLOW: " + result);

               //executing time count
        }
        end = Instant.now();
        duration = ChronoUnit.MILLIS.between(start, end) / 1000.0;
        System.out.print("Execution time: " + duration + " seconds");
    }
    //------------------------------------------------------------------------------------------//
    // class methods
    public boolean breadthFirstSearch(Dirgraph dirgraph, int source, int sink) {

        // Initialize variables
        visited = new boolean[dirgraph.getSize()];
        edgeTo = new Edge[dirgraph.getSize()];
        Queue<Integer> queue = new LinkedList<>();

        // Begin with source Vertex
        visited[source] = true;
        queue.add(source);

        // Go to Vertex from the queue
        while (!queue.isEmpty())  {

            int head = queue.remove();
        // Explore all Edges from this Vertex
            for (Edge edge : dirgraph.getVertex(head).getEdges()) {
                int tail = edge.to();
                if (edge.residualCapTo() > 0 && !visited[tail]) {
                    edgeTo[tail] = edge;
                    visited[tail] = true;
                    queue.add(tail);
                }
            }
        }
        // Has augmenting path to sink?
        System.out.println("\nHAS AUGMENTING PATH? - " + visited[sink]);
        return visited[sink];
    }


    public int getResult() {
        return result;
    }
}
