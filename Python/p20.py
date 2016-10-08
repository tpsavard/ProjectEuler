def p20(fac):
	mul = 1
	for i in range(1, fac + 1):
		mul *= i
	return mul

def digit_sum(val):
	number = str(val)

	digit_sum = 0
	for digit in number:
		digit_sum += int(digit)
	return digit_sum

print digit_sum(p20(100))
