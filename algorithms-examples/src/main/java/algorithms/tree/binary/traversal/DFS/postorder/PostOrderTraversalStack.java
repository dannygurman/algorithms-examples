package algorithms.tree.binary.traversal.DFS.postorder;

import algorithms.tree.binary.common.model.Node;
import algorithms.tree.binary.traversal.DFS.AbsDFSTraversal;
import algorithms.tree.binary.traversal.TreeTraversal;

import java.util.List;
import java.util.Stack;

public class PostOrderTraversalStack extends AbsDFSTraversal {


    /*  (Left, Right, Root) : 4 5 2 3 1  */


    protected void traverseTreeInternal(List<Node> visitedNodes, Node node) {

        //Stack for the nodes
        Stack<Node> stack = new Stack<Node>();

        //Push root
        stack.push(node);//Can use only peek

        while (!stack.isEmpty()) {
            //pop from node
            node = stack.peek();

            if (node.left == null && node.right == null) {
                Node poped = stack.pop();
                visitedNodes.add(poped);
            } else {
                if (node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                }

                if (node.left != null) {
                    stack.push(node.left);
                    node.left = null;
                }


            }
        }

    }

}
