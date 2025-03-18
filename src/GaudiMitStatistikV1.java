public class GaudiMitStatistikV1 {
    public static void main(String[] args) {

        String content = "Fuck you, c#nt 123!!";
        char[] contentArray =content.toCharArray();
        
        int uppercase = 0;
        int lowercase = 0;
        int number = 0;
        int specialChar = 0;

        for (int i = 0; i < contentArray.length; i++) {
            char c = content.charAt(i);
            if ((c >= 'A') && (c<= 'Z')) // they are redundant; the () I mean
                uppercase++;
            else if (c >= 'a' && c <= 'z')
                lowercase++;
            else if (c >= '0' && c <= '9')
                number++;
            else
                specialChar++;
        }

        System.out.println("Content: " + content + "\n" + "Uppercase: " + uppercase + "\n" + "Lowercase: " + lowercase + "\n" + "Numbers: " + number + "\n" + "Other Characters: " + specialChar);
    }
}
