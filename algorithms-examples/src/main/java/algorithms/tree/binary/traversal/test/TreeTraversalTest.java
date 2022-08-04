package algorithms.tree.binary.traversal.test;

import algorithms.tree.binary.common.model.BinaryTree;
import algorithms.tree.binary.common.utils.BinaryTreeUtils;
import algorithms.tree.binary.traversal.TraversalType;
import algorithms.tree.binary.traversal.TreeTraversalHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static algorithms.tree.binary.common.utils.BinaryTreeUtils.TreeValues.A;
import static algorithms.tree.binary.common.utils.BinaryTreeUtils.TreeValues.B;
import static algorithms.tree.binary.common.utils.BinaryTreeUtils.TreeValues.C;
import static algorithms.tree.binary.common.utils.BinaryTreeUtils.TreeValues.D;
import static algorithms.tree.binary.common.utils.BinaryTreeUtils.TreeValues.E;
import static algorithms.tree.binary.common.utils.BinaryTreeUtils.TreeValues.F;
import static algorithms.tree.binary.common.utils.BinaryTreeUtils.TreeValues.G;
import static org.junit.Assert.assertEquals;

public class TreeTraversalTest {

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
    public void testNodesTraverersal_InOrder_ImplementedBy_Recursion() {
        BinaryTreeUtils.TreeValues[] expectedOrderedValues = {D, B, E, A , F, C ,G};
        ////4(D), 2(B),5(E),1(A) ,20(F),3(C),100(G)
        verifyNodesTraverersalInternal(TraversalType.INORDER_RECURSION, expectedOrderedValues);
    }

    @Test
    public void testNodesTraverersal_InOrder_ImplementedBy_Stack() {
        BinaryTreeUtils.TreeValues[] expectedOrderedValues = {D, B, E, A , F, C ,G};
        ////4(D), 2(B),5(E),1(A) ,20(F),3(C),100(G)
        verifyNodesTraverersalInternal(TraversalType.INORDER_STACK, expectedOrderedValues);
    }

    @Test
    public void testNodesTraverersal_PreOrder_ImplementedBy_Recursion() {
        BinaryTreeUtils.TreeValues[] expectedOrderedValues = {A, B, D, E , C, F ,G};
        ////1(A), 2(B), 4(D), 5(E), 3(C), 20(F), 100(G)
        verifyNodesTraverersalInternal(TraversalType.PREORDER_RECURSION, expectedOrderedValues);
    }

    @Test
    public void testNodesTraverersal_PreOrder_ImplementedBy_Stack() {
        BinaryTreeUtils.TreeValues[] expectedOrderedValues = {A, B, D, E , C, F ,G};
        ////1(A), 2(B), 4(D), 5(E), 3(C), 20(F), 100(G)
        verifyNodesTraverersalInternal(TraversalType.PREORDER_STACK, expectedOrderedValues);
    }

    @Test
    public void testNodesTraverersal_PostOrder_ImplementedBy_Recursion() {
        BinaryTreeUtils.TreeValues[] expectedOrderedValues = {D, E, B, F , G, C ,A};
        ////4(D), 5(E), 2(B), 20(F), 100(G), 3(C), 1(A))
        verifyNodesTraverersalInternal(TraversalType.POSTORDER_RECURSION, expectedOrderedValues);
    }

    @Test
    public void testNodesTraverersal_PostOrder_ImplementedBy_Stack() {
        BinaryTreeUtils.TreeValues[] expectedOrderedValues = {D, E, B, F , G, C ,A};
        ////4(D), 5(E), 2(B), 20(F), 100(G), 3(C), 1(A))
        verifyNodesTraverersalInternal(TraversalType.POSTORDER_STACK, expectedOrderedValues);
    }

    private void verifyNodesTraverersalInternal(TraversalType traversalType,
                                                BinaryTreeUtils.TreeValues[] expectedOrderedValues ) {

        List<Integer> orderedTreeNodeValues = TreeTraversalHandler.traversalTree(this.tree, traversalType);

        orderedTreeNodeValues.forEach(System.out::println);

        List <Integer> expectedOrderedTreeNodeValues = Arrays.asList(expectedOrderedValues)
            .stream().map(BinaryTreeUtils.TreeValues::getValue).collect(Collectors.toList());
        ////4(D), 2(B),5(E),1(A) ,20(F),3(C),100(G)
        assertEquals(expectedOrderedTreeNodeValues, orderedTreeNodeValues);
    }


}
