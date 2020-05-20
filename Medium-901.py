class StockSpanner:

    def __init__(self):
        self.stack = []

    def next(self, price: int) -> int:
        count = 0
        while len(self.stack) != 0 and self.stack[-1][0] <= price:
            tmp = self.stack.pop()
            count += tmp[1]
        self.stack.append((price, count + 1))
        return count + 1


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)