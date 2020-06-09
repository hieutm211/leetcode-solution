##1415. The k-th Lexicographical String of All Happy Strings of Length n
https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

Solution: backtracking

```go
func getHappyString(n int, k int) string {
    x := make([]int, n, n)
    
    backtrack(0, &x, &k)
    
    answer := ""
    for _, v := range x {
        var c byte
        
        if v == 0 { 
            c = 'a' 
        } else if v == 1 { 
            c = 'b' 
        } else if v == 2 { 
            c = 'c' 
        }
        
        answer += string(c)
    }
    
    if k != 0 {
        return ""
    }
    
    return answer
}

func backtrack(i int, x *[]int, k *int) {
    if i == len(*x) {
        *k--
        return
    }
    for j := 0; j < 3; j++ {
        if (*k > 0) && (i == 0 || j != (*x)[i-1]) {
            (*x)[i] = j
            backtrack(i+1, x, k)
        }
    }
}
```
