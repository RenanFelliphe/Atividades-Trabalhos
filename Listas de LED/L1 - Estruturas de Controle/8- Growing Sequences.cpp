#include <iostream>

using namespace std;

int main() {
    int X;

    while (true) {
        cin >> X;

        if (X == 0) {
            break;
        }

        for (int i = 1; i <= X; ++i) {
            cout << i;
            // Print space if it's not the last number in the sequence
            if (i < X) {
                cout << " ";
            }
        }
        // Print newline after the sequence
        cout << endl;
    }

    return 0;
}
