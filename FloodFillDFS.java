//Time Complexity: O(m .n)
// Space Complexity: O(m .n) Space for recursion stack O(m.n)
import java.util.*;

class FloodFillDFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int x, int y, int originalColor, int newColor) {
        // Check bounds and color match
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != originalColor) {
            return;
        }

        // Change the color
        image[x][y] = newColor;

        // Move in all 4 directions
        dfs(image, x - 1, y, originalColor, newColor); // up
        dfs(image, x + 1, y, originalColor, newColor); // down
        dfs(image, x, y - 1, originalColor, newColor); // left
        dfs(image, x, y + 1, originalColor, newColor); // right
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;

        FloodFillDFS solver = new FloodFillDFS();
        int[][] result = solver.floodFill(image, sr, sc, color);

        System.out.println("Modified Image (DFS):");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}

