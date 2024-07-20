class Solution {
    public String convert(String s, int numRows) {
        int characterCount = 0;
        int length = s.length();

        if (numRows < 2) {
            return s;
        }

        int cycleLength = numRows + numRows - 2;
        int fullCycles = length / cycleLength;
        int remainder = length % cycleLength;

        int numColumns = fullCycles * (numRows - 1);
        if (remainder > 0) {
            if (remainder <= numRows) {
                numColumns += 1;
            } else {
                numColumns += 1 + (remainder - numRows);
            }
        }
        char[][] zigzagString = new char[numRows][numColumns];
        int row = 0;
        int column = 0;
        StringBuilder result = new StringBuilder();

        if (numRows < 2) {
            return s;
        }

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

        characterCount = 0;
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < zigzagString[i].length; j++, characterCount++) {
                if (zigzagString[i][j] != '\0')
                    result.append(zigzagString[i][j]);
            }

        return result.toString();
    }
}