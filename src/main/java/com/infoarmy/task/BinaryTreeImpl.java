package com.infoarmy.task;

public class BinaryTreeImpl implements BinaryTree
{

    private Node head;
    
    public Node getHead()
    {
        return head;
    }

    public void insert(Node node)
    {
        if (head == null)
        {
            head = node;
        } else
        {
            insert(head, node);
        }
    }

    private void insert(Node head, Node node)
    {
        /**
         * If node is less than head insert left, otherwise insert right
         */
        if (node.compareTo(head) <= 0)
        {
            if (head.getLeft() != null)
            {
                insert(head.getLeft(), node);
            } else
            {
                head.setLeft(node);
            }

        } else
        {
            if (head.getRight() != null)
            {
                insert(head.getRight(), node);
            } else
            {
                head.setRight(node);
            }
        }
    }

    public String printInOrder()
    {
        return printInOrder(head);

    }

    public String printInOrder(Node node)
    {
        StringBuffer orderedString = new StringBuffer();
        if (node.getLeft() != null)
        {
            orderedString.append(printInOrder(node.getLeft()));
            orderedString.append(",");
        }

        orderedString.append(node.getValue());
        if (node.getRight() != null)
        {
            orderedString.append(",");
            orderedString.append(printInOrder(node.getRight()));
        }
        
        return orderedString.toString();
    }

    public void insertBranch(Node branch)
    {
        insert(branch);
    }

}
