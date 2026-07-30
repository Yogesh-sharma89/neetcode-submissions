class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int  i = 0 , j = 0;

        while(i<word.length() && j<abbr.length()){
            char ch_word = word.charAt(i);
            char ch_abbr = abbr.charAt(j);

            //check if abbr start with a number or not 
            if(Character.isDigit(ch_abbr)){
                //then check it should not be start with zero 
                if(ch_abbr=='0'){
                    return false;
                }

                //if not zero then made digit from it 
                int digit = 0;
                while(j<abbr.length() && Character.isDigit(abbr.charAt(j))){
                    digit = digit*10 + (abbr.charAt(j) - '0');
                    j++;
                }

                //then add this digit into i to match the string s
                i+=digit;
            }
            else{
                //if not digit then check
                if(ch_word!=ch_abbr){
                    return false;
                }

                i++;
                j++;
            }
        }

        return (i==word.length() && j==abbr.length());
    }
}