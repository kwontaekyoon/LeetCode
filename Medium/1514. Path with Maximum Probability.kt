data class Point(val node: Int, val prob: Double)

class Solution {
    fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, startNode: Int, endNode: Int): Double {
        val map = Array<MutableList<Point>>(n) { mutableListOf() }
        for (i in edges.indices) {
            val (a, b) = edges[i]
            map[a].add(Point(b, succProb[i]))
            map[b].add(Point(a, succProb[i]))
        }

        val dists = DoubleArray(n) { 0.0 }
        dists[startNode] = 1.0

        val maxHeap = PriorityQueue<Point>(compareByDescending { it.prob })
        maxHeap.offer(Point(startNode, 1.0))

        while (maxHeap.isNotEmpty()) {
            val (currNode, currProb) = maxHeap.poll()
            if (currNode == endNode) {
                return currProb
            }
            for ((nextNode, nextProb) in map[currNode]) {
                val newProb = currProb * nextProb
                if (newProb > dists[nextNode]) {
                    dists[nextNode] = newProb
                    maxHeap.offer(Point(nextNode, newProb))
                }
            }
        }

        return 0.0
    }
}