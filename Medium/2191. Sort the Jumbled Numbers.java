import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        final var list = new ArrayList<int[]>();
        for (int num : nums) {
            if (num == 0) {
                list.add(new int[] { 0, mapping[0] });
                continue;
            }
            int numToMap = num;
            int mappingNum = 0;
            for (int i = 1; numToMap > 0; i *= 10, numToMap /= 10) {
                mappingNum += mapping[numToMap % 10] * i;
            }
            list.add(new int[] { num, mappingNum });
        }
        Collections.sort(list, (x, y) -> Integer.compare(x[1], y[1]));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i)[1];
        }
        return nums;
    }
}