class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int[] first = { Integer.parseInt(event1[0].substring(0, 2)) * 60 + Integer.parseInt(event1[0].substring(3)), Integer.parseInt(event1[1].substring(0, 2)) * 60 + Integer.parseInt(event1[1].substring(3)) };
        int[] second = { Integer.parseInt(event2[0].substring(0, 2)) * 60 + Integer.parseInt(event2[0].substring(3)), Integer.parseInt(event2[1].substring(0, 2)) * 60 + Integer.parseInt(event2[1].substring(3)) };
        if (first[1] < second[0] || second[1] < first[0]) {
            return false;
        } else {
            return true;
        }
    }
}