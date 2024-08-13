class Solution {
    val ans = mutableListOf<List<Int>>()

    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        backtrack(candidates, target, 0, mutableListOf())
        return ans
    }

    fun backtrack(
        candidates: IntArray,
        remain: Int,
        start: Int,
        combination: MutableList<Int>
        ) {
            if (remain == 0) {
                ans.add(ArrayList(combination))
                return
            }

            for (i in start until candidates.size) {
                if (i > start && candidates[i] == candidates[i - 1])
                    continue
                if (candidates[i] > remain)
                    break
                
                combination.add(candidates[i])
                backtrack(candidates, remain - candidates[i], i + 1, combination)
                combination.removeAt(combination.size - 1)
            }
        }
}