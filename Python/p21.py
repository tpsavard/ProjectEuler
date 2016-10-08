def divisor_sum(n):
	# return the tuple of n and the sum of the divisors of n
	divisors = []
	for i in range(1, n + 1):
		if n % i == 0:
			divisors.append(i)

	divisor_sum = sum(divisors)
	return (n, divisor_sum)

def divisor_sums(start, limit):
	# collect the tuples of all values and their divisor sums in the given range
	divisor_sums = []
	for i in range(start, limit):
		divisor_sums.append(divisor_sum(i))

	return divisor_sums

def amicable_number_sum(candidates):
	# find the amicable numbers in the list given
	amicable_sums = set()
	for candidate in candidates:
		reverse = (candidate[1], candidate[0])
		if reverse in candidates and not reverse in amicable_sums:
			amicable_sums.add(candidate)

	# DEBUG
	for amicable_sum in amicable_sums:
		if (amicable_sum[1], amicable_sum[0]) in amicable_sums:
			print "ERROR"

	# sum the amicable numbers
	final_sum = 0
	for amicable_sum in amicable_sums:
		final_sum += amicable_sum[0] + amicable_sum[1]
	return final_sum

print amicable_number_sum(divisor_sums(0, 10000))
