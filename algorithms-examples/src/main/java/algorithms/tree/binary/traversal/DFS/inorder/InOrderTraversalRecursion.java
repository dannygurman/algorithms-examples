package algorithms.tree.binary.traversal.DFS.inorder;

import algorithms.tree.binary.common.model.Node;
import algorithms.tree.binary.traversal.DFS.AbsDFSTraversal;
import algorithms.tree.binary.traversal.TreeTraversal;

import java.util.List;

public class InOrderTraversalRecursion extends AbsDFSTraversal {

       /* 4
        2
        5
        1
        3*/

    protected  void traverseTreeInternal(List <Node> visitedNodes, Node node){

        Node rightNode = node.right;
        Node leftNode = node.left;

        if (leftNode != null){
            traverseTreeInternal( visitedNodes, leftNode) ;
        }

        visitedNodes.add(node);

        if (rightNode != null){
            traverseTreeInternal( visitedNodes, rightNode) ;
        }

    }
}
