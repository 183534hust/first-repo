package learn;

import java.util.ArrayList;

public class Node {
    public int value;
    public ArrayList<Node> child;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, ArrayList<Node> child) {
        this.value = value;
        this.child = child;
    }

}
