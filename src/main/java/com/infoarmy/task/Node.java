package com.infoarmy.task;

public class Node implements Comparable<Node>
{

    private final String value;

    private Node left;
    private Node right;

    public Node(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }

    public void setLeft(Node left)
    {
        this.left = left;
    }

    public Node getLeft()
    {
        return left;
    }

    public void setRight(Node right)
    {
        this.right = right;
    }

    public Node getRight()
    {
        return right;
    }

    public int compareTo(Node rhs)
    {
        return this.getValue().compareTo(rhs.getValue());
    }
    
    @Override
    public String toString()
    {
        return value;
    }
}
