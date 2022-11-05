// Approach : DFS. Read the string letter by letter and process. We initially need to solve the inner problem and then use that along with frequency to solve outer problem.
// Time Complexity : O(p * l) where l is the average length of the subproblem string and p is the product of all the numbers at each nested level of the encoded string
// Space Complexity : O(p*l)

public class Solution {
    int index;
    public string DecodeString(string s) {
        index = 0;
        return decodeRec(s).ToString();
    }
    
    public StringBuilder decodeRec(string s){
        StringBuilder res = new StringBuilder();
        // sample encoded string : aa35[ab]cc45[bd]
        int num = 0;
        
        while(index < s.Length){
            
            if(s[index]>='0' && s[index]<='9'){
                num = num*10 + (s[index]-'0');
            }else if(s[index] == '['){
                index++;
                StringBuilder subResult = decodeRec(s);
                
                while(num >0){
                    res.Append(subResult);
                    num--;
                }
            }else if(s[index] == ']'){
                return res;
            }else{
                res.Append(s[index]);
            }
            
            index++;
        }
        
        return res;
    }
}