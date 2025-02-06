class Solution {

    public int updateGrid(int index1, int index2, int[][] grid) {
        int minValue = -1, fx = index1, fy = index2;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++ ) {
                if(grid[i][j] > 1) {
                    if(minValue == -1 ) {
                        minValue = Math.abs(i-index1)+Math.abs(j-index2);
                        fx = i;
                        fy = j;
                    }
                    else {
                        if(Math.abs(i-index1)+Math.abs(j-index2) < minValue ) {
                            minValue = Math.abs(i-index1)+Math.abs(j-index2);
                            fx = i;
                            fy = j;
                        }
                    }
                }
            }
        }
        grid[fx][fy] -= 1;
        return minValue;
    }
    
    public int minimumMoves(int[][] grid) {
        int count = 0;
        for(int index1 = 0; index1 < 3; index1++) {
            for(int index2 = 0; index2 < 3; index2++ ) {
                if(grid[index1][index2] > 1 ) {
                    //check left
                    if(index2-1 >= 0 && grid[index1][index2-1] == 0 && grid[index1][index2] > 1 ) {
                        grid[index1][index2] -= 1;
                        grid[index1][index2-1] = 1;
                        count++;
                    }
                    //check right
                    if(index2+1 < 3 && grid[index1][index2+1] == 0 && grid[index1][index2] > 1 ) {
                        grid[index1][index2] -= 1;
                        grid[index1][index2+1] = 1;
                        count++;
                    }
                    //check up
                    if(index1-1 >= 0 && grid[index1-1][index2] == 0 && grid[index1][index2] > 1 ) {
                        grid[index1][index2] -= 1;
                        grid[index1-1][index2] = 1;
                        count++;
                    }
                    //check down
                    if(index1+1 < 3 && grid[index1+1][index2] == 0 && grid[index1][index2] > 1 ) {
                        grid[index1][index2] -= 1;
                        grid[index1+1][index2] = 1;
                        count++;
                    }
                }
            }
        }
        for(int index1 = 0; index1 < 3; index1++ ) {
            for(int index2 = 0; index2 < 3; index2++ ) {
                if(grid[index1][index2] == 0 ) {
                    count += updateGrid(index1, index2, grid);
                }
            }
        }
        return count;
    }
}
