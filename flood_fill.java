// Time Complexity : O(m *n) (if all have same color)
// Space Complexity : O(1) // no extra space used.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
                          
        // apply dfs for all the same Color and update to new color
        int color = image[sr][sc];
        
        // No need to modify anything as color and newcolor are same
        if (color == newColor){
            return image;
        }
                    
        // Traverse through the neighbours if they are connected with the same color
        dfs(image, sr, sc, color, newColor);
             
        // Modified image returned
        return image;
        
    }  
    private void dfs(int[][] image, int i, int j , int color, int newColor){

        // Edge cases and the color is mismatched : Do nothing
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != color){
            return;
        }


        // mark it as visited 
        image[i][j] = newColor;


        // Traverse 4- directionally
         dfs(image, i + 1, j, color, newColor);
         dfs(image, i - 1, j, color, newColor);
         dfs(image, i, j - 1, color, newColor);
         dfs(image, i, j + 1, color, newColor);

    }
   
}