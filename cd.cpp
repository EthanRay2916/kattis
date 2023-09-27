#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

int main() {
    int n, m;
    while (cin >> n >> m) {
        if (n == 0 && m == 0) {
            break;
        }
        vector<int> jack(n);
        vector<int> jill(m);
        vector<int> ans;
        unordered_set<int> jackSet;
        unordered_set<int> jillSet;

        for (int i = 0; i < n; i++) {
            cin >> jack[i];
            jackSet.insert(jack[i]);
        }
        for (int i = 0; i < m; i++) {
            cin >> jill[i];
            jillSet.insert(jill[i]);
        }

        for (int i = 0; i < n; i++) {
            if (jillSet.count(jack[i]) > 0) {
                ans.push_back(jack[i]);
            }
        }
        cout << ans.size() << endl;
    }
    return 0;
}