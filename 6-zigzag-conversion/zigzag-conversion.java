class Solution {
    public String convert(String s, int numRows) {
        int characterCount = 0;
        char[][] zigzagString = new char[numRows][500];
        int row = 0;
        int column = 0;
        StringBuilder result = new StringBuilder();

        if (numRows < 2) {
            return s;
        }

        while (characterCount < s.length()) {
            for (; row < numRows && characterCount < s.length(); row++, characterCount++) {
                zigzagString[row][column] = s.charAt(characterCount);
            }
            column++;
            for (row = numRows - 2; row >= 0 && characterCount < s.length(); row--, column++, characterCount++) {
                zigzagString[row][column] = s.charAt(characterCount);
            }
            row += 2;
            column--;
        }

        characterCount = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < zigzagString[i].length; j++, characterCount++) {
                if (zigzagString[i][j] != '\0') {
                    result.append(zigzagString[i][j]);
                }
            }
        }
        return result.toString();
    }
}