log = {}

def p15(rem_ones, rem_zeros):
    if (rem_ones, rem_zeros) in log:
        return log[(rem_ones, rem_zeros)]
    elif rem_ones <= 0 and rem_zeros <= 0:
        return 1
    # elif rem_ones == rem_zeros:
    #     return 2 * p15(rem_ones - 1, rem_zeros)   # Storing previous work >> square optimization
    else:
        one_path = zero_path = 0

        if rem_ones > 0:
            one_path = p15(rem_ones - 1, rem_zeros)

        if rem_zeros > 0:
            zero_path = p15(rem_ones, rem_zeros - 1)

        total = one_path + zero_path
        log[(rem_ones, rem_zeros)] = total
        return total

print p15(20, 20)
