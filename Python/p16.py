def p16(exp):
    number = str(2 ** exp)  # Evidently, 2^1000 is easy to find.

    sum = 0
    for digit in number:
        sum += int(digit)

    return sum

print p16(1000)
