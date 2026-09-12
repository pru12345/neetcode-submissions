class Solution {

    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for (String str : strs) sb.append(str.length() + "#"+ str);
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> result = new ArrayList<>();
        char[] chars = str.toCharArray();
        int lastStart = 0;
        for (int i = 0 ; i < chars.length; i++){
            if(chars[i]=='#'){
                int length = Integer.parseInt(str.substring(lastStart,i));
                result.add(str.substring(i+1,i+length+1));
                i = i+length;
                lastStart = i+1;
            }
        }

        return result;
 

    }
}
