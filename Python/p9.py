for i in range (1, (1001 - 2)):
    for j in range (1, (1001 - 1 - i)):
        k = 1000 - i - j

        if (i * i) + (j * j) == (k * k):
            print str(i) + " " + str(j) + " " + str(k)
            print str(i * j * k)
            exit()
