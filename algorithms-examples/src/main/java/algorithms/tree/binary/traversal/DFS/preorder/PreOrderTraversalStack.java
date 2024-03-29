package algorithms.tree.binary.traversal.DFS.preorder;

import algorithms.tree.binary.common.model.Node;
import algorithms.tree.binary.traversal.DFS.AbsDFSTraversal;
import algorithms.tree.binary.traversal.TreeTraversal;

import java.util.List;
import java.util.Stack;

public class PreOrderTraversalStack extends AbsDFSTraversal {

   // https://www.geeksforgeeks.org/iterative-preorder-traversal/
       /* Preorder (Root, Left, Right) : 1 2 4 5 3*/


    protected  void traverseTreeInternal(List<Node> visitedNodes, Node node) {

        // Create an empty stack and push root to it
        Stack<Node> stack = new Stack<Node>();

        //Base case
        if (node == null) {
            return;
        }

        stack.push(node);

        while ( !  stack.isEmpty()){
            node = stack.pop();
            visitedNodes.add(node);

            // Push right and left children of the popped node to stack
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }
}
