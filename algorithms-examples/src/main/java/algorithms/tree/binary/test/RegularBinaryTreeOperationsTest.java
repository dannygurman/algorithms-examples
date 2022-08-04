package algorithms.tree.binary.test;

import algorithms.tree.binary.common.model.BinaryTree;
import algorithms.tree.binary.traversal.TraversalType;
import algorithms.tree.binary.common.utils.BinaryTreeUtils;
import algorithms.tree.binary.traversal.TreeTraversalHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static algorithms.tree.binary.common.utils.BinaryTreeUtils.TreeValues.*;

public class RegularBinaryTreeOperationsTest {

    private BinaryTree tree;

    @Before
    //TREE:
    //         1(A)
    //     2 (B)                     3(C)
    //  4 (D)         5(E)    20(F)      G(100)
    public void setUp() {
         tree = BinaryTreeUtils.buildExampleRegularBinaryTree();
    }


    @Test
    public void testRegularTreeMinAndMaxFind() {
        Integer minFound = BinaryTreeUtils.getRegularBinaryTreeMinElement(this.tree.root);
        Integer maxFound = BinaryTreeUtils.getRegularBinaryTreeMaxElement(this.tree.root);
        System.out.println("Min:" + minFound + " Max:" + maxFound);
        assertEquals(BinaryTreeUtils.MIN_VALUE, minFound);
        assertEquals(BinaryTreeUtils.MAX_VALUE, maxFound);
    }



    @Test
    public void test_deleteNode_ByValue() {
        int nodeToDeleteKey = A.getValue();

        System.out.println("\nBefore deleting:" + nodeToDeleteKey);
        printTreeElementsInOrder();
        List<Integer>  orderedTreeNodeValuesBeforeDeletion = TreeTraversalHandler.traversalTree(this.tree,  TraversalType.INORDER_RECURSION);
        assertThat(orderedTreeNodeValuesBeforeDeletion, hasItems(nodeToDeleteKey));

        BinaryTreeUtils.deleteNodeByValue(this.tree.root, nodeToDeleteKey);

        System.out.println("\nAfter delete:" + nodeToDeleteKey);
        printTreeElementsInOrder();
        List<Integer>  orderedTreeNodeValuesAfterDeletion = TreeTraversalHandler.traversalTree(this.tree,  TraversalType.INORDER_RECURSION);
        //Assert NOT contain item after deletion
        assertThat(orderedTreeNodeValuesAfterDeletion, not(hasItems(nodeToDeleteKey)));
    }

    @Test
    public void test_FindDeepest() {
        BinaryTreeUtils.DeepestResult result = BinaryTreeUtils.findDeepestRightMostNode_2(this.tree.root);
        assertEquals(3, result.deepestLevel);
        assertEquals(G.getValue(), result.deepestValue);
    }

    @Test
    public void test_InsertInDeepestRightMost() {
        int value = 200;
        BinaryTreeUtils.insertInDeepestRightMost(this.tree.root, value);

        BinaryTreeUtils.DeepestResult result = BinaryTreeUtils.findDeepestRightMostNode_2(this.tree.root);
        assertEquals(4, result.deepestLevel);
        assertEquals(value, result.deepestValue);
    }


    private void printTreeElementsInOrder() {
        System.out.println("-----------------------");
        List<Integer>  orderedTreeNodeValues = TreeTraversalHandler.traversalTree(this.tree, TraversalType.INORDER_RECURSION);
        orderedTreeNodeValues.forEach(System.out::println);
    }
}
