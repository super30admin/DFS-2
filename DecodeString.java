
//creating stack by self approach

//we have 4 types of characters here digit, char, [, ], we will take 2 stack int stack and char stack,
//2 variables curr int, curr string. start traversing the string we find a number put it in curr int as curr num *10
//+ curr int, find char append it in curr string. now when we find [  we need parants in stack put curr num and curr string
//inside the string and num stack and reinitialize curr num and curr string, when we hit ], pop top int stack elemet 
//multiple curr string that many times, append result string to top popped string stack element, and make it as 
// curr string. 


// class Solution {
//     public String decodeString(String s) {

//         int currNum = 0;
//         StringBuilder currStr = new StringBuilder();
//         Stack<Integer> numSt = new Stack<>();
//         Stack<StringBuilder> strSt = new Stack<>();

//         for(int i = 0; i < s.length(); i++){//TC-O(n)
//             char c = s.charAt(i);
//             if(Character.isDigit(c)){//take digit in currnum
//                 currNum = 10 * currNum + c - '0';

//             }
//             else if(c == '['){//push currnum , curr str in stacks, and initialise currnum and currstr
//                 numSt.push(currNum);
//                 strSt.push(currStr);
//                 currNum = 0;
//                 currStr = new StringBuilder();

//             }else if(c == ']'){// pop numst, append currstr that many time, append poped strst as parent to that, set curr str as parent
//                 int cnt = numSt.pop();
//                 StringBuilder baby = new StringBuilder();
//                 for(int k = 0; k<cnt; k++){//TC-O(all digit multiplication) final tC- max of k(all digit multiplication) * ave len of string
//                 //sc will same as tc
//                     baby.append(currStr);
//                     //currStr.append(currStr);//will not work , a ->aa -> aaaa->aaaaaaaa but we want aaa
//                 }
//                 StringBuilder parent = strSt.pop();// if we declare parent before k loop we can directly append currstr to parent cnt times 
//                 parent.append(baby);
//                 currStr = parent;

//             }else{
//                 currStr.append(c);
//             }
//         }

//         return currStr.toString();
        
//     }
// }


//using recurssion
//tc- k*l, sc- k*l
class Solution {
    int i = 0;
    public String decodeString(String s) {

        int currNum = 0;
        StringBuilder currStr = new StringBuilder();
    

       while(i<s.length()){
            char c = s.charAt(i);
            i++;
            if(Character.isDigit(c)){
                currNum = 10 * currNum + c - '0';

            }
            else if(c == '['){
             String baby = decodeString(s);
             
              for(int k = 0; k<currNum; k++){
                  currStr.append(baby);
                    
                }
                   currNum = 0;

            }else if(c == ']'){
                return currStr.toString();

            }else{
                currStr.append(c);
            }
        }

        return currStr.toString();
        
    }
}

