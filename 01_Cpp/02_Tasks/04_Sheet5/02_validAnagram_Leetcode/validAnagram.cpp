#include <algorithm>

class Solution {
public:
    bool isAnagram(string s, string t)
    {
        std::sort(s.begin(), s.end());
        std::sort(t.begin(), t.end());

        if (s.size() != t.size())
            return false;

        for (int i = 0;i < s.size();i++)
        {
            if (s[i] != t[i])
                return false;
        }
        return true;
    }
};