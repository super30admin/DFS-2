// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

func decodeString(s string) string {
    if len(s) == 0{
        return ""
    }
    
    num:= 0
    currString := ""
    
    strstack := []string{}
    numsstack := []int{}
    
    for _,c := range s{
        if c >= '0' && c <= '9'{
            num = num*10 + int(c - '0')
        }else if c == '['{
            numsstack = append(numsstack,num)
            strstack = append(strstack,currString)
            num = 0
            currString = ""
        }else if c == ']'{
            times:= numsstack[len(numsstack)-1]
            numsstack = numsstack[:len(numsstack)-1]
            newstring := ""
            for i:=0;i<times;i++{
                   newstring += currString 
            }
            currString = strstack[len(strstack)-1] + newstring
            strstack = strstack[:len(strstack)-1]
            
        }else{
            currString = currString + string(c)
        }
    }
    
    return currString
}

//Recursive
var i int 

func decodeString(s string) string {
    if len(s) == 0{
        return ""
    }
    
    i = 0
    
    return dfs(s)

}

func dfs(s string) string {
    num:= 0
    currString := ""
    
    for i< len(s){
        c := s[i]
        if c >= '0' && c <= '9'{
            num = num*10 + int(c - '0')
            i++
        }else if c == '['{
            i++
            decodestring := dfs(s)
            newstring := ""
            for j:=0;j<num;j++{
                newstring+=decodestring
            }
            currString = currString + newstring
            num = 0
            
        }else if c == ']'{
            i++
            return currString
            
        }else{
            currString = currString + string(c)
            i++
        }
    }
    
    return currString
}
