package learn;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File inputFile = new File("C:\\Users\\Admin\\DoThi\\src\\learn\\input.txt");
        File outputFile = new File("C:\\Users\\Admin\\DoThi\\src\\learn\\dothi.dot");
        try {
            Scanner scanner = new Scanner(inputFile);
            Scanner scanner1 = new Scanner(inputFile);

            int soNode = demNode(scanner1);
            ArrayList<Node> nodes = readInputToList(scanner, soNode);

            Graph graph = new Graph(soNode, nodes);
            toFileDot(graph, outputFile);

            int[] duongDi = timDuong(graph);
            duongDiToFileDot(graph, duongDi);

            scanner.close();
            scanner1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void duongDiToFileDot(Graph graph, int[] duongDi) {

    }

    private static int[] timDuong(Graph graph) {
        int soNode = graph.soNode;
        Node start = graph.nodes.get(0);
        Node end = graph.nodes.get(soNode - 1);
        int[] duongDi = new int[soNode];


        return duongDi;
    }

    private static void toFileDot(Graph graph, File outputFile) {
        try {
            PrintWriter printWriter = new PrintWriter(outputFile);
            printWriter.println("digraph G { ");
            for (int i = 0; i < graph.soNode; i++) {
                if (!graph.nodes.get(i).child.isEmpty()) {
                    for (int j = 0; j < graph.nodes.get(i).child.size(); j++) {
                        printWriter.println(graph.nodes.get(i).value + " -> " +
                                graph.nodes.get(i).child.get(j).value);
                    }
                }
            }
            printWriter.println("} ");
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Node> readInputToList(Scanner scanner, int soNode) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < soNode; i++) {
            ArrayList<Node> child = new ArrayList<>(0);
            Node node = new Node(i + 1, child);
            nodes.add(node);
        }
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String line = str.replaceAll("\\s\\s+", " ").trim();
            String[] arr = line.split(" ");
            int n = arr.length;
            int[] intArr = new int[n];                                                // 1 2 3
            for (int i = 0; i < n; i++) {                                             // 2 4
                intArr[i] = Integer.parseInt(arr[i]);                                 // 3 4
            }
            for (int i = 1; i < n; i++) {
                nodes.get(intArr[0] - 1).child.add(nodes.get(intArr[i] - 1));
            }
        }
        return nodes;
    }

    private static int demNode(Scanner scanner) {
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            if (!list.contains(i)) {
                list.add(i);
            }
        }
        return list.size();
    }
}