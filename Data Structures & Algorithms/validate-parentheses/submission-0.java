class Solution {
    public boolean isValid(String s) {
        Stack<Character> stac = new Stack<>();

        Map<Character,Character> map = new HashMap<>();

        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            //if closing bracket comes 
            if(map.containsKey(ch)){
                //then check for empty 
                char top = stac.isEmpty() ? '#':stac.pop();

                if(top!=map.get(ch)){
                    return false;
                }
            }else{
                //it means top bracket
                stac.push(ch);
            }
        }

        return stac.isEmpty();
    }
}
