package com.infoarmy.task;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeImplTest
{
    
    @Test
    public void verifyInsertOrder()
    {
        BinaryTreeImpl uut = new BinaryTreeImpl();
        uut.insert(new Node("y"));
        uut.insert(new Node("z"));
        uut.insert(new Node("x"));
        
        Assert.assertEquals(uut.getHead().getValue(), "y");
        Assert.assertEquals(uut.getHead().getLeft().getValue(), "x");
        Assert.assertEquals(uut.getHead().getRight().getValue(), "z");
        
    }
    
    /**
     * Picked random strings from dictinary to verify they come in order.
     */
    @Test
    public void verifyDictionaryOrdering()
    {
        BinaryTree uut = new BinaryTreeImpl();
        
        uut.insert(new Node("devolve"));
        uut.insert(new Node("diamond"));
        uut.insert(new Node("extremist"));
        uut.insert(new Node("control"));
        uut.insert(new Node("calm"));
        uut.insert(new Node("displace"));
        uut.insert(new Node("ideal"));
        
        Assert.assertEquals("calm,control,devolve,diamond,displace,extremist,ideal", uut.printInOrder());
    }

    @Test
    public void verifyPrintOrder()
    {
        BinaryTree uut = new BinaryTreeImpl();
        
        uut.insert(new Node("a"));
        uut.insert(new Node("b"));
        
        Assert.assertEquals("a,b", uut.printInOrder()); 
    }
    
    @Test
    public void verifyPrintOrderForBranch()
    {
        BinaryTree uut = new BinaryTreeImpl();
        
        uut.insert(new Node("a"));
        uut.insert(new Node("b"));
    
        BinaryTreeImpl secondTree = new BinaryTreeImpl();
        secondTree.insert(new Node("y"));
        secondTree.insert(new Node("z"));
        secondTree.insert(new Node("x"));
        
        uut.insertBranch(secondTree.getHead());
        Assert.assertEquals("a,b,x,y,z", uut.printInOrder()); 
    }
}
