def p30(min, max, power):
    sum = 0
    for i in range(min, max + 1):
        raisedDigitSum = sumRaisedDigits(getDigits(i), power)
        if i == raisedDigitSum:
            sum = sum + raisedDigitSum
    return sum

def sumRaisedDigits(digits, power):
    sum = 0
    for digit in digits:
        sum = sum + (digit ** power)
    return sum

def getDigits(val):
    cur_val = val
    digits = []
    while cur_val > 0:
        digits.append(cur_val % 10)
        cur_val = cur_val // 10
    return digits

# ~

print(p30(10, 9999999, 5))