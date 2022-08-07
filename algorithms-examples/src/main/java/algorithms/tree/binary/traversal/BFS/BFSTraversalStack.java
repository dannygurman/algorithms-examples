package algorithms.tree.binary.traversal.BFS;

import algorithms.tree.binary.common.model.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSTraversalStack extends AbsBFSTraversal {

    @Override
    protected void traverseTreeInternal(final List<Node> visitedNodes, final Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {

            // poll() removes the present head.
            Node tempNode = queue.poll();
            visitedNodes.add(tempNode);

            //Enqueue left child
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            //Enqueue right child
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }

    }

}
