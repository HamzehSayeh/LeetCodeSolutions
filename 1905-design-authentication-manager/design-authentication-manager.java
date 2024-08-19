class AuthenticationManager {
    final int timeToLive;
    HashMap<String, Integer> tokens;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokens = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if(tokens.containsKey(tokenId))
        if (tokens.get(tokenId) > currentTime) {
            tokens.put(tokenId, currentTime + timeToLive);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count=0;
        for(int expiryTime: tokens.values()){
            if(expiryTime> currentTime)
            count++;
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */