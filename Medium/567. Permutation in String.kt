class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) {
            return false
        }
        val cnt1 = IntArray(26)
        val cnt2 = IntArray(26)
        for (i in s1.indices) {
            cnt1[s1[i] - 'a']++
            cnt2[s2[i] - 'a']++
        }
        if (cnt1.contentEquals(cnt2)) {
            return true
        }
        for (i in s1.length until s2.length) {
            cnt2[s2[i] - 'a']++
            cnt2[s2[i - s1.length] - 'a']--
            if (cnt1.contentEquals(cnt2)) {
                return true
            }
        }
        return false
    }
}