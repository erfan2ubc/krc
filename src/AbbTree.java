import java.util.ArrayList;
import java.util.List;

public class AbbTree<T> {
    private T tree = null;
    private List<T> children = new ArrayList<T>();
    private Node root;
    private Node tail;
    private Node lastNode;
    int maxSize = 2;
    int rootChildCount = 0;
    AbbTree() {
        Node root = new Node();
        root.setChild(null);
        root.setParent(null);
        root.setAbbreviation(null);
        root.setExpansion(null);
        root.setNodeId(0);
        this.root = root;
    }
//    AbbTree(String abbreviation, String expansion) {
//
//        insert(newNode, abbreviation,expansion);
//    }

    AbbTree(T tree) {
        this.tree = tree;
    }
    void insert(String abbreviation, String expansion) {
        Node newNode = new Node(abbreviation, expansion);
        if (rootChildCount == 0) {
            root.setChild(newNode);
            newNode.setParent(root);
            newNode.setChild(null);
            tail = newNode;
            newNode.setNodeId(1);
            rootChildCount++;
            lastNode = newNode;
            root.children.add(newNode);
        }
        //if the specific branch has enough space for a new node
        else if (getParentsNum(lastNode) < maxSize) {
            lastNode.setChild(newNode);
            newNode.setParent(lastNode);
            newNode.setChild(null);
            lastNode = newNode;
            tail = newNode;
        }
        //if the branch is full and new node should create new branch
        else {
            rootChildCount++;
            root.setChild(newNode);
            newNode.setParent(root);
            newNode.setChild(null);
            newNode.setNodeId(rootChildCount);
            lastNode = newNode;
            root.children.add(newNode);
        }
    }
    //Getter
    public Node getRoot() {
        return root;
    }

    public int getParentsNum(Node node) {
        int parentNum = 0;
        while (node.getNodeId() != 0) {
            parentNum++;
            node = node.getParent();
        }
        return parentNum;
    }

    public T getTree() {
        return tree;
    }

    //Setter
    public void setTree(T tree) {
        this.tree = tree;
    }

    public void printBranch(int nodeId) {
        Node currentNode = (Node) root.children.get(nodeId - 1);
        while (currentNode != null) {
            System.out.println(currentNode.getAbbreviation() + " ," + currentNode.getExpansion());
            currentNode = currentNode.getChild();
        }

    }
}
