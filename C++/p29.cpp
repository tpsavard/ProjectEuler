#include <iostream>
#include <unordered_set>

class P29 {
public:
    P29();
    ~P29();
    int getSequenceLength(int aMin, int aMax, int bMin, int bMax);

private:
    std::unordered_set<double> *set;
};

P29::P29() {
    this->set = new std::unordered_set<double>;
}

P29::~P29() {
    delete this->set;
}

int P29::getSequenceLength(int aMin, int aMax, int bMin, int bMax) {
    set->clear();
    for (int a = aMin; a <= aMax; a++) {
        for (int b = bMin; b <= bMax; b++) {
            set->insert(std::pow((double)a, (double)b));
        }
    }
    return set->size();
}

int main() {
    P29 *solution = new P29;

    std::cout << "2-5: " << solution->getSequenceLength(2, 5, 2, 5) << "\n";
    std::cout << "2-100: " << solution->getSequenceLength(2, 100, 2, 100) << "\n";

    delete solution;
}