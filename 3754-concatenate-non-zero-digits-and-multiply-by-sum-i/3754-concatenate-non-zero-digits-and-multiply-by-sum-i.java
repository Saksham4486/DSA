class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long x=0;
        int f=1;
       while(n!=0)
       {    
            if(n%10!=0)
            {sum+=n%10;
                x=(n%10)*f+x;
                f=f*10;
            } 
            n/=10;
            
       }
       return x*sum;
    }
}