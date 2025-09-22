class Solution {
public:
    bool isPalindrome(int x) {

        if (x < 0){
            return false;
        }

        int revNum = 0;
        int original = x;

        while(x != 0) {
            int lastDigit = x%10;
            x /= 10;
            if (revNum > 214748364 || revNum < -214748364) return 0;
            revNum = (revNum*10) + lastDigit;
        }
        if(revNum==original) {
            return true;
        }
        else {
            return false;
        }
    }
};