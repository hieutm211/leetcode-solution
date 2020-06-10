#1025. Divisor Game
https://leetcode.com/problems/divisor-game/

Tag: dynamic programming

```go
func divisorGame(N int) bool {
    f := make([]bool, N+1, N+1)

    f[1] = false
    for i := 2; i <= N; i++ {
        f[i] = false
        for j := 1; j <= int(math.Sqrt(float64(i))); j++ {
            if i%j == 0 && 
            (f[i-j] == false || (j != 1 && f[i-i/j] == false)) {
                f[i] = true
                break
            }
        }
    }
    return f[N];
}
```

Fun:
```go
func divisorGame(N int) bool {
    return N%2 == 0
}
```
