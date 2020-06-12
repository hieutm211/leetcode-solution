##53. Maximum Subarray
https://leetcode.com/problems/maximum-subarray/

Solution 1: Dynamic programming

```go
func maxSubArray(nums []int) int {
    N := len(nums)
    answer, s, mn, f := nums[0], nums[0], min(0, nums[0]), nums[0]
    
    for i := 1; i < N; i++ {
        s += nums[i]
        f = s - mn
        mn = min(mn, s)
        answer = max(answer, f)
    }
    
    return answer
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

Solution 2: Divide and conquer (segment tree)

```go 
type SegmentTree struct {
    T, F, L, R []int
}

func (tree *SegmentTree) initiate(nums []int) {
    N := len(nums)
    
    tree.T = make([]int, 4*N, 4*N)
    tree.F = make([]int, 4*N, 4*N)
    tree.L = make([]int, 4*N, 4*N)
    tree.R = make([]int, 4*N, 4*N)
    
    tree.build(1, 0, N-1, &nums)
}

func (tree *SegmentTree) build(k, l, r int, nums *[]int) {
    if l == r {
        tree.T[k] = (*nums)[r]
        tree.F[k] = (*nums)[r]
        tree.L[k] = (*nums)[r]
        tree.R[k] = (*nums)[r]
        return
    }    
    
    mid := l + (r-l)/2
    tree.build(2*k, l, mid, nums)
    tree.build(2*k+1, mid+1, r, nums)
    
    tree.T[k] = tree.T[2*k] + tree.T[2*k+1]
    tree.F[k] = max(tree.F[2*k], tree.F[2*k+1], tree.R[2*k] + tree.L[2*k+1])
    tree.L[k] = max(tree.L[2*k], tree.T[2*k] + tree.L[2*k+1])
    tree.R[k] = max(tree.R[2*k+1], tree.R[2*k] + tree.T[2*k+1])
}

func (tree *SegmentTree) get() int {
    return tree.F[1]
}

func max(args ...int) int {
    if len(args) == 0 {
        return 0
    }
    
    answer := args[0]
    for i := 1; i < len(args); i++ {
        if answer < args[i] {
            answer = args[i]
        }
    }
    return answer
}

func maxSubArray(nums []int) int {
    var st SegmentTree
    
    st.initiate(nums)
    
    return st.get()
}
```
