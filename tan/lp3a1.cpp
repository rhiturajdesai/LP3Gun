#include <iostream>
using namespace std;

void fibonacciNonrecursiveSeries(int n) {
    if (n >= 1) cout << 0;
    if (n >= 2) cout << " " << 1;

    int p1 = 0, p2 = 1, c;
    for (int i = 2; i < n; ++i) {
        c = p1 + p2;
        cout << " " << c;
        p1 = p2;
        p2 = c;
    }
    cout << endl;
}

int fibonacciNonrecursive(int n) {
    if (n <= 1) return n;

    int p1 = 0, p2 = 1, c = 0;
    for (int i = 2; i <= n; ++i) {
        c = p1 + p2;
        p1 = p2;
        p2 = c;
    }
    return c;
}

void fibonacciRecursiveSeries(int n, int a = 0, int b = 1, int count = 1) {
    if (count == 1) cout << a;
    if (count == 2) cout << " " << b;
    if (count >= n) {
        cout << endl;
        return;
    }
    cout << " " << a + b;
    fibonacciRecursiveSeries(n, b, a + b, count + 1);
}

int fibonacciRecursive(int n) {
    if (n <= 1) return n;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

int main() {
    int n, choice;

    while (true) {
        cout << "\nFibonacci Number" << endl;
        cout << "1. Non-Recursive Method" << endl;
        cout << "2. Recursive Method" << endl;
        cout << "3. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;

        if (choice == 3) {
            cout << "Exiting the program." << endl;
            break;
        }

        cout << "\nEnter a number: ";
        cin >> n;

        if (choice == 1) {
            cout << "Fibonacci series up to " << n << " numbers: ";
            fibonacciNonrecursiveSeries(n);
            cout << "Fibonacci(" << n << ") = " << fibonacciNonrecursive(n) << endl;
        } else if (choice == 2) {
            cout << "Fibonacci series up to " << n << " numbers: ";
            fibonacciRecursiveSeries(n);
            cout << "Fibonacci(" << n << ") = " << fibonacciRecursive(n) << endl;
        } else {
            cout << "Invalid choice! Please select a valid option." << endl;
        }
    }

    return 0;
}
