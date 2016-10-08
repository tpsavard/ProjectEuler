best_start = 1
best_len = 1
lengths = {}

for i in range(1, 1000000):
    seq_val = i
    seq_len = 1

    print seq_val

    while seq_val > 1:
        if seq_val in lengths:
            seq_len += lengths[seq_val]
            break
        
        if seq_val % 2 == 0:
            seq_val = seq_val >> 1
        else:
            seq_val = (3 * seq_val) + 1

        print '\t' + str(seq_val)
        seq_len += 1

    lengths[i] = seq_len

    if seq_len > best_len:
        best_start = i
        best_len = seq_len

print best_start
print best_len
