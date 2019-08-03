//idea: iterate over array of input and check for 1 and it's neighboring 1,increment counter.  If neighboring element is 1 make it 0.
//after we found 1, call recursive function to check for neighboring element of 1  
//time complexity is o(row*col)
//space complexity:its recursive so o(row*col)
//run on leetcode:yes
//no problem faced.
public class NoOfIlands {
	
	     //main function
		  public int numIslands(char[][] arr) {
		     	int count = 0;
		     	
		     	//iterate over entire array
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[0].length; j++) {
						//check for 1 and increment counter and call recursively helper function to check its neighbour
						if (arr[i][j] == '1') {
							count++;
							funcall(arr, i, j);
						}
					}
				}

				return count;
			}

		  //helper function to check neighbouring element of 1 and once we found 1 then make it 0 to avoid repetition of counting
			private static void funcall(char[][] arr, int i, int j) {

				if (i >= arr.length || i < 0 || j >= arr[0].length || j < 0 || arr[i][j] == '0') {
					return;
				}
				arr[i][j] = '0';
				funcall(arr, i + 1, j);
				funcall(arr, i - 1, j);
				funcall(arr, i, j + 1);
				funcall(arr, i, j - 1);

			}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
