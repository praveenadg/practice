package test.String;

public class UserNameValidation {
    public static String CodelandUsernameValidation(String str) {
        if(str==null || str.length()<4 || str.length()>25 || !Character.isAlphabetic(str.charAt(0)) ||
                str.charAt(str.length()-1)=='-')
            return "false";
        for(Character c : str.toCharArray()){
            if(!Character.isAlphabetic(c) && !Character.isDigit(c) && c!='_'){
                return "false";
            }
        }
        return "true";

    }

    public static void main (String[] args) {
        // keep this function call here

        System.out.print(CodelandUsernameValidation("u__hello_world123"));
    }

}
