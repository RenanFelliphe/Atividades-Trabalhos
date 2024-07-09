#include <iostream>

using namespace std;

int main() {
    int N;
    cin >> N;

    int factorial = 1;

    // Calculate factorial
    for (int i = 1; i <= N; ++i) {
        factorial *= i;
    }

    cout << factorial << endl;

    return 0;
}
