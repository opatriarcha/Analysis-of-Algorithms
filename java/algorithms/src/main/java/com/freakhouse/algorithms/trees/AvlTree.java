package com.freakhouse.algorithms.trees;

import java.util.ArrayList;

/**
 *
 * @author freakhouselabs
 */
public class AvlTree {

    protected Node raiz;

    public void inserir(int k) {
        Node n = new Node(k);
        inserirAVL(this.raiz, n);
    }

    public void inserirAVL(Node nodeToCompare, Node nodeToInsert) {

        if (nodeToCompare == null) { //È a raiz da árvore
            this.raiz = nodeToInsert;

        } else {

            if (nodeToInsert.getKey() < nodeToCompare.getKey()) {

                if (nodeToCompare.getLeftNode() == null) {
                    nodeToCompare.setLeftNode(nodeToInsert);
                    nodeToInsert.setFatherNode(nodeToCompare);
                    verifyBalancing(nodeToCompare);

                } else {
                    inserirAVL(nodeToCompare.getLeftNode(), nodeToInsert);
                }

            } else if (nodeToInsert.getKey() > nodeToCompare.getKey()) {

                if (nodeToCompare.getRightNode() == null) {
                    nodeToCompare.setRightNode(nodeToInsert);
                    nodeToInsert.setFatherNode(nodeToCompare);
                    verifyBalancing(nodeToCompare);

                } else {
                    inserirAVL(nodeToCompare.getRightNode(), nodeToInsert);
                }

            } else {
                // O nó já existe
            }
        }
    }

    public void verifyBalancing(Node actual) {
        setBalancing(actual);
        int balancing = actual.getBalancing();

        if (balancing == -2) {

            if (getTreeOrSubtreeHeight(actual.getLeftNode().getLeftNode()) >= getTreeOrSubtreeHeight(actual.getLeftNode().getRightNode())) {
                actual = rightRotation(actual);

            } else {
                actual = duplaRotacaoEsquerdaDireita(actual);
            }

        } else if (balancing == 2) {

            if (getTreeOrSubtreeHeight(actual.getRightNode().getRightNode()) >= getTreeOrSubtreeHeight(actual.getRightNode().getLeftNode())) {
                actual = leftRotation(actual);

            } else {
                actual = duplaRotacaoDireitaEsquerda(actual);
            }
        }

        if (actual.getFatherNode() != null) {
            verifyBalancing(actual.getFatherNode());
        } else {
            this.raiz = actual;
        }
    }

    public void remove(int k) {
        removeAvl(this.raiz, k);
    }

    public void removeAvl(Node atual, int k) {
        if (atual == null)
            return;
        
        if (atual.getKey() > k) {
            removeAvl(atual.getLeftNode(), k);

        } else if (atual.getKey() < k) {
            removeAvl(atual.getRightNode(), k);

        } else if (atual.getKey() == k) {
            removeFoundNode(atual);
            }
    }

    public void removeFoundNode(Node aRemover) {
        Node r;

        if (aRemover.getLeftNode() == null || aRemover.getRightNode() == null) {

            if (aRemover.getFatherNode() == null) {
                this.raiz = null;
                aRemover = null;
                return;
            }
            r = aRemover;

        } else {
            r = sucessor(aRemover);
            aRemover.setKey(r.getKey());
        }

        Node p;
        if (r.getLeftNode() != null) {
            p = r.getLeftNode();
        } else {
            p = r.getRightNode();
        }

        if (p != null) {
            p.setFatherNode(r.getFatherNode());
        }

        if (r.getFatherNode() == null) {
            this.raiz = p;
        } else {
            if (r == r.getFatherNode().getLeftNode()) {
                r.getFatherNode().setLeftNode(p);
            } else {
                r.getFatherNode().setRightNode(p);
            }
            verifyBalancing(r.getFatherNode());
        }
        r = null;
    }

    public Node leftRotation(Node initial) {

        Node right = initial.getRightNode();
        right.setFatherNode(initial.getFatherNode());

        initial.setRightNode(right.getLeftNode());

        if (initial.getRightNode() != null) {
            initial.getRightNode().setFatherNode(initial);
        }

        right.setLeftNode(initial);
        initial.setFatherNode(right);

        if (right.getFatherNode() != null) {

            if (right.getFatherNode().getRightNode() == initial) {
                right.getFatherNode().setRightNode(right);

            } else if (right.getFatherNode().getLeftNode() == initial) {
                right.getFatherNode().setLeftNode(right);
            }
        }

        setBalancing(initial);
        setBalancing(right);

        return right;
    }

    public Node rightRotation(Node initial) {

        Node left = initial.getLeftNode();
        left.setFatherNode(initial.getFatherNode());

        initial.setLeftNode(left.getRightNode());

        if (initial.getLeftNode() != null) {
            initial.getLeftNode().setFatherNode(initial);
        }

        left.setRightNode(initial);
        initial.setFatherNode(left);

        if (left.getFatherNode() != null) {

            if (left.getFatherNode().getRightNode() == initial) {
                left.getFatherNode().setRightNode(left);

            } else if (left.getFatherNode().getLeftNode() == initial) {
                left.getFatherNode().setLeftNode(left);
            }
        }

        setBalancing(initial);
        setBalancing(left);

        return left;
    }

    public Node duplaRotacaoEsquerdaDireita(Node initial) {
        initial.setLeftNode(leftRotation(initial.getLeftNode()));
        return rightRotation(initial);
    }

    public Node duplaRotacaoDireitaEsquerda(Node initial) {
        initial.setRightNode(rightRotation(initial.getRightNode()));
        return leftRotation(initial);
    }

    public Node sucessor(Node q) {
        if (q.getRightNode() != null) {
            Node r = q.getRightNode();
            while (r.getLeftNode() != null) {
                r = r.getLeftNode();
            }
            return r;
        } else {
            Node p = q.getFatherNode();
            while (p != null && q == p.getRightNode()) {
                q = p;
                p = q.getFatherNode();
            }
            return p;
        }
    }

    private int getTreeOrSubtreeHeight(Node actual) {
        if (actual == null) {
            return -1;
        }

        if (actual.getLeftNode() == null && actual.getRightNode() == null) {
            return 0;

        } else if (actual.getLeftNode() == null) {
            return 1 + getTreeOrSubtreeHeight(actual.getRightNode());

        } else if (actual.getRightNode() == null) {
            return 1 + getTreeOrSubtreeHeight(actual.getLeftNode());

        } else {
            return 1 + Math.max(getTreeOrSubtreeHeight(actual.getLeftNode()), getTreeOrSubtreeHeight(actual.getRightNode()));
        }
    }

    private void setBalancing(Node no) {
        no.setBalancing(getTreeOrSubtreeHeight(no.getRightNode()) - getTreeOrSubtreeHeight(no.getLeftNode()));
    }

    final protected ArrayList<Node> inorder() {
        ArrayList<Node> ret = new ArrayList<>();
        inorder(raiz, ret);
        return ret;
    }

    final protected void inorder(Node no, ArrayList<Node> list) {
        if (no == null) {
            return;
        }
        inorder(no.getLeftNode(), list);
        list.add(no);
        inorder(no.getRightNode(), list);
    }
}
