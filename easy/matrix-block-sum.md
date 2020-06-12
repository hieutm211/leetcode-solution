##1314. Matrix Block Sum
https://leetcode.com/problems/matrix-block-sum/

Solution:
f[i][j] = tổng hình chữ nhật ô trái trên là 0, 0 ô phải duới là i, j
f[i][j] = f[i][j-1] + f[i-1][j] - f[i-1][j-1] + mat[i][j]
Sum(x, y, u, v) = tổng hình chữ nhật ô trái trên là x, y ô phải duới là u, v
                = f[u][v] - f[x-1][v] - f[u][y-1] + f[x-1][y-1]
answer[i][j] = Sum(i-k, j-k, i+k, j+k)

O(N^2) time, O(N^2) space

```go
func matrixBlockSum(mat [][]int, K int) [][]int {
    M := len(mat)
    if M == 0 { return mat } 
    N := len(mat[0])
    if N == 0 { return mat }
    
    //create f array
    f := createArray(M+1, N+1)    
    //calculate f
    initiate(f, mat)
    
    //create answer array
    answer := createArray(M, N)
    //calculate answer
    for i, _ := range answer {
        for j, _ := range answer[i] {
            answer[i][j] = sum(f, i-K, j-K, i+K, j+K)
        }
    }
    
    return answer
}

func createArray(M, N int) [][]int {
    arr := make([][]int, M, M)
    for i, _ := range arr {
        arr[i] = make([]int, N, N)
    }
    return arr
}

func initiate(f [][]int, mat[][]int) {
    M := len(mat)
    N := len(mat[0])
    
    for i := 1; i <= M; i++ {
        for j := 1; j <= N; j++ {
            f[i][j] = f[i-1][j] + f[i][j-1] - f[i-1][j-1] + mat[i-1][j-1]
        }
    }
}

func sum(f [][]int, x, y, u, v int) int {
    M := len(f)-1
    N := len(f[0])-1
    
    x++
    y++ 
    u++
    v++
    
    if x < 1 { x = 1 }
    if y < 1 { y = 1 }
    if u > M { u = M }
    if v > N { v = N }

    return f[u][v] - f[x-1][v] - f[u][y-1] + f[x-1][y-1]
}
```
