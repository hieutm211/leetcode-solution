#121. Best Time to Buy and Sell Stock

Tag: dynamic programming

```go
func maxProfit(prices []int) int {
    N := len(prices)
    
    answer, mx := 0, 0
    for i := N-1; i >= 0; i-- {
        p := mx - prices[i]
        if p > answer {
            answer = p
        }
        if prices[i] > mx {
            mx = prices[i]
        }
    }
    
    return answer
}
```
