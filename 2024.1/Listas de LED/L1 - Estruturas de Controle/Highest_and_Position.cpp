#include <iostream>

using namespace std;

int main() {
    int numbers[100];
    int maxNumber = 0;
    int position = 0;

    for (int i = 0; i < 100; ++i) {
        cin >> numbers[i];
        if (numbers[i] > maxNumber) {
            maxNumber = numbers[i];
            position = i + 1;
        }
    }

    cout << maxNumber << endl;
    cout << position << endl;

    return 0;
}
