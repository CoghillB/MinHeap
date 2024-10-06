import java.util.ArrayList;

public class UseExample {

    public static void main(String[] args) {
        String[] words = {"z", "z", "z", "word", "so", "many", "words", "i",
                "sure", "do", "enjoy", "java", "programming",
                "and", "this", "seems", "to", "be", "enough"};

        double[] numbers = {15.5, 65.9, 94.15, 15.158, 78.2, 32.48, 54.14, 98.3, 85.9,
                2.0, 0.1, 11.8, 37.75, 95.01, 16.32, 75.5};

        ArrayList<String> sorted = heapSort(words);
        ArrayList<Double> doubles = heapSortDoubles(numbers);

        System.out.println(sorted);
        /* Should output:
         * [and, be, do, enjoy, enough, i, java, many, programming, seems, so, sure, this, to, word, words, z, z, z]
         */

        System.out.println(doubles);
        /* Should output:
           [0.1, 2.0, 11.8, 15.158, 15.5, 16.32, 32.48, 37.75, 54.14, 65.9, 75.5, 78.2, 85.9, 94.15, 95.01, 98.3]
         */
    }

    private static ArrayList<String> heapSort(String[] words) {
        ArrayList<String> output = new ArrayList<String>();
        MinHeap<String> m = new MinHeap<>();

        for (String s : words)
            m.add(s);

        while (m.size() > 0) {
            output.add(m.poll());
        }
        return output;
    }

    private static ArrayList<Double> heapSortDoubles(double[] numbers) {
        ArrayList<Double> output = new ArrayList<>();
        MinHeap<Double> m = new MinHeap<>();

        for (double d : numbers)
            m.add(d);

        while (m.size() > 0) {
            output.add(m.poll());
        }
        return output;


    }

}
