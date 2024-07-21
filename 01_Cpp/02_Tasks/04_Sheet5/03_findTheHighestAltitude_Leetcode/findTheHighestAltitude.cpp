class Solution {
public:
    int largestAltitude(vector<int>& gain) {

        int point = 0;
        int max = 0;

        for (int i = 0;i < gain.size();i++)
        {
            point = point + gain[i];
            if (max < point)
                max = point;
        }

        return max;
    }
};