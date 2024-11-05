#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Item {
    int value, weight;
    Item(int value, int weight) : value(value), weight(weight) {}
};

bool cmp(struct Item a, struct Item b) {
    double r1 = (double)a.value / (double)a.weight;
    double r2 = (double)b.value / (double)b.weight;
    return r1 > r2;
}

double fractionalKnapsack(int W, vector<Item>& items, int n) {
    sort(items.begin(), items.end(), cmp);

    int curWeight = 0;
    double finalValue = 0.0;

    for (int i = 0; i < n; i++) {
        if (curWeight + items[i].weight <= W) {
            curWeight += items[i].weight;
            finalValue += items[i].value;
        } else {
            int remain = W - curWeight;
            finalValue += items[i].value * ((double)remain / (double)items[i].weight);
            break;
        }
    }

    return finalValue;
}

int main() {
    int n, W;
    cout << "Enter the number of items: ";
    cin >> n;

    vector<Item> items;
    int value, weight;

    for (int i = 0; i < n; i++) {
        cout << "Enter value and weight for item " << i + 1 << ": ";
        cin >> value >> weight;
        items.push_back(Item(value, weight));
    }

    cout << "Enter the maximum capacity of the knapsack: ";
    cin >> W;

    cout << "Maximum value in Knapsack = " << fractionalKnapsack(W, items, n) << endl;

    return 0;
}
