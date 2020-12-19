public class Solution {
    public string DecodeString(string s) {
        if(s==null || s.Length==0)
        {
            return string.Empty;
        }
         Stack<int> numstack = new Stack<int>();
        Stack<StringBuilder> stringstack = new Stack<StringBuilder>();
        StringBuilder sb = new StringBuilder();
        int num=0;
        for(int i=0;i<s.Length;i++)
        {
            char c = s[i];
            if(Char.IsDigit(c))
            {
                num = (num * 10) + c -'0';
                Console.WriteLine(num);
            }
            else if( c== '[')
            {
                numstack.Push(num);
                stringstack.Push(sb);
                num =0;
                sb = new StringBuilder();
            }
            else if (c==']')
            {
                int times = numstack.Pop();
                Console.WriteLine(times);
                StringBuilder newsb = new StringBuilder();
                for(int l=0;l<times;l++)
                {
                    newsb.Append(sb);
                    Console.WriteLine(newsb.ToString());
                    
                }
                sb = stringstack.Pop().Append(newsb);
                
            }
            else
            {
                sb.Append(c);
