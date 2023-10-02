// class Solution {
//     private boolean simulator(String colors, boolean isAliceTurn) {
//         List<Integer> al = new ArrayList<>();
//         for (int i = 1; i < colors.length() - 1; i++) {
//             if (isAliceTurn) {
//                 if (colors.charAt(i) == 'A' && colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A') {
//                     al.add(i);
//                     if (simulator(new StringBuilder(colors).deleteCharAt(i).toString(), false)) {
//                         return true;
//                     }
//                 }
//             } else {
//                 if (colors.charAt(i) == 'B' && colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B') {
//                     al.add(i);
//                     if (!simulator(new StringBuilder(colors).deleteCharAt(i).toString(), true)) {
//                         return false;
//                     }
//                 }
//             }  
//         }
//         for (int i : al) {
//             return simulator(new StringBuilder(colors).deleteCharAt(i).toString(), !isAliceTurn);
//         }
//         return !isAliceTurn;
//     }
//     public boolean winnerOfGame(String colors) {
//         return simulator(colors, true);
//     }
// }

class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = 0, bob = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            char prev = colors.charAt(i - 1);
            char now = colors.charAt(i);
            char next = colors.charAt(i + 1);
            if (prev == 'A' && now == 'A' && next == 'A') {
                alice++;
            } else if (prev == 'B' && now == 'B' && next == 'B') {
                bob++;
            }
        }
        return alice > bob;
    }
}