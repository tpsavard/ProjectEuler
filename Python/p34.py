from math import factorial
from euler_utils import *

def doesNumberEqualFactorialSum(val):
    digits = getDigitsDescendingOrder(val)
    factorial_sum = 0
    for digit in digits:
        factorial_sum += factorial(digit)
    return val == factorial_sum

def getFilteredSum(start, end):
    sum = 0;
    for i in range(start, end):
        if doesNumberEqualFactorialSum(i):
            print("Found " + str(i))
            sum += i
    return sum

# __main__
print("Sum: " + str(getFilteredSum(3, 9999999)))