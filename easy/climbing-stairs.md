#70. Climbing Stairs
https://leetcode.com/problems/climbing-stairs/

Solution: Dynamic programming
Gọi f[i] = số lách để leo lên bậc thứ i => Đáp án bài toán: F[n]
f[0] = 1
f[1] = 1
f[i] = f[i-1] + f[i-2]

Độ phức tạp: O(n) time, O(n) space

```go
func climbStairs(n int) int {
    f := make([]int, n+1, n+1)
    f[0], f[1] = 1, 1
    
    for i := 2; i <= n; i++ {
        f[i] = f[i-1] + f[i-2]
    }
    
    return f[n]
}
```

Cải tiến:
Nhận xét: tại bậc thứ i, ta chỉ cần quan tâm đến 3 giá trị: F[i], F[i-1], F[i-2], còn lại các giá trị trước đó đều là thừa, không cần thiết.
Vì vậy ta chỉ cần duy trì 3 biến f, f1, f2 thay cho f[i], f[i-1], f[i-2] để giải bài toán này

Độ phức tạp: O(n) time, O(1) space

```go
func climbStairs(n int) int {
    if n < 2 {
        return 1
    }
    
    f, f1, f2 := 0, 1, 1   
    for i := 2; i <= n; i++ {
        f = f1 + f2
        f2 = f1
        f1 = f
    }
    
    return f
}
```
