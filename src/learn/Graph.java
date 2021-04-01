package learn;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    public int soNode;
    public ArrayList<Node> nodes;
    public int[][] maTranKe;

    public Graph() {
    }

    public Graph(int soNode, ArrayList<Node> nodes) {
        this.soNode = soNode;
        this.nodes = nodes;
        this.maTranKe = setMaTranke(soNode, nodes);
    }

    private static int[][] setMaTranke(int soNode, ArrayList<Node> nodes) {
        int[][] maTranKe = new int[soNode][soNode];
        for (int i = 0; i < soNode; i++)
            for (int j = 0; j < soNode; j++) {
                maTranKe[i][j] = 0;
            }
        for(int i = 0;  i < soNode ; i++){
            Node currentNode = nodes.get(i);
            if(!currentNode.child.isEmpty()){
                for (int j = 0; j < currentNode.child.size(); j++) {
                    maTranKe[currentNode.value-1][currentNode.child.get(j).value-1] = 1;
                }
            }
        }

        return maTranKe;
    }

}
