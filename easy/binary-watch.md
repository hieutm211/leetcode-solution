#Binary Watch
https://leetcode.com/problems/binary-watch/

##Solution 1 - Backtrack

```go

func readBinaryWatch(num int) []string {
    x := make([]int, 10, 10)
    list := make([]string, 0)
    
    backtrack(0, x, num, &list)  
    
    return list
}

func backtrack(i int, x []int, num int, list *[]string) {
    if i == len(x) {
        if num != 0 {
            return
        }
        minute := 0
        pow := 1
        for j := 0; j < 6; j++ {
            minute += x[j] * pow
            pow *= 2
        }

        hour := 0
        pow = 1
        for j := 6; j < 10; j++ {
            hour += x[j] * pow
            pow *= 2
        }
        
        if hour < 12 && minute < 60 {
            *list = append(*list, fmt.Sprintf("%d:%02d", hour, minute))
        }

        return
    }
    x[i] = 0
    backtrack(i+1, x, num, list)
    x[i] = 1
    backtrack(i+1, x, num-1, list)
}
```

##Solution 2 - Bitwise
```go

func readBinaryWatch(num int) []string {
    list := make([]string, 0)
    
    for mask := 0; mask < 1024; mask++ {
        //count bits
        count := 0
    
        for i := 0; i < 10; i++ {
            if ((mask >> i) & 1) == 1 {
                count++
            }
        }
        
        if count == num {
            hour := (mask & (^63)) >> 6
            minute := mask & 63
            if hour < 12 && minute < 60 {
                list = append(list, fmt.Sprintf("%d:%02d", hour, minute))
            }
        }
    }
    
    return list
}
```
