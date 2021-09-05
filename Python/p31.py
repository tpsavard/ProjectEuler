count = 0

def deduct(amtP, maxD):
    global count

    if (amtP <= 0):
        count += 1
        return

    for c in [200, 100, 50, 20, 10, 5, 2, 1]:
        if (c <= maxD and amtP >= c):
            deduct(amtP - c, c)

deduct(200, 200)
print(count)