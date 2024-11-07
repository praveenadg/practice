package problems.String;

public class NeedleInHayStack {

    //doesn't work

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
        String s = "\"";
    }
        public static int strStr(String haystack, String needle) {
            int j=0;
            int firstIndex=-1;
            for(int i=0; i<haystack.length(); i++){
                if(haystack.charAt(i)==needle.charAt(j)){
                    if(firstIndex<0){
                        firstIndex=i;
                    }

                    if(j==needle.length()-1){
                        return firstIndex;
                    }
                    j++;
                }else{
                    j=0;
                }
            }
            return -1;

        }

}
