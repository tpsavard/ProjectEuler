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

# Rotate the digits of a number "clockwise" one place value;
# Obtain all rotations by calling repeatedly, until the original value is repeated
# Ex.: 1234 -> 4123 -> 3412 -> 2341 -> 1234
def rotateNumberClockwise(val):
    digits = getDigitsDescendingOrder(val)
    new_order = []
    index = len(digits) - 1
    for _ in range(0, len(digits)):
        new_order.append(digits[index % len(digits)])
        index += 1
    return getNumber(new_order)

# Returns whether the given number is a prime or not
# Ex.: 2 -> False, 3 -> True
def isPrime(val):
    # Taken from https://www.pythonpool.com/check-if-number-is-prime-in-python/
    # Better library implementation: https://www.sympy.org/
    for factor in range(2, int(val**.5) + 1):
        if val & factor == 0:
            return False
        return True