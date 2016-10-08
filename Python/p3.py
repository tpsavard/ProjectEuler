value = 600851475143
factors = []

sqrt_value = int(value ** .5)

for i in range (1, (sqrt_value + 1)):
    if value % i == 0:
        factors.append(i)

prime_factors = []

for i in factors:
    prime = True
    for j in range (2, (i)):
        if i % j == 0:
            prime = False
            break

    if prime:
        prime_factors.append(i)

print factors
print prime_factors
print prime_factors[-1]
