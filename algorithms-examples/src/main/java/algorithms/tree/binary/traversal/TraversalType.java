package algorithms.tree.binary.traversal;

import algorithms.tree.binary.traversal.BFS.BFSTraversalRecursion;
import algorithms.tree.binary.traversal.BFS.BFSTraversalStack;
import algorithms.tree.binary.traversal.DFS.TreeTraversal;
import algorithms.tree.binary.traversal.DFS.inorder.InOrderTraversalRecursion;
import algorithms.tree.binary.traversal.DFS.inorder.InOrderTraversalStack;
import algorithms.tree.binary.traversal.DFS.postorder.PostOrderTraversalRecursion;
import algorithms.tree.binary.traversal.DFS.postorder.PostOrderTraversalStack;
import algorithms.tree.binary.traversal.DFS.preorder.PreOrderTraversalRecursion;
import algorithms.tree.binary.traversal.DFS.preorder.PreOrderTraversalStack;
import lombok.Getter;

@Getter
public enum TraversalType {
    INORDER_RECURSION(new InOrderTraversalRecursion()),
    INORDER_STACK(new InOrderTraversalStack()),
    POSTORDER_RECURSION(new PostOrderTraversalRecursion()),
    POSTORDER_STACK(new PostOrderTraversalStack()),
    PREORDER_RECURSION(new PreOrderTraversalRecursion()),
    PREORDER_STACK(new PreOrderTraversalStack()),
    BFS_RECURSION(new BFSTraversalRecursion()),
    BFS_STACK(new BFSTraversalStack());

    TraversalType(TreeTraversal implementor) {
        this.traversalImplementor = implementor;
    }

    private TreeTraversal traversalImplementor;
}