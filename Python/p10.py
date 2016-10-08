prime_factors = []
prime_sum = 0

for i in range(2, 2000001):
    is_prime = True

    sqrt_i = int(i ** .5)

    for j in prime_factors:
        if i % j == 0:
            is_prime = False
            break

        if j > sqrt_i:
            break

    if is_prime:
        prime_factors.append(i)
        prime_sum += i

print prime_factors[-1]
print prime_sum
