class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0 , j=0;

        while(i<word.length() && j<abbr.length()){
            char wordChar = word.charAt(i);
            char abbrChar = abbr.charAt(j);

            //check if abbr has starting with number ;

            if(Character.isDigit(abbrChar)){
                //if it start with zero then invalid abbr 
                if(abbrChar=='0'){
                    return false;
                }else{
                    //build the whole number and add to i
                    int digit = 0;
                    while(j<abbr.length() && Character.isDigit(abbr.charAt(j))){
                        digit = digit*10 + (abbr.charAt(j) - '0');
                        j++;
                    }

                    //then move i pointer upto that digit in word;
                    i+=digit;
                }
            }else if(wordChar!=abbrChar){
                return false;
            }else{
                i++;
                j++;
            }
        }

        return (i==word.length() && j==abbr.length());
    }
}