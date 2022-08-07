package algorithms.tree.binary.traversal.BFS;

import algorithms.tree.binary.common.model.Node;

import java.util.List;

/*
Time Complexity:
O(n^2) in WORST CASE.
 For a skewed tree, printGivenLevel() takes O(n) time where n is the number of nodes in the skewed tree.
  So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2).

    Auxiliary Space:
    O(n) in the worst case. For a skewed tree, printGivenLevel() uses O(n) space for call stack.
    For a Balanced tree, the call stack uses O(log n) space (i.e., the height of the balanced tree - better than BFS stack).
*/


public class BFSTraversalRecursion extends AbsBFSTraversal {

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
