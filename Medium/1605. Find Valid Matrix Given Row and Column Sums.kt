class Solution {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val R = rowSum.size
        val C = colSum.size
        val matrix = Array(R) { IntArray(C) }
        var r = 0
        var c = 0
        while (r < R && c < C) {
            if (rowSum[r] < colSum[c]) {
                matrix[r][c] = rowSum[r]
                colSum[c] -= rowSum[r]
                rowSum[r] = 0
                r++
            } else {
                matrix[r][c] = colSum[c]
                rowSum[r] -= colSum[c]
                colSum[c] = 0
                c++
            }
        }
        return matrix
    }
}