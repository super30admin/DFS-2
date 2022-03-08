//Time Complexity: multiplication of numbers that are present in the string
//Space Complexity: multiplication of numbers that are present in the string
//didn't face any problems
//runs successfully

public class DecodeString394LeetCode {


        private int index = 0;                                  //maintaining the index of the string
        private String s;                                       //our string


        public String decodeString(String s) {

            this.s =s;
            index =0;                                         //initialize the index with zero
            return decodeString();                             //calling the recursive function
        }

        private String decodeString(){

            int num = 0;                                    //create and assign the num to 0
            String res = "";                                //creating the result string

            while(index<s.length()){                        //iterating till the last character of a string

                char ch = s.charAt(index);                  //getting the character one at a time

                if(Character.isDigit(ch)){                  //check if the character is digit or not
                    num = num*10 + (ch - '0');              //if digit then simple add to the num and increament the index
                    index++;
                }
                else if(ch == '['){                         //if character is [ then increament the index and calling the recursive function

                    index++;

                    String currStr = decodeString();        //function gives the internal result index

                    for(int j = 0; j<num ; j++){            //whichever string is, add to the num of times in result string
                        res += currStr;
                    }

                    num = 0;                                //and set num to zero for future recursive calls
                }
                else if(ch == ']'){                         //if character is ], then simply increament the counter and break out of the loop

                    index++;
                    break;
                }
                else{                                   //it means that we are getting character, so just simply add this character into result string and increament the index

                    res+= ch;
                    index++;

                }
            }
            return res;                             //returning the result string
        }






//     public String decodeString(String s) {

//         Stack<Character> stack= new Stack<>();
//         String decodeValue="";

//         for(int i=0; i<s.length(); i++){

//             char c = s.charAt(i);
//             //System.out.println(stack);

//             if(c == ']'){

//                 //getting string
//                 String currString = "";
//                 while(!stack.isEmpty() && stack.peek() != '['){

//                     currString = stack.pop() + currString;
//                     //System.out.println(stack);
//                 }

//                 //getting the number
//                stack.pop();

//                 String currNum = "";

//                 while(!stack.isEmpty() && Character.isDigit(stack.peek())){
//                     currNum = stack.pop() + currNum;
//                 }
//                 int num = Integer.parseInt(currNum);

//                 String decodedStr = "";

//                 //mutiply with number
//                 for(int j=0; j<num; j++){
//                     decodedStr += currString;
//                 }


//                 //push back into stack
//                 for(int j=0; j<decodedStr.length(); j++){
//                     stack.push(decodedStr.charAt(j));
//                 }

//             }
//             else{
//                 stack.push(c);
//             }
//         }



//         while(!stack.isEmpty()){
//             decodeValue = stack.pop()+decodeValue;
//         }
//         return decodeValue;

//     }

}
