/* Problem Statement:
Verified on leetcode

https://leetcode.com/problems/decode-string/

394 Decoded string

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".


 *
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */




#define MAX_STACK_SIZE 11000
#define ITEM_SIZE 3
#define ROW_COL_DIR 4

typedef struct stack {
    int top;
    int capacity;
    char *elem;
}stack_t;

stack_t* createStack()
{
    stack_t* st = (stack_t*)calloc(1, sizeof(stack_t));
    st->capacity = MAX_STACK_SIZE;
    st->top = -1;
    st->elem = malloc(MAX_STACK_SIZE * sizeof(char));
    return st;
}
// stack is full when size becomes equal to the capacity 
int isStackFull(stack_t* st)
{  return (st->top == st->capacity - 1);  }
 
// stack is empty when size is 0
int isStackEmpty(stack_t* st)
{  return (st->top == -1); 

}

char peek(stack_t *st) {
    if (st->top == -1) {
        return 'v';
    } else {
        return st->elem[st->top];
    }
}
void push(stack_t *st, char item) {
    
    if (isStackFull(st)) {
        printf("No space in stack\n");
        return;
    }

    st->elem[++st->top] = item;
    //printf(" Tnode item with val %ld added to stack.\n", item->data);
}

char pop(stack_t *st) {
    char item;
    if (isStackEmpty(st)) {
        //printf("No elements to delete in stack\n");
        return 'v';
    }
    item = st->elem[st->top--];
    //printf(" Tnode item with val %ld popped out of stack.\n", item->data);
    return item;
}

char* push_string(char *src_str, int *curr_src_len, int str_len) {
    int digit = 0;
    int counter = 0;
    char *start_ptr = NULL;
    char *end_ptr = NULL;
    char *next_str = NULL;
    char *curr_str = NULL;
    int curr_len = 0;
    
    /* temporary memory allocation string for output */
    curr_str = calloc(10000, 1);
    
    /* Keep on doing it unless we parse the complete string */
    while (*curr_src_len < str_len) {
        printf("print: %d, ", *curr_src_len);
        printf("%c\n", src_str[*curr_src_len]);
        
        /* case 1 : process digit */
        if (isdigit(src_str[*curr_src_len])) {
            digit = digit*10 + (src_str[*curr_src_len] - '0');
        } else if (src_str[*curr_src_len] == '[') {
            /* case 2: skip start bracket and call the function again */
            (*curr_src_len)++;

            next_str = push_string(src_str, curr_src_len, str_len);
            if (next_str) {
                for (counter = 0; counter < digit; counter++) {
                    strncat(curr_str + curr_len, next_str, strlen(next_str));
                    curr_len = strlen(curr_str);                  
                }
                free(next_str);
            }
            digit = 0;
        } else if (src_str[*curr_src_len] == ']'){
            /* case 3: end bracket, so end from here .*/
            return curr_str;
        } else {
            /* case 4: char strings need to be copied to output array */
            curr_str[curr_len] = src_str[*curr_src_len];
            curr_len++;
        }
        (*curr_src_len)++;
    }
    return curr_str;
}

char * decodeString(char * s){
    char *output = NULL;
    int total_len = 0;
    int curr_len = 0;
    
    /* corner case handling */
    if (!s) {
        return output;
    }
    if (!strlen(s)) {
        return "";
    }
    /* total len of src string */
    total_len = strlen(s);
    
    output = push_string(s, &curr_len,total_len);

    return output;
}





/* Execute it on LeetCode platform*/

