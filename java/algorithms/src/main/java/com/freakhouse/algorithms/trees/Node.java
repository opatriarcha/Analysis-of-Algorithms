package com.freakhouse.algorithms.trees;

import lombok.Data;

/**
 *
 * @author freakhouselabs
 */
@Data
public class Node {

    private Node leftNode;
    private Node rightNode;
    private Node fatherNode;
    private int key;
    private int balancing;

    public Node(int k) {
        setLeftNode(setRightNode(setFatherNode(null)));
        setBalancing(0);
        setKey(k);
    }
    
    public Node setRightNode(Node direita) {
		this.rightNode = direita;
		return direita;
	}
    
    public Node setFatherNode(Node pai) {
		this.fatherNode = pai;
		return pai;
	}
}
