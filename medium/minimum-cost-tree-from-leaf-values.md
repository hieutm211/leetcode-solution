##1130. Minimum Cost Tree From Leaf Values
https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/

```go
const maxInt = int(^uint(0) >> 1)

var (
    mx, g [][]int
)

func mctFromLeafValues(arr []int) int {
    N := len(arr)
    
    initMax(arr)
    initG(N)  
    
    return f(0, N-1)
}

func initMax(arr []int) {
    N := len(arr)
    mx = createArray(N, N)
    
    for i := 0; i < N; i++ {
        for j := 0; j < i; j++ {
            mx[i][j] = -1
        }
        
        mx[i][i] = arr[i]
        for j := i+1; j < N; j++ {
            mx[i][j] = max(mx[i][j-1], arr[j])
        }
    }
}

func initG(N int) {
    g = createArray(N, N)
    for i, _ := range g {
        for j, _ := range g[i] {
            if i == j {
                g[i][j] = 0
            } else {
                g[i][j] = maxInt
            }
        }
    }
}

func f(l, r int) int {
    if g[l][r] != maxInt {
        return g[l][r]
    }
    
    for mid := l; mid < r; mid++ {
        g[l][r] = min(g[l][r], mx[l][mid]*mx[mid+1][r] + f(l, mid) + f(mid+1, r))
    }
    
    return g[l][r]
}

func createArray(M, N int) [][]int {
    arr := make([][]int, M, M)
    for i, _ := range arr {
        arr[i] = make([]int, N)
    }
    return arr
}

func min(a, b int) int {
    if a <= b { 
        return a
    }
    return b
} 
func max(a, b int) int {
    if a >= b {
        return a
    }
    return b
}
```
