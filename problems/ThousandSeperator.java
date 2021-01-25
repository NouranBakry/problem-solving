class Solution {
    public String thousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        int temp = n;
        int divisionCount = 0;
        while (temp != 0) {
            builder.append(temp % 10);
            temp -= (temp % 10);
            temp /= 10;
            if (++divisionCount == 3 && temp != 0) {
                divisionCount = 0;
                builder.append(".");
            }
        }
        return builder.reverse().toString();
    }
}