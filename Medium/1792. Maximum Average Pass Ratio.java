import java.util.PriorityQueue;

/**
 * Solution to maximize the average pass ratio after assigning extra students.
 */
class Solution {
    /**
     * Calculates the maximum average pass ratio after distributing extra students.
     *
     * @param classes       2D array where classes[i][0] is passed students,
     *                      classes[i][1] is total students
     * @param extraStudents number of extra students to assign
     * @return maximum average pass ratio
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        // Max heap based on the increase in pass ratio if an extra student is added
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Double.compare(b[2], a[2]));
        double totalRatio = 0.0;

        // Initialize the heap with each class's current state and potential increase
        for (int[] c : classes) {
            double pass = c[0];
            double total = c[1];
            double increment = (pass + 1) / (total + 1) - pass / total;
            totalRatio += pass / total;
            maxHeap.offer(new double[] { pass, total, increment });
        }

        // Assign each extra student to the class with the highest potential increase
        for (int i = 0; i < extraStudents; i++) {
            double[] curr = maxHeap.poll();
            double pass = curr[0] + 1;
            double total = curr[1] + 1;
            double increment = (pass + 1) / (total + 1) - pass / total;
            totalRatio += curr[2];
            maxHeap.offer(new double[] { pass, total, increment });
        }

        return totalRatio / n;
    }
}