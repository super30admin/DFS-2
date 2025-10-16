// Time complexity - O(m*n),m = number of rows, n = number of columns
// Space complexity - O(min(m,n))
function numIslands(grid: string[][]): number {
	let count = 0;
	let m = grid.length;
	let n = grid[0].length;
	const dirs = [
		[0, 1],
		[0, -1],
		[1, 0],
		[-1, 0],
	];

	for (let i = 0; i < m; i++) {
		for (let j = 0; j < n; j++) {
			// if we find a 1, do BFS and make nearest 1s to 0s and mark as visited to avoid overcount
			if (grid[i][j] == "1") {
				count++;
				grid[i][j] = "0";

				let q = [[i, j]];
				while (q.length > 0) {
					const [r, c] = q.pop();

					// look for neighbours and mark them as 0
					// look for if the neighbours have any 1s in next level
					for (let [x, y] of dirs) {
						let nr = x + r;
						let nc = y + c;

						if (
							nr >= 0 &&
							nc >= 0 &&
							nr < m &&
							nc < n &&
							grid[nr][nc] == "1"
						) {
							grid[nr][nc] = "0";
							q.push([nr, nc]);
						}
					}
				}
			}
		}
	}
	return count;
}
