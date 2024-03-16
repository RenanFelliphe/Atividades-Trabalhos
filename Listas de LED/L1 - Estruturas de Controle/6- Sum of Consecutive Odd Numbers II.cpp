#include <iostream>

using namespace std;

int main() {
    int N;
    cin >> N;

    for (int i = 0; i < N; ++i) {
        int X, Y;
        cin >> X >> Y;

        // Swap X and Y if X is greater than Y
        if (X > Y) {
            int temp = X;
            X = Y;
            Y = temp;
        }

        int sum = 0;
        // Iterate through the range between X and Y-1
        for (int num = X + 1; num < Y; ++num) {
            // Check if the number is odd
            if (num % 2 != 0) {
                sum += num;
            }
        }

        cout << sum << endl;
    }

    return 0;
}
