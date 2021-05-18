//H.M.S.S.B.HERATH
//2019582
//w1790114
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Console {

    Dirgraph dirgraph;
    String fileName;

    public void welcomeMessage() {
        System.out.println("\n\n                              WELCOME\n" +
                "==============================MAXFLOW==============================\n" +
                "This programme will allow you to calculate the MAXIMUM FLOW of the \n" +
                "the network given,which you can provide in .txt file name\n" +
                "in the ...project/samples/ benchmark file.\n\n" +
                "===================================================================\n" +
                "Click ENTER to continue....\n" +
                "===================================================================");

        try{System.in.read();}
        catch(Exception e){}
    }
    //----------------------------------------------------------------------//
        // main menu methods
    public String menuList() {
        System.out.println(
                "\nselect option from the below menu:\n"
                        + "-------------------------------------------------------------------\n"
                        + "1:\t Load network data from .txt file\n"
                        + "2:\t Calculate MaxFlow\n"
                        + "Q:\t Exit program\n");
        Scanner sc = new Scanner(System.in);
                return sc.nextLine().toLowerCase();// this is for return which select by user
    }
//-----------------------------------------------------------------------------//
    // Menu selection - 1
    public void loadFileOption() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type name of the benchmark file: ");
        fileName = sc.nextLine();
        try {
            loadFile(fileName);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Menu option - 2
    public void maxFlowOption() {
        try {
            computeMaxFlow();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Menu option - T
    public void maxFlowPure() {
        try {
            pureMaxFlow();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//------------------------------------------------------------------------------//
    // programme methods
    private void loadFile(String fileName) throws Exception {
        try {
            String dirPath = System.getProperty("user.dir");
            String fullPath = dirPath + File.separator + "samples" + File.separator + fileName + ".txt";
            Scanner readFile = new Scanner(new BufferedReader(new FileReader(fullPath)));
            // Create Directed graph as Adjacency List
            dirgraph = createDirgraph(readFile);
            // Displaying  Directed graph as Adjacency List
            if (dirgraph == null) {
                System.out.println("The file is empty!!!.Try another file.");
            } else {
                dirgraph.printDirgraph();
                System.out.println("\nThe file loaded:\n" + fullPath);
                System.out.println(".... Directed graph has been created!....\n-------------------------------------------------------------------");
                System.out.println("-------------------------------------------------------------------");
                System.out.println("No. of Vertices in this Directed graph: " + dirgraph.getSize());
                System.out.println("- Source Vertex:  " + dirgraph.getSourceVertex());
                System.out.println("- Sink Vertex:  " + dirgraph.getSinkVertex());
                System.out.println("-------------------------------------------------------------------");
            }
            readFile.close();
        }
        catch (FileNotFoundException error) {
            throw new Exception("\n[exception ERROR]: File not found!!\n");
        }
    }
//-----------------------------------------------------------------------------//

    private Dirgraph createDirgraph(Scanner readFile) {
               if (readFile.hasNext()) { // this is for check if file not empty
            final int NO_OF_VERTICES = Integer.parseInt(readFile.nextLine());
            // Initialize Directed graph as Adjacency List with instances of its Vertices
            Dirgraph dirgraph = new Dirgraph(NO_OF_VERTICES);
            System.out.println("Creating Directed graph...\n");


            while (readFile.hasNext()) {// Adding edges to the Adjacency List
                String line = readFile.nextLine();
                String[] lineArr = line.split(" ");
                dirgraph.addEdge(Integer.parseInt(lineArr[0]), Integer.parseInt(lineArr[1]), Integer.parseInt(lineArr[2]));
            }
            return dirgraph;
        } else {
            return null;
        }
    }
    //-----------------------------------------------------------------------------//
    private void computeMaxFlow() throws Exception {
        if (dirgraph == null) {
            throw new Exception("\n[exception ERROR occurred]: Load File first to create Directed graph!!");
        }
        System.out.println("network data loaded from: " + fileName + ".txt");
        dirgraph.resetFlows();
        Edmoncarp maxFlow = new Edmoncarp(dirgraph);
        System.out.println("\n###############################\n" +
                "MAXIMUM FLOW of this network: " + maxFlow.getResult());
        System.out.println("===================================================================");

    }
    //-----------------------------------------------------------------------------//
    private void pureMaxFlow() throws Exception {
        if (dirgraph == null) {
            throw new Exception("\n[exception ERROR occurred]: Load File first to create Directed graph!");
        }
        System.out.println("network data loaded from " + fileName + ".txt");
        dirgraph.resetFlows();
        Edmoncarp maxFlow = new Edmoncarp(dirgraph);
        System.out.println("\n###############################\n" +
                "MAXIMUM FLOW of this network: " + maxFlow.getResult());
    }
}
