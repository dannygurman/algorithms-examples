package algorithms.tree.binary.traversal.DFS.postorder;

import algorithms.tree.binary.common.model.Node;
import algorithms.tree.binary.traversal.DFS.AbsDFSTraversal;
import algorithms.tree.binary.traversal.TreeTraversal;

import java.util.List;

public class PostOrderTraversalRecursion extends AbsDFSTraversal {

    /*  (Left, Right, Root) : 4 5 2 3 1  */


    protected void traverseTreeInternal(List<Node> list, Node node) {

        Node rightNode = node.right;
        Node leftNode = node.left;

        if (leftNode != null) {
            traverseTreeInternal(list, leftNode);
        }


        if (rightNode != null) {
            traverseTreeInternal(list, rightNode);
        }

        list.add(node);
    }
}
