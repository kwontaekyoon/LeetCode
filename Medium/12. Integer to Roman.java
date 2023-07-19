class Solution {
    public void initMap(Map hm) {
        hm.put(1000, "M");
        hm.put(900, "CM");
        hm.put(500, "D");
        hm.put(400, "CD");
        hm.put(100, "C");
        hm.put(90, "XC");
        hm.put(50, "L");
        hm.put(40, "XL");
        hm.put(10, "X");
        hm.put(9, "IX");
        hm.put(5, "V");
        hm.put(4, "IV");
        hm.put(1, "I");
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, String> valToSymbol = new HashMap<>();
        initMap(valToSymbol);
        int[] vals = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        for (int val : vals) {
            int cnt = num / val;
            num = num - (num / val) * val;
            for (int i = 0; i < cnt; i++) {
                sb.append(valToSymbol.get(val));
            }
        }
        return sb.toString();
    }

}