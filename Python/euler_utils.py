def getDigitsDescendingOrder(val):
    cur_val = val
    digits = []
    while cur_val > 0:
        digits.insert(0, cur_val % 10)
        cur_val = cur_val // 10
    return digits