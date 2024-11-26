// Time Complexity: Each cell is processed once when it ie dequed So O(m.n)
// Space complexity:  O(m.n) Queue can store upto O(m.n) in worst case 
import java.util.*;

class NearestZeroBFS {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all '0' cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE; // Placeholder for unvisited '1' cells
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : directions) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && mat[newX][newY] > mat[x][y] + 1) {
                    mat[newX][newY] = mat[x][y] + 1; // Update distance
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        NearestZeroBFS solver = new NearestZeroBFS();
        int[][] result = solver.updateMatrix(mat);

        System.out.println("Updated Matrix (BFS):");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
