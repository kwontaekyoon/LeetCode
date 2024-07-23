class Solution {
    fun frequencySort(nums: IntArray): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEach { num -> 
            map[num] = map.getOrDefault(num, 0) + 1
        }
        return nums.asSequence()
            .sortedWith(compareBy({ map[it] }, { -it }))
            .toList()
            .toIntArray()
    }
}