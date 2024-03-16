#include <iostream>
#include <cmath>

using namespace std;

// Function to check if a number is prime
bool isPrime(int num) {
    // Check if num is less than 2
    if (num < 2) {
        return false;
    }

    // Check if num is divisible by any number from 2 to sqrt(num)
    for (int i = 2; i <= sqrt(num); ++i) {
        if (num % i == 0) {
            return false;
        }
    }

    return true;
}

int main() {
    int N;
    cin >> N;

    for (int i = 0; i < N; ++i) {
        int X;
        cin >> X;

        // Check if X is prime and print the result
        if (isPrime(X)) {
            cout << X << " eh primo" << endl;
        } else {
            cout << X << " nao eh primo" << endl;
        }
    }

    return 0;
}
