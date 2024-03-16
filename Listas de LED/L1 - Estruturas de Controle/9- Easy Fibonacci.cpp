#include <iostream>

using namespace std;

int main() {
    int N;
    cin >> N;

    int fib[N];

    // First two numbers of the Fibonacci sequence
    fib[0] = 0;
    fib[1] = 1;

    // Generate the rest of the sequence
    for (int i = 2; i < N; ++i) {
        fib[i] = fib[i - 1] + fib[i - 2];
    }

    // Print the sequence
    for (int i = 0; i < N; ++i) {
        cout << fib[i];
        // Print space if it's not the last number in the sequence
        if (i < N - 1) {
            cout << " ";
        }
    }

    cout << endl;

    return 0;
}
