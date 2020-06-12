##198. House Robber
https://leetcode.com/problems/house-robber/

Solution:

F[i] = maximum amount of money you can rob from house 0 to house i
F[0] = nums[0]
F[1] = max(F[0], nums[1])
F[i] = max(F[i-1], f[i-2] + nums[i])

O(N) time, O(N) space

```go
func rob(nums []int) int {
    N := len(nums)
    if N == 0 {
        return 0
    }
    if N == 1 {
        return nums[0]
    }
    
    f := make([]int, N, N)
    f[0] = nums[0]
    f[1] = max(f[0], nums[1])
    for i := 2; i < N; i++ {
        f[i] = max(f[i-1], f[i-2] + nums[i])
    }
    return f[N-1]
}

func max(a, b int) int {
    if a >= b {
        return a
    }
    return b
}
```

Cải tiến:

Tại mỗi  i, ta chỉ cần quan tâm đến F[i-2], F[i-1], F[i]
những F truớc đó sẽ bị thừa
Do đó ta chỉ cần duy trì 3 biến f2, f1, f để giải bài này

```go
func rob(nums []int) int {
    N := len(nums)
    if N == 0 {
        return 0
    }
    if N == 1 {
        return nums[0]
    }
    
    f2 := nums[0]
    f1 := max(f2, nums[1])
    f := max(f1, f2)

    for i := 2; i < N; i++ {
        f = max(f1, f2 + nums[i])
        f2 = f1
        f1 = f
    }
    return f
}

func max(a, b int) int {
    if a >= b {
        return a
    }
    return b
}
```
