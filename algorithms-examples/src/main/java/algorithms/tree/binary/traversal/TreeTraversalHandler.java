package algorithms.tree.binary.traversal;

import algorithms.tree.binary.common.model.BinaryTree;

import java.util.List;

public class TreeTraversalHandler {
    public static List<Integer> traversalTree(BinaryTree tree, TraversalType traversalType) {
        return traversalType.getTraversalImplementor().travereseTree(tree);
    }


}
