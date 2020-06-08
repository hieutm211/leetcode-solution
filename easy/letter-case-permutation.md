##Letter Case Permutation
https://leetcode.com/problems/letter-case-permutation/

```go
import "unicode"

func letterCasePermutation(S string) []string {
    mp := getLetterIndexes(S)
    list := make([]string, 0)
    x := make([]int, len(mp))
    
    backtrack(0, x, len(mp), S, mp, &list)
    
    return list
}

func getLetterIndexes(S string) []int {
    mp := make([]int, 0, len(S))
    
    for i := 0; i < len(S); i++ {
        if unicode.IsLetter(rune(S[i])) {
            mp = append(mp, i)
        }    
    }
    return mp
}

func backtrack(i int, x []int, N int, S string, mp []int, list *[]string) {
    if i == N {
        *list = append(*list, transform(S, x, mp))
        return
    }
    x[i] = 0
    backtrack(i+1, x, N, S, mp, list)
    x[i] = 1
    backtrack(i+1, x, N, S, mp, list)
}

func transform(S string, x []int, mp []int) string {
    answer := []rune(S)
    
    for i := 0; i < len(x); i++ {
        if x[i] == 1 {
            if unicode.IsLower(answer[mp[i]]) {
                answer[mp[i]] = unicode.ToUpper(answer[mp[i]])
            } else {
                answer[mp[i]] = unicode.ToLower(answer[mp[i]])
            }
        }
    }   
    return string(answer)
}
```
