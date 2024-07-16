class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxNumberOfCandies=candies[0];
        int numberOfKids=candies.length;
        ArrayList<Boolean> result=new ArrayList<>();
        for(int i=1;i<numberOfKids;i++){
            if(candies[i]>maxNumberOfCandies)
                maxNumberOfCandies=candies[i];
        }
        for(int i=0;i<numberOfKids;i++){
            if(candies[i]+extraCandies>=maxNumberOfCandies)
            result.add(i,true);
            else
            result.add(i,false);
        }
        return result;
    }
}