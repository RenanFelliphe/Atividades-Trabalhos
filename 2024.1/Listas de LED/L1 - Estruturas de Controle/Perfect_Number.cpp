#include <iostream>

using namespace std;

// Function to check if a number is perfect
bool isPerfect(int num) {
    int sum = 0;
    
    // Calculate sum of divisors
    for (int i = 1; i <= num / 2; ++i) {
        if (num % i == 0) {
            sum += i;
        }
    }

    // Check if the sum of divisors equals the number itself
    return sum == num;
}

int main() {
    int N;
    cin >> N;

    for (int i = 0; i < N; ++i) {
        int X;
        cin >> X;

        // Check if X is perfect and print the result
        if (isPerfect(X)) {
            cout << X << " eh perfeito" << endl;
        } else {
            cout << X << " nao eh perfeito" << endl;
        }
    }

    return 0;
}
