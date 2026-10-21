class Solution {
    public int happyNumber(int n ){

        int sum = 0;
        int dig;
        //36%10 = 6
        //36 / 10 = 3
        while(n > 0){
            dig = n % 10;
            sum += dig * dig;

            n = n / 10;

        }
        return sum;
    }
    public boolean isHappy(int n) {
        
        int fast = n;
        int slow = n;
        while(fast != 1){

            slow = happyNumber(slow);
            fast = happyNumber(happyNumber(fast));

            if(fast == 1){
                return true;
            }
            if(fast == slow){
                return false;
            }
            
        }
        return true;
    }
}