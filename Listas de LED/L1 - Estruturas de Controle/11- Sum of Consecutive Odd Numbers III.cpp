#include <iostream>

using namespace std;

int main() {
    int N;
    cin >> N;

    for (int i = 0; i < N; ++i) {
        int X, Y;
        cin >> X >> Y;

        int sum = 0;
        int count = 0;

        // Iterate through odd numbers starting from X
        while (count < Y) {
            if (X % 2 != 0) {
                sum += X;
                count++;
            }
            X++;
        }

        cout << sum << endl;
    }

    return 0;
}
