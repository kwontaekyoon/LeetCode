class Solution {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        val map = TreeMap<Int, String>()
        names.forEachIndexed {
            index, name -> map.put(heights[index], name)
        }
        return map.values.reversed().toTypedArray()
    }
}