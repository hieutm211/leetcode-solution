##303. Range Sum Query - Immutable
https://leetcode.com/problems/range-sum-query-immutable/

Solution: Dynamic programming

F[i] = nums[0] + nums[1] + nums[2] + ... + nums[i]

Sum(i, j) 
  = F[j]            if i == 0
  = F[j] - F[i-1]   otherwise
  
```go
type NumArray struct {
    f []int
}


func Constructor(nums []int) NumArray {
    var NA NumArray
    
    N := len(nums)
    if N == 0 {
        return NA
    }
    
    NA.f = make([]int, N, N)
    NA.f[0] = nums[0]
    for i := 1; i < N; i++ {
        NA.f[i] = NA.f[i-1] + nums[i]
    }
    
    return NA
}


func (this *NumArray) SumRange(i int, j int) int {
    if len(this.f) == 0 {
        return 0
    }
    
    if i == 0 {
        return this.f[j]
    }
    return this.f[j] - this.f[i-1]
}


/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(i,j);
 */
```

Warning: array length = 0
