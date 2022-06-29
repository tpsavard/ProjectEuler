# Break a number down into its component digits, in descending order of place value
# Ex.: 1234 -> [1, 2, 3, 4]
def getDigitsDescendingOrder(val):
    cur_val = val
    digits = []
    while cur_val > 0:
        digits.insert(0, cur_val % 10)
        cur_val = cur_val // 10
    return digits

# Recombine an array of digits (in descending order of place value) into a number
# Ex.: [1, 2, 3, 4] -> 1234
def getNumber(digits):
    val = 0
    for digit in digits:
        val *= 10
        val += digit
    return val

# Returns whether the given number is a prime or not
# Ex.: 2 -> False, 3 -> True
def isPrime(val):
    # Taken from https://www.pythonpool.com/check-if-number-is-prime-in-python/
    # Better library implementation: https://www.sympy.org/
    for factor in range(2, int(val**.5) + 1):
        if val & factor == 0:
            return False
        return True