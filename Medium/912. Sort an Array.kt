class Solution {
    fun sortArray(nums: IntArray): IntArray {
        val cnt = IntArray(100001)
        nums.forEach {
            num -> cnt[num + 50000] += 1;
        }
        var i = 0
        var j = 0
        cnt.forEachIndexed { idx, cnt ->
            j = i + cnt
            for (k in i..j - 1) {
                nums[k] = idx - 50000
            }
            i = j
        }
        return nums
    }
}