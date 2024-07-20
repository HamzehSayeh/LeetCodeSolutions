class Solution {
    public String convert(String s, int numRows) {
        int characterCount = 0;
        int length = s.length();
        char[][] zigzagString = new char[numRows][1000];
        int row = 0;
        int column = 0;
        StringBuilder result = new StringBuilder();

        if (numRows < 2) {
            for (int i = 0; i < s.length(); i++, characterCount++) {
                result.append(s.charAt(characterCount));
            }
        }

        else {
            while (characterCount < length) {
                for (; row < numRows && characterCount < length; row++, characterCount++) {
                    zigzagString[row][column] = s.charAt(characterCount);
                }
                row -= 2;
                column++;
                for (; row >= 0 && characterCount < length; row--, column++, characterCount++) {
                    zigzagString[row][column] = s.charAt(characterCount);
                }
                row += 2;
                column--;
            }
        }
        characterCount = 0;
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < zigzagString[i].length; j++, characterCount++) {
                if (zigzagString[i][j] != '\0')
                    result.append(zigzagString[i][j]);
            }

        return result.toString();
    }
}