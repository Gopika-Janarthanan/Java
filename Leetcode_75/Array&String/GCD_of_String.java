class Solution {
    public String gcdOfStrings(String s1, String s2) {
        if (!(s1 + s2).equals(s2 + s1)) {
            return "";
        }
        int gcdLength = gcd(s1.length(), s2.length());
        return s1.substring(0, gcdLength);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
