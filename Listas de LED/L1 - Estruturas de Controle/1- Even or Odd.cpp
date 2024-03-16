#include <iostream>
#include <stdio.h>
#include <vector>

using namespace std;

int main() {
    int N;
    cin >> N;

    vector<int> values(N);
    for (int i = 0; i < N; ++i) {
        cin >> values[i];
    }

    for (int i = 0; i < N; ++i) {
        if (values[i] == 0) {
            cout << "NULL" << endl;
        } else if (values[i] % 2 == 0) {
            if (values[i] > 0)
                cout << "EVEN POSITIVE" << endl;
            else
                cout << "EVEN NEGATIVE" << endl;
        } else {
            if (values[i] > 0)
                cout << "ODD POSITIVE" << endl;
            else
                cout << "ODD NEGATIVE" << endl;
        }
    }

    return 0;
}
