// Time complexity Of solution is 
// O(n*M) n : length od string , m: maxium repeatiation of stirng 
//

public class Solution {
    public string DecodeString(string s) {
        Stack<int> ints = new Stack<int>();
        Stack<StringBuilder> st = new Stack<StringBuilder>();
        StringBuilder currstr = new StringBuilder();
        int currnum = 0;

        for(int i=0;i<s.Length ; i++){

            char c = s[i];
            if(char.IsDigit(c)){
                currnum = currnum*10 + c - '0';
            }else if(c == '['){
                    ints.Push(currnum);
                    st.Push(currstr);
                    currstr = new StringBuilder();
                    currnum = 0 ;
            }else if(c == ']'){
                    int count = ints.Pop();
                    StringBuilder newstr = new StringBuilder();
                    for(int j = 0;j<count; j++){
                        newstr.Append(currstr);
                    }
                StringBuilder parent = st.Pop();
                parent.Append(newstr);
                   currstr = parent; 
                    
            }else {
                currstr.Append(c);
            }
        }
        return currstr.ToString();
    }
}