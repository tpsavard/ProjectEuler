import math

limit = 500

tri_index = 1
tri_num = 1
divisors = 1

while divisors < limit:
    tri_index += 1
    tri_num = sum(range(tri_index + 1))

    divisors = 0
    search_limit = int(math.sqrt(tri_num)) + 1
    for i in range(1, search_limit):
        if tri_num % i == 0:
            divisors += 2

print tri_num
