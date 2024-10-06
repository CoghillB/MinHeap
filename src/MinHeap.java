/*
	Brayden Coghill
	300347436
 */

import java.util.NoSuchElementException;

/**
 * MinHeap of Comparables. Two E objects which extend Comparable can
 * be compared by e1.compareTo(e2), and if this results in a negative
 * value, e1 comes before e2. If it results in a positive value, e2 comes
 * first.
 * This class extends fullBinaryTree, meaning we can use the left and right
 * child functions to get the index of child nodes. But it must also support
 * heap functionality, like up-heap, trickle-down, and extract-min.
 *
 * @param <E>
 */

public class MinHeap<E extends Comparable<E>>
        extends FullBinaryTree<E>
        implements HeapADT<E> {

    /**
     * Constructs the underlying ArrayList<E> called 'nodes'
     */
    public MinHeap() {
        // Nothing to change here.
        super();
    }

    @Override
    public E poll() {
        //DONE: Get (and remove) the root element. If there are any
        //elements left, extract the last element of nodes and
        //place it into the root position. Then call trickleDown(0) before
        //returning the original root.
        if (nodes.isEmpty()) {
            return null;
        }

        E root = nodes.getFirst();
        if (size() == 1) {
            return nodes.removeLast();
        }

        E lastElement = nodes.removeLast();
        nodes.set(0, lastElement);
        trickleDown(0);
        return root;
    }

    private void trickleDown(int i) {
        //DONE: To trickle-down at index i:
        //Determine which of the left or right child is smaller
        //(if they exist at all), then if that child comes
        //before the value at position i, swap them and recurse.

        int left = leftChild(i);
        int right = rightChild(i);
        int smaller = i;

        if (left < size() && nodes.get(left).compareTo(nodes.get(smaller)) < 0) {
            smaller = left;
        }

        if (right < size() && nodes.get(right).compareTo(nodes.get(smaller)) < 0) {
            smaller = right;
        }

        if (smaller != i) {
            E temp = nodes.get(i);
            nodes.set(i, nodes.get(smaller));
            nodes.set(smaller, temp);
            trickleDown(smaller);
        }


    }

    @Override
    public E peek() {
        //DONE: return the root, without removing it
        if (nodes.isEmpty()) {
            return null;
        } else {
            return nodes.getFirst();
        }
    }

    @Override
    public void add(E e) {
        //DONE: add an element at the end of nodes, then
        //call upHeap on the last index.
        nodes.add(e);
        upHeap(size() - 1);
    }

    private void upHeap(int index) {
        //DONE: If index==0, you are done. Otherwise, if the element at
        //index comes before its parent, swap it with its parent and then
        //call upHeap on the parent index.
        if (index == 0) {
            return;
        } else {
            int parent = parent(index);
            if (nodes.get(index).compareTo(nodes.get(parent)) < 0) {
                E temp = nodes.get(index);
                nodes.set(index, nodes.get(parent));
                nodes.set(parent, temp);
                upHeap(parent);
            }
        }
    }

    public String toString() {
        // Nothing to change here.
        return nodes.toString();
    }
}


