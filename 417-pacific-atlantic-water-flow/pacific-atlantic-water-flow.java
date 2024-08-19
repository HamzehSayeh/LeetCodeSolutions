class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0)
            return result;
        int rows = heights.length;
        int columns = heights[0].length;
        boolean[][] pacific = new boolean[rows][columns];
        boolean[][] atlantic = new boolean[rows][columns];

        for(int i =0;i<rows;i++){
            DFS(heights,pacific,i,0);
            DFS(heights,atlantic,i,columns-1);
        }

        for(int j=0;j<columns;j++){
            DFS(heights,pacific,0,j);
            DFS(heights,atlantic,rows-1,j);
        }

        for(int i=0;i<rows;i++)
        for(int j=0;j<columns;j++){
            if(pacific[i][j] && atlantic[i][j]){
                List<Integer> list=new ArrayList<>();
                list.add(i);
                list.add(j);
                result.add(list);            }
        }
        return result;

    }
    public void DFS(int[][] heights,boolean[][] visited,int i,int j){
        visited[i][j]=true;
        int[][] directions={{-1,0},{1,0},{0,1},{0,-1}};

        for(int[]direction: directions){
            int x=i+direction[0];
            int y=j+direction[1];
            if(x>=0 && x<heights.length && y>=0 && y<heights[0].length && !visited[x][y] && heights[x][y]>= heights[i][j])
            DFS(heights,visited,x,y);
        }
    }
}