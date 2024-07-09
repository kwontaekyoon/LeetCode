class Solution {
    public double averageWaitingTime(int[][] customers) {
        int finishTime = 0;
        var waitingTimeSum = 0.0;
        for (var customer : customers) {
            finishTime = Math.max(finishTime, customer[0]) + customer[1];
            waitingTimeSum += finishTime - customer[0];

        }
        return waitingTimeSum / customers.length;
    }
}