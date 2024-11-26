//Time Complexity: O(m .n) Each pixel is visites once so total number of cells for mtrix of m*n is mn
// Space Complexity: O(m .n) overall space is Space of the queue is O(m.n)
import java.util.*;
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) return image;

        int rows = image.length;
        int cols = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            // Change the color
            image[x][y] = color;

            // Check and add all valid neighbors
            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && image[newX][newY] == originalColor) {
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;

        FloodFill solver = new FloodFill();
        int[][] result = solver.floodFill(image, sr, sc, color);

        System.out.println("Modified Image (BFS):");
        for (int[] row : result) {
        System.out.println(Arrays.toString(row));
        }
    }
}

