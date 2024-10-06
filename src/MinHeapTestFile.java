/*
	Brayden Coghill
	300347436
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MinHeapTestFile {

    @Test
    void testEmptyPeek() {
        MinHeap<Integer> m = new MinHeap<>();
        assertEquals(null, m.peek());
    }

    @Test
    void testEmptyPoll() {
        MinHeap<Integer> m = new MinHeap<>();
        assertEquals(null, m.poll());
    }

    @Test
    void testEmptySize() {
        MinHeap<Integer> m = new MinHeap<>();
        assertEquals(0, m.size());
        m.add(6);
        assertEquals(1, m.size());
    }

    @Test
    void testFewIntegers() {
        MinHeap<Integer> m = new MinHeap<>();
        m.add(5);
        m.add(1);
        m.add(9);
        assertEquals(1, m.poll());
        assertEquals(5, m.poll());
        assertEquals(9, m.poll());
    }

    @Test
    void testRepeatedValues() {
        MinHeap<Integer> m = new MinHeap<>();
        m.add(5);
        m.add(1);
        m.add(9);
        m.add(5);
        m.add(1);
        m.add(9);
        assertEquals(1, m.poll());
        assertEquals(1, m.poll());
        assertEquals(5, m.poll());
        assertEquals(5, m.poll());
        assertEquals(9, m.poll());
        assertEquals(9, m.poll());
    }

    @Test
    void testStrings() {
        MinHeap<String> m = new MinHeap<>();
        m.add("don't");
        m.add("tase");
        m.add("me");
        m.add("bro");
        m.add("all");
        m.add("your");
        m.add("base");
        m.add("are");
        m.add("belong");
        m.add("to");
        m.add("us");
        assertEquals(11, m.size());
        assertTrue("all".equals(m.poll()));
        assertTrue("are".equals(m.poll()));
    }

    @Test
    void testManyDoubles() {
        //DONE: Test that the heap works with many (15 or more) doubles
        MinHeap<Double> d = new MinHeap<>();

        for (int i = 0; i < 15; i++) {
            d.add(Math.random());
        }

        assertEquals(15, d.size());

        double prev = d.poll();

        while (d.size() > 0) {
            double current = d.poll();
            assertEquals(true, prev <= current);
            prev = current;
        }
    }

    @Test
    void testManyCharacters() {
        //DONE: Test that the heap works with many (15 or more) characters
        MinHeap<Character> c = new MinHeap<>();

        for (int i = 0; i < 15; i++) {
            c.add((char) (i + 'a'));
        }

        assertEquals(15, c.size());

        Character prev = c.poll();

        while (c.size() > 0) {
            Character current = c.poll();
            assertEquals(true, prev <= current);
            prev = current;
        }
    }


    @Test
    void anotherHeapTest() {
        //DONE: make another test looking for possible things that can break
        //      your heap implementation. Write a description of what you
        //      are trying to test (example, all negatives? all equal? does it
        //      work on sorted order input? reverse sorted order? etc)

        // Testing if all the entries are negative in the heap
        MinHeap<Integer> m = new MinHeap<>();
        for (int i = 0; i < 10; i++) {
            m.add(-i);
        }

        assertEquals(10, m.size());

        int prev = m.poll();
        while (m.size() > 0) {
            int current = m.poll();
            assertEquals(true, prev <= current);
            prev = current;
        }
    }

    @Test
    void testHeapSortLarge() {
        //DONE: use a heapSort method like in the UseExample.java to
        // test that heapSort will properly sort a large array. (JUnit
        // files can contain non-test static methods as well).
        // For example:
        // - generate an array of 100 random integers
        // - pass these through a heapSort method
        // - verify that heapSort's result is sorted, either by
        //      checking that a[i]<=a[i+1] for all pairs, or by comparing
        //      it to a 'correct' answer given by Arrays.sort() or Collections.sort()
        MinHeap<Integer> m = new MinHeap<>();
        // Populate the heap with 200 random integers
        for (int i = 0; i < 200; i++) {
            m.add(i);
        }
        int[] a = new int[200];

        // Poll the heap into an array
        for (int i = 0; i < 200; i++) {
            a[i] = m.poll();
        }

        // Sort the array
        Arrays.sort(a);

        // Check if the array is sorted
        assertEquals(true, Arrays.equals(a, Arrays.stream(a).sorted().toArray()));
    }

    // Testing toString method of MinHeap
    @Test
    public void testToString() {
        MinHeap<Integer> m = new MinHeap<>();
        m.add(5);
        m.add(1);
        m.add(9);
        assertEquals("[1, 5, 9]", m.toString()); // Check internal structure

        m.add(10);
        m.add(15);
        m.add(20);
        assertEquals("[1, 5, 9, 10, 15, 20]", m.toString()); // Check after adding more elements

        m.poll(); // Remove root (1)
        assertEquals("[5, 10, 9, 20, 15]", m.toString()); // Adjusted expected structure after poll
    }
}



