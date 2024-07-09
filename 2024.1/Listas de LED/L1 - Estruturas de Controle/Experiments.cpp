#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    int N;
    cin >> N;

    int totalAnimals = 0;
    int totalRabbits = 0, totalRats = 0, totalFrogs = 0;

    for (int i = 0; i < N; ++i) {
        int amount;
        char type;
        cin >> amount >> type;

        totalAnimals += amount;

        if (type == 'C')
            totalRabbits += amount;
        else if (type == 'R')
            totalRats += amount;
        else if (type == 'S')
            totalFrogs += amount;
    }

    cout << "Total: " << totalAnimals << " animals\n";
    cout << "Total rabbits: " << totalRabbits << endl;
    cout << "Total rats: " << totalRats << endl;
    cout << "Total frogs: " << totalFrogs << endl;

    cout << fixed << setprecision(2);
    cout << "Percentual rabbits: " << (totalRabbits / (double)totalAnimals) * 100 << " %" << endl;
    cout << "Percentual rats: " << (totalRats / (double)totalAnimals) * 100 << " %" << endl;
    cout << "Percentual frogs: " << (totalFrogs / (double)totalAnimals) * 100 << " %" << endl;

    return 0;
}
