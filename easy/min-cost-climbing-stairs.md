#746. Min Cost Climbing Stairs
https://leetcode.com/problems/min-cost-climbing-stairs/

Dynamic programming
f[0] = f[1] = 0
i >= 2: f[i] = max(f[i-1] + cost[i-1], f[i-2] + cost[i-2]) 


```go
func minCostClimbingStairs(cost []int) int {
    N := len(cost)
    if N < 2 {
        return 0
    }
    
    f, f1, f2 := 0, 0, 0
    for i := 2; i <= N; i++ {
        cost1 := f1 + cost[i-1]
        cost2 := f2 + cost[i-2]
        if cost1 < cost2 {
            f = cost1
        } else {
            f = cost2
        }
        f2 = f1
        f1 = f
    }

    return f
}
```
