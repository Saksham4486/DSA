class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int counter=0;
        for(int i=0;i<patterns.length;i++)
        {  
        int k=0, j=0,start=0;
            while(j<word.length()&&k<patterns[i].length())
            {   
                if (patterns[i].charAt(k) == word.charAt(j))
                    {
                        j++;
                        k++;
                    }
                    else{
                    
                    k=0;
                    start++;
                    j=start;
                    }
            }
            if(k==patterns[i].length())
            counter++;
        }
        return counter;
    }
}