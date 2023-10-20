//Decode String
//TC: o(n)
//SC: O(n)
class Solution1 {
    public String decodeString(String s) {
        Stack<Integer> noStk=new Stack<>();
        Stack<StringBuilder> strStk=new Stack<>();

        StringBuilder currStr=new StringBuilder();
        int currNum=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                currNum=currNum*10 + c-'0';//int value of char c
                //this step can detect 2,3 ...digits no as well
            }
            else if(c=='[')
            {
                noStk.push(currNum);
                strStk.push(currStr);
                currStr=new StringBuilder(); //initialize it again
                currNum=0; //same

            }
            else if(c==']')
            {
                int count=noStk.pop();//get counter 
                StringBuilder baby=new StringBuilder();
                for(int j=0;j<count;j++)
                {
                    baby.append(currStr); //repeat currStr that noof times
                }
                StringBuilder parent=strStk.pop();
                currStr=parent.append(baby);
            }
             else //if alphabet
            {
                currStr.append(c);
            }
        }
      return currStr.toString();  
    }
}