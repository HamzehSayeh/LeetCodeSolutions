import java.util.Arrays;

class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int numberOfMatches = 0;

        Arrays.sort(players);
        Arrays.sort(trainers);

        for (int i = 0, j = 0; (i < players.length) && (j < trainers.length);) {
            if (players[i] <= trainers[j]) {
                numberOfMatches++;
                i++;
            }
            j++;
        }
        return numberOfMatches;
    }
}