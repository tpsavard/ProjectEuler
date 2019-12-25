#include <iostream>

#define MAX_A 999
#define MAX_B 1000

class P27 {
public:
    void findCoefficients(int *a, int *b) {
        for (int i = MAX_A * -1; i <= MAX_A; i++) {
            std::cout << ".";
            for (int j = MAX_B * -1; j <= MAX_B; j++) {
                int curConsecutivePrimes = 0;
                for (int n = 0;;n++) {
                    int qn = (n * n) + (i * n) + j;
                    if (isPrime(qn)) {
                        curConsecutivePrimes++;
                    } else {
                        if (curConsecutivePrimes > this->maxConsecutivePrimes) {
                            this->a = i;
                            this->b = j;
                            this->maxConsecutivePrimes = curConsecutivePrimes;
                        }
                        break;
                    }
                }
            }
        }

        *a = this->a;
        *b = this->b;
        return;
    }

private:
    int a = 0;
    int b = 0;
    int maxConsecutivePrimes = 0;

    bool isPrime(int value) {
        // Logic taken from https://en.wikipedia.org/wiki/Primality_test
        if (value <= 3) {
            return value > 1;
        } else if (value % 2 == 0 || value % 3 == 0) {
            return false;
        }

        int i = 5;
        while (i * i < value) {
            if (value % i == 0 || value % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }

        return true;
    }
};

int main() {
    int *a = new int;
    int *b = new int;

    P27 *solution = new P27;
    solution->findCoefficients(a, b);

    std::cout << "(Final) A: " << *a << ", B: " << *b << " Product: " << *a * *b << "\n";

    delete solution;
    delete a;
    delete b;
}