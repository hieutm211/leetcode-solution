#1079. Letter Tile Possibilities
https://leetcode.com/problems/letter-tile-possibilities/

```go
func numTilePossibilities(tiles string) int {
    count := make([]byte, 26)
    
    for _, v := range tiles {
        count[v - 'A']++
    }
    
    N := len(tiles)
    return backtrack(0, &N, &count)
}

func backtrack(i int, N *int, count *[]byte) int {
    answer := 0
    
    if i == *N {
        return 0
    }
    for j := 0; j < len(*count); j++ {
        if (*count)[j] > 0 {
            answer++
            (*count)[j]--
            answer += backtrack(i+1, N, count)
            (*count)[j]++
        }
    }
    return answer
} 
```
