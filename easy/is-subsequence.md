#392. Is Subsequence
https://leetcode.com/problems/is-subsequence/

Solution 1: dynamic programming
Find the length L of the longest common subsequence of s and t
if L == length(s) then s is subsequence of t

```go
func isSubsequence(s string, t string) bool {
    m := len(s)
    n := len(t)
    
    if m > n {
        return false
    }
    if m == 0 {
        return true
    }
    
    f := make([][]int, m, m)
    
    for i := 0; i < m; i++ {
        f[i] = make([]int, n, n)
        
        for j := 0; j < n; j++ {
            if s[i] == t[j] {
                if i == 0 || j == 0 {
                    f[i][j] = 1
                } else {
                    f[i][j] = f[i-1][j-1] + 1
                }
            } else {
                if i > 0 {
                    f[i][j] = f[i-1][j]
                }
                if j > 0 && f[i][j] < f[i][j-1] {
                    f[i][j] = f[i][j-1]
                }
            }
        }
    }
    
    return f[m-1][n-1] == m
}
```

Solution 2: bruteforces

Tìm lần lượt các phần tử của xâu s trong xâu t, sau mỗi phần tử tìm được, xóa đi của xâu t đoạn từ đầu cho đến kí tự vừa tìm được

```go
func isSubsequence(s string, t string) bool {
    for _, c := range s {
        idx := strings.IndexRune(t, c)
        if idx == -1 {
            return false
        }
        t = t[idx+1:]
    }
    return true
}
```
