class palindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        } else {
            String num = Integer.toString(x);
            StringBuffer sb = new StringBuffer(num);
            String reversedNum = sb.reverse().toString();
            if (num.equals(reversedNum)) {
                return true;
            } else {
                return false;
            }
        }
    }
}