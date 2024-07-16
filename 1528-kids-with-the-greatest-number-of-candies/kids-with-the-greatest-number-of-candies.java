class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxNumberOfCandies=candies[0];
        int numberOfKids=candies.length;
        ArrayList<Boolean> result=new ArrayList<>();
        for(int i=1;i<numberOfKids;i++){
            if(candies[i]>maxNumberOfCandies)
                maxNumberOfCandies=candies[i];
        }
        for(int candy:candies){
            if(candy+extraCandies>=maxNumberOfCandies)
            result.add(true);
            else
            result.add(false);
        }
        return result;
    }
}