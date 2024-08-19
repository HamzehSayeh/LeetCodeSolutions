class Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int columns = img[0].length;
        int[][] result = new int[rows][columns];
        int[] shifts = { -1, 0, 1 };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int sum = 0;
                int numberOfCells = 0;

                for (int iShift : shifts) {
                    for (int jShift : shifts) {
                        int iPosition = i + iShift;
                        int jPosition = j + jShift;
                        if (iPosition >= 0 && iPosition < rows && jPosition >= 0 && jPosition < columns) {
                            sum += img[iPosition][jPosition];
                            numberOfCells++;
                        }
                    }
                }
                result[i][j] = sum / numberOfCells;
            }
        }
        return result;

    }
}