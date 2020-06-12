##338. Counting Bits
https://leetcode.com/problems/counting-bits/

Tag: Dynamic programming
```go
func countBits(num int) []int {
    f := make([]int, num+1, num+1)
    
    f[0] = 0
    pow2Next := 1; lastIndex := -1
    for i := 1; i <= num; i++ {
        if i == pow2Next {
            pow2Next *= 2
            lastIndex++
        }
        
        f[i] = f[i &^ (1<<lastIndex)] + 1
    }
    
    return f
}
```
