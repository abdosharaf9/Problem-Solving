#include<bits/stdc++.h>
using namespace std;

class AllOne {
private:
    unordered_map<string, int> mp;
    set<pair<int, string>> st;

public:
    AllOne() {

    }

    void inc(string key) {
        if(mp.find(key) == mp.end()) {
            mp[key] = 1;
            st.insert({1, key});
        } else {
            st.erase({mp[key], key});
            mp[key]++;
            st.insert({mp[key], key});
        }
    }

    void dec(string key) {
        st.erase({mp[key], key});
        mp[key]--;
        if(mp[key] == 0) mp.erase(key);
        else st.insert({mp[key], key});
    }

    string getMaxKey() {
        return st.empty()? "" : st.rbegin()->second;
    }

    string getMinKey() {
        return st.empty()? "" : st.begin()->second;
    }
};


int main() {
    AllOne test = AllOne();
    test.inc("hello");
    test.inc("hello");
    cout << test.getMaxKey() << "\n";
    cout << test.getMinKey() << "\n";
    test.inc("leet");
    cout << test.getMaxKey() << "\n";
    cout << test.getMinKey() << "\n";

    return 0;
}