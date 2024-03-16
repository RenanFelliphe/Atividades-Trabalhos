#include <iostream>

using namespace std;

int main() {
    int X;

    while (true) {
        cin >> X;

        if (X == 0) {
            break;
        }

        int sum = 0;

        // Calculate sum of five consecutive even numbers starting from X
        for (int i = 0; i < 5; ++i) {
            if (X % 2 != 0) {
                X++; // If X is odd, move to the next even number
            }
            sum += X;
            X += 2; // Move to the next even number
        }

        cout << sum << endl;
    }

    return 0;
}
