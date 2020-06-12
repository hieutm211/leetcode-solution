##1277. Count Square Submatrices with All Ones
https://leetcode.com/problems/count-square-submatrices-with-all-ones/

```go
package main

// import "fmt"

// func main() {
//     var m, n int
   
//     fmt.Scanf("%d%d", &m, &n)
//     a := createArray(m, n)
    
//     for i := 0; i < m; i++ {
//         for j := 0; j < n; j++ {
//             fmt.Scanf("%d", &a[i][j])
//         }
//     }
    
//     fmt.Println(countSquare(a))
// }

func createArray(m, n int) [][]int {
    arr := make([][]int, m, m)
    for i, _ := range arr {
        arr[i] = make([]int, n, n)
    }
    return arr
}

func countSquares(a [][]int) int {
    m := len(a)
    if m == 0 { return 0 }
    n := len(a[0])
    if n == 0 { return 0 }
    
    f := createArray(m+1, n+1)
    initiate(f, a)
    
    answer := 0
    
    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            for k := 0; i-k >= 0 && j-k >= 0; k++ {
                if sum(f, i-k, j-k, i, j) == (k+1)*(k+1) {
                    answer++
                } else {
                    break
                }
            }
        }
    }
    
    return answer
}

func initiate(f [][]int, a [][]int) {
    m := len(a)
    n := len(a[0])

    for i := 0; i < m; i++ {
        for j := 0; j < n; j++ {
            f[i+1][j+1] = f[i][j+1] + f[i+1][j] - f[i][j] + a[i][j]
        }
    }
}

func sum(f [][]int, x, y, u, v int) int {
    return f[u+1][v+1] - f[u+1][y] - f[x][v+1] + f[x][y]
}
```
