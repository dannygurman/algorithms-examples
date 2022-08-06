package algorithms.tree.binary.traversal.BFS;

import algorithms.tree.binary.common.model.Node;
import algorithms.tree.binary.traversal.DFS.TreeTraversal;

import java.util.List;
//https://www.geeksforgeeks.org/level-order-tree-traversal/
public class BFSTraversalRecursion extends TreeTraversal {

    @Override
    protected void traverseTreeInternal(final List<Node> visitedNodes, final Node node) {
        int h = height(node);
        int level;
        for (level = 1; level <= h; level++)
            traverseCurrentLevel(visitedNodes, node, level);
    }

    void traverseCurrentLevel(final List<Node> visitedNodes, Node node, int level)
    {
        if (node == null)
            return;
        if (level == 1)
            visitedNodes.add(node);
        else if (level > 1) {
            traverseCurrentLevel(visitedNodes, node.left, level - 1);
            traverseCurrentLevel(visitedNodes, node.right, level - 1);
        }
    }

    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node node) {
        if (node == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);

            /* use the larger one */
            if (leftHeight > rightHeight) {
                return (leftHeight + 1);
            }
            else {
                return (rightHeight + 1);
            }
        }
    }


}
