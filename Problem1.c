/* Problem Statement:
Verified on leetcode

https://leetcode.com/problems/flood-fill/

200. Number of Islands

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3


 *
 * Time Complexity : O(r*c)
 * Space Complexity : O(r*c)
 */




#define MAX_QUEUE_SIZE 11000
#define ROW_COL 2
#define DIR_LEN 4

// A structure to represent a queue
typedef struct queue
{
    int front, rear, size;
    unsigned capacity;
    int** array;
}queue_t;

/**** Queue functions start ***/

queue_t* createqueue()
{
    queue_t* q = (queue_t*)calloc(1, sizeof(queue_t));
    q->array = (int **)calloc(MAX_QUEUE_SIZE, sizeof(int *));
    q->capacity = MAX_QUEUE_SIZE;
    q->front = q->size = 0; 
    q->rear = MAX_QUEUE_SIZE - 1;
    return q;
}
 
// queue is full when size becomes equal to the capacity 
int isFull(queue_t* queue)
{  return (queue->size == queue->capacity);  }
 
// queue is empty when size is 0
int isEmpty(queue_t* queue)
{  return (queue->size == 0); }
 
// Function to add an item to the queue.  It changes rear and size
void enqueue(queue_t* queue, int item_row, int item_col)
{
    int *item = NULL;
    if (isFull(queue)) {
        queue->array = (int **)realloc(queue->array, sizeof(int*) * (queue->size) * 2);
        queue->capacity = (queue->size) * 2;
    }
    /* store row and col */
    item = (int *)malloc(sizeof(int) * ROW_COL);
    if (!item) {
        return;
    }
    item[0] = item_row;
    item[1] = item_col;
    queue->rear = (queue->rear + 1) % queue->capacity;
    queue->array[queue->rear] = item;
    queue->size = queue->size + 1;
    //printf("%ld enqueued to queue\n", item->data);
}
 
// Function to remove an item from queue.  It changes front and size
int* dequeue(queue_t* queue)
{
    if (isEmpty(queue))
        return NULL;
    int *item = queue->array[queue->front];
    queue->front = (queue->front + 1) % queue->capacity;
    queue->size = queue->size - 1;
    return item;
}

void free_queue(queue_t* queue) {
    //printf("here\n");
    free(queue->array);
    free(queue);
}
/*
* Approach :
* Do BFS traversal and for each row,col in the matrix , keep track of all 1st being encountered. once 1s are finished.
* one island is found. keep on iterating unless the matrix is finished.
*/

int numIslands(char** grid, int gridSize, int* gridColSize){
    int island_cnt = 0;
    int *temp_item = NULL;
    queue_t *queue = NULL;
    int idx = 0, idx1 = 0;
    int dir = 0;
    int sr = 0, sc = 0;
    
    if (!gridSize) {
        return island_cnt;
    }
    /* for direction movement */
    int rowDir[] = {0,0,1,-1};
    int colDir[] = {1,-1,0,0};
    
    queue = createqueue();
    /* iterate over each land if not yet scanned */
    for (idx = 0; idx < gridSize; idx++) {
        for (idx1 = 0; idx1 < *gridColSize; idx1++) {
            if (grid[idx][idx1] != '5' && grid[idx][idx1] != '0') {
                enqueue(queue, idx, idx1);
                /* do the steps until queue becomes empty */
                while (!isEmpty(queue)) {
                    temp_item = dequeue(queue);
                    
                    for (dir = 0; dir < DIR_LEN; dir++) {
                        sr = temp_item[0] + rowDir[dir];
                        sc = temp_item[1] + colDir[dir];
                        if (sr >= 0 && sr < gridSize && sc >= 0 && sc < *gridColSize && grid[sr][sc] != '0' && grid[sr][sc] != '5') {
                            grid[sr][sc] = '5'; /* set to any random value for tracking purpose */
                            enqueue(queue,sr,sc);
                        }
                    }
                    
                    free(temp_item);
                }
                island_cnt++;
                
            }
        }
    }
    /* free queue and return final island count */
    free_queue(queue);
    return island_cnt;
}





/* Execute it on LeetCode platform*/

