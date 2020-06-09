#1286. Iterator for Combination
https://leetcode.com/problems/iterator-for-combination/

```go
type CombinationIterator struct {
    characters string
    current int
    comb []int
}


func Constructor(characters string, combinationLength int) CombinationIterator {
    var CI CombinationIterator
    CI.characters = characters
    CI.current = 0
    CI.comb = make([]int, 0)
    
    x := 0
    N := len(characters)
    backtrack(0, &N, &x, &combinationLength, &CI.comb)
    
    return CI
}


func (this *CombinationIterator) Next() string {
    result := make([]byte, 0, len(this.characters))
    
    for i := 0; i < len(this.characters); i++ {
        if ((this.comb[this.current] >> i) & 1) == 1 { //get ith bit
            result = append(result, this.characters[i])
        }
    }
    
    this.current++
    
    return string(result)
}


func (this *CombinationIterator) HasNext() bool {
    return this.current < len(this.comb)
}

func backtrack(i int, length *int, x *int, cLength *int, list *[]int) {
    if i == *length {
        *list = append(*list, *x)
        return
    }
    
    if *length-i == *cLength {
        *x = *x | (1<<i)
        *cLength--
        backtrack(i+1, length, x, cLength, list)
        *cLength++
        *x = *x & (^(1<<i))
    } else if *cLength == 0 {
        backtrack(i+1, length, x, cLength, list)
    } else {
        //ith bit = 1
        *x = *x | (1<<i)
        *cLength--
        backtrack(i+1, length, x, cLength, list)
        *cLength++
        *x = *x & (^(1<<i))

        //ith bit = 0
        backtrack(i+1, length, x, cLength, list)
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * obj := Constructor(characters, combinationLength);
 * param_1 := obj.Next();
 * param_2 := obj.HasNext();
 */
```
