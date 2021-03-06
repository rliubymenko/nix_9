package ua.nure.cs.tree;


import ua.nure.cs.util.BTreeUtils;

public class BPlusTree<TKey extends Comparable<TKey>, TValue> {

    private Node<TKey> root;
    private long height;

    public BPlusTree() {
        this.root = new LeafNode<TKey, TValue>();
        height = 1;
    }

    public void insert(TKey key, TValue value) {
        LeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key, 1);
        leaf.insertKey(key, value);
        if (leaf.isOverflow()) {
            Node<TKey> n = leaf.dealOverflow();
            if (n != null) {
                this.root = n;
                height++;
            }
        }
    }

    public void delete(TKey key) {
        LeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key, 2);

        if (leaf.delete(key) && leaf.isUnderflow()) {
            Node<TKey> n = leaf.dealUnderflow();
            if (n != null)
                this.root = n;
        }
    }

    public TValue search(TKey key) {
        LeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key, 3);
        int index = leaf.search(key);
        return (index == -1) ? null : leaf.getValue(index);
    }

    @SuppressWarnings("unchecked")
    private LeafNode<TKey, TValue> findLeafNodeShouldContainKey(TKey key, int operationType) {
        Node<TKey> node = this.root;
        if (operationType == 1) {
            BTreeUtils.viewedNodesCounterForInsert++;
        } else if (operationType == 2) {
            BTreeUtils.viewedNodesCounterForDelete++;
        } else {
            BTreeUtils.viewedNodesCounterForSearch++;
        }
        while (node.getNodeType() == NodeType.InnerNode) {
            node = ((InnerNode<TKey>) node).getChild(node.search(key));
            if (operationType == 1) {
                BTreeUtils.viewedNodesCounterForInsert++;
            } else if (operationType == 2) {
                BTreeUtils.viewedNodesCounterForDelete++;
            } else {
                BTreeUtils.viewedNodesCounterForSearch++;
            }
        }
        return (LeafNode<TKey, TValue>) node;
    }

    public long getHeight() {
        return height;
    }
}

