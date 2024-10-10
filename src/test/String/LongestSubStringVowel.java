package test.String;

public class LongestSubStringVowel {

    public static void main(String[] args) {
        System.out.println((int)Math.log(8)+1);
        findTheLongestSubstring("eleetminicoworoep");
    }

    public static int findTheLongestSubstring(String s) {
        int a=0;
        int e=0;
        int i=0;
        int o=0;
        int u=0;

        // int left=0;
        String longest="";
        for(int left=0; left<s.length(); left ++){
            if(s.charAt(left)=='a'){a++;}
            if(s.charAt(left)=='e'){e++;}
            if(s.charAt(left)=='i'){i++;}
            if(s.charAt(left)=='o'){o++;}
            if(s.charAt(left)=='u'){u++;}

            for(int right=left+1; right<s.length(); right ++){
                if(s.charAt(right)=='a'){a++;}
                if(s.charAt(right)=='e'){e++;}
                if(s.charAt(right)=='i'){i++;}
                if(s.charAt(right)=='o'){o++;}
                if(s.charAt(right)=='u'){u++;}

                if(a%2==0 && e%2==0 && i%2==0 && o%2==0 && u%2==0 && (right-left)>longest.length()) {
                    System.out.print(" a= "+a);
                    System.out.print(" e= "+e);
                    System.out.print(" i= "+i);
                    System.out.print(" o= "+o);
                    System.out.print(" u= "+u);
                    System.out.println(s.substring(left, right+1));
                    longest=s.substring(left, right+1);
                }
                //  if( (right-left)>longest.length()){
                // longest=s.substring(left, right);
                // }

            }
            if(s.charAt(left)=='a'){a--;}
            if(s.charAt(left)=='e'){e--;}
            if(s.charAt(left)=='i'){i--;}
            if(s.charAt(left)=='o'){o--;}
            if(s.charAt(left)=='u'){u--;}

        }
        return longest.length();
    }
}
