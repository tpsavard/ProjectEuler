prime_factors = []
i = 2

while len(prime_factors) < 10001:
    is_prime = True
    for j in prime_factors:
        if i % j == 0:
            is_prime = False
            break

    if is_prime:
        prime_factors.append(i)

    i += 1

print prime_factors[-1]
