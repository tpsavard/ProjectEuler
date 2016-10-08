def p17(exp):
    sum = 0

    place_value = exp / 1000
    if (place_value > 0):
        sum = ones_place(place_value) + len("thousand")

    place_value = (exp % 1000) / 100
    if (place_value > 0):
        sum += ones_place(place_value) + len("hundred")

    place_value = exp % 100
    if place_value > 0 and sum > 0:
        sum += len("and")

    if place_value >= 20:
        sum = sum + tens_place(place_value / 10) + ones_place(place_value % 10)
    elif place_value >= 10:
        sum += teens(place_value)
    else:
        sum += ones_place(place_value)

    return sum

def ones_place(exp):
    if exp == 1:
        return len("one")
    elif exp == 2:
        return len("two")
    elif exp == 3:
        return len("three")
    elif exp == 4:
        return len("four")
    elif exp == 5:
        return len("five")
    elif exp == 6:
        return len("six")
    elif exp == 7:
        return len("seven")
    elif exp == 8:
        return len("eight")
    elif exp == 9:
        return len("nine")
    else:
        return 0

def tens_place(exp):
    if exp == 2:
        return len("twenty")
    elif exp == 3:
        return len("thirty")
    elif exp == 4:
        return len("forty")
    elif exp == 5:
        return len("fifty")
    elif exp == 6:
        return len("sixty")
    elif exp == 7:
        return len("seventy")
    elif exp == 8:
        return len("eighty")
    elif exp == 9:
        return len("ninety")
    else:
        return 0

def teens(exp):
    if exp == 10:
        return len("ten")
    elif exp == 11:
        return len("eleven")
    elif exp == 12:
        return len("twelve")
    elif exp == 13:
        return len("thirteen")
    elif exp == 14:
        return len("fourteen")
    elif exp == 15:
        return len("fifteen")
    elif exp == 16:
        return len("sixteen")
    elif exp == 17:
        return len("seventeen")
    elif exp == 18:
        return len("eighteen")
    elif exp == 19:
        return len("nineteen")
    else:
        return 0

sum = 0

for i in range(1, 1001):
    sum += p17(i)

print sum
