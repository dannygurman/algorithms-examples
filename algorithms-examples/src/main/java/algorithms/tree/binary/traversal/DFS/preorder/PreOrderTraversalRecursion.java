package algorithms.tree.binary.traversal.DFS.preorder;

import algorithms.tree.binary.common.model.Node;
import algorithms.tree.binary.traversal.DFS.AbsDFSTraversal;
import algorithms.tree.binary.traversal.TreeTraversal;

import java.util.List;

public class PreOrderTraversalRecursion extends AbsDFSTraversal {

       /* Preorder (Root, Left, Right) : 1 2 4 5 3*/


    protected  void traverseTreeInternal(List<Node> list, Node node){

        Node rightNode = node.right;
        Node leftNode = node.left;

        list.add(node);

        if (leftNode != null){
            traverseTreeInternal( list, leftNode) ;
        }


        if (rightNode != null){
            traverseTreeInternal( list, rightNode) ;
        }

    }

}
