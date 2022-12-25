// Time Complexity : O(decoded_string)
// Space Complexity :O(decoded_string)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach\
class Solution {
    //Time O(decoded_String)
    // Space O(decodedString)
    public String decodeString(String s) {
    /*
    When we scan the String one by one, we can can get these types of elements:

    1) Char 
    concatenate the char with the current string 
    2) Integer
    currentInt = currentInt * 10 + i
    3) Opening Brace '['
    Since this would be the child, we would put the parent in the stack and go on processing the child
    stringStack.push(currenString)
    integerStack.push(currentINt)
    4) Closing Brace ']'
    We will pop from the inte stack , repeat the current string that many times
    we then will pop form string strack and concatenate with it
    */
    StringBuilder currStr = new StringBuilder();
    int currInt = 0;

    Stack<Integer> intStack = new Stack<Integer>();
    Stack<StringBuilder> strStack = new Stack<StringBuilder>();

    for(int i=0;i<s.length();i++){

    //1) Char
    if(Character.isLetter(s.charAt(i))){
    currStr.append(s.charAt(i)); // appending char with currentSTring
    }
    //2) Integer
    else if(Character.isDigit(s.charAt(i))){
    currInt = currInt * 10 + Character.getNumericValue(s.charAt(i)); // to get the complete numbers , we would multiple with prev one e.g 12 , prev 1 * 10 + 2 ==>12
    }
    //3) Opening Brace
    else if(s.charAt(i) == '['){
        // Push parent inside the stack 
        intStack.push(currInt);
        strStack.push(currStr);
        // resetting values to process the childs now
        currStr = new StringBuilder();
        currInt = 0;

    }
    //4)Closing Brace
    else{
        // we need to repeat the current String with count many times and then concat with parent
        int count = intStack.pop();
        StringBuilder cs = new StringBuilder(currStr);// need a new ref to prevent duplication
        for(int c=1;c<count;c++){ // Staring c from 1 becasue the string is already repeated 1 time in parent , so that is why
            currStr.append(cs);
        }

        // now concat with parent
        StringBuilder parent = strStack.pop();
        currStr = parent.append(currStr);
    
    }

    }
       return currStr.toString(); 
    }
}