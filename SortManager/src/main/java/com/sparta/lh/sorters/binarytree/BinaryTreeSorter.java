package com.sparta.lh.sorters.binarytree;


import com.sparta.lh.exceptions.ChildNotFoundException;
import com.sparta.lh.sorters.Sorter;


public class BinaryTreeSorter implements Sorter, BinaryTreeInterface {
    private Node rootNode;
    private int[] arrayToSort;
    private int indexAsc;

    public BinaryTreeSorter() {
    }

    public int[] sortArray(int[] arrayToSort) {
        rootNode = new Node(arrayToSort[0]);
        this.arrayToSort = arrayToSort;
        addElements(arrayToSort);
        return getSortedTreeAsc();
    }




    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public void addElement(final int element) {
        addNodeToTree(rootNode, element);
    }

    @Override
    public void addElements(final int[] arrayToSort) {
        int index = 1;
        addNodesToTree(arrayToSort);
    }

    @Override
    public int getNumberOfElements() {
        return nodeNum(rootNode);
    }

    private int nodeNum(Node rootNode) {
        if (rootNode == null)
            return 0;
        return 1 + nodeNum(rootNode.getLeftChild()) + nodeNum(rootNode.getRightChild());
    }

    @Override
    public boolean findElement(final int value) {
        Node node = findNode(value);
        if(node != null) {
            try {
                getLeftChild(value);
                getRightChild(value);
            } catch (ChildNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if(node.getLeftChild() == null) {
            throw new ChildNotFoundException("No Left Child");
        }
        return node.getLeftChild().getValue();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if(node.getRightChild() == null) {
            throw new ChildNotFoundException("No Right Child");
        }
        return node.getRightChild().getValue();
    }

    private Node findNode(int element) {
        Node node = rootNode;
        while(node != null) {
            if(element == node.getValue()) {
                return node;
            }
            if(element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return null;
    }

    private void addNodeToTree(Node node, int element) {
        if(element == node.getValue()) return;

        if(element < node.getValue()) {
            if(node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if(element > node.getValue()) {
            if(node.isRightChildEmpty()) {
                node.setRightChild(new Node(element));
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    private void addNodesToTree(int[] arrayToAdd) {
        int index = 1;
        Node node = rootNode;
        for(int i = 1; i < arrayToAdd.length; i++) {
            NewNodeSet:
            do {
                if (arrayToAdd[i] < node.getValue()) {
                    if (node.isLeftChildEmpty()) {
                        node.setLeftChild(new Node(arrayToAdd[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getLeftChild();
                        continue NewNodeSet;
                    }
                } else if (arrayToAdd[i] > node.getValue()) {
                    if (node.isRightChildEmpty()) {
                        node.setRightChild(new Node(arrayToAdd[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getRightChild();
                        continue NewNodeSet;
                    }
                } else if(arrayToAdd[i] == node.getValue()) {
                    if (node.isLeftChildEmpty()) {
                        node.setLeftChild(new Node(arrayToAdd[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getLeftChild();
                        continue NewNodeSet;
                    }
                }
            } while(index < arrayToAdd.length);
        }
    }

    @Override
    public int[] getSortedTreeAsc() {
        int[] sortedArrayToFill = new int[arrayToSort.length];
        return returnAscTree(sortedArrayToFill, rootNode);
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] sortedArrayToFill = new int[arrayToSort.length];
        return returnDescTree(sortedArrayToFill, rootNode);
    }

    public int[] returnAscTree(int[] sortedArray, Node node) {
        if (!node.isLeftChildEmpty()) {
            returnAscTree(sortedArray, node.getLeftChild());
        }
        sortedArray[indexAsc] = node.getValue();
        indexAsc += 1;
        if (!node.isRightChildEmpty()) {
            returnAscTree(sortedArray, node.getRightChild());
        }
        return sortedArray;
    }

    public int[] returnDescTree(int[] sortedArray, Node node) {
        if (!node.isRightChildEmpty()) {
            returnDescTree(sortedArray, node.getRightChild());
        }
        sortedArray[indexAsc] = node.getValue();
        indexAsc += 1;
        if (!node.isLeftChildEmpty()) {
            returnDescTree(sortedArray, node.getLeftChild());
        }
        return sortedArray;
    }

    @Override
    public String toString() {
        return "Binary Tree Sorter";
    }
    }
