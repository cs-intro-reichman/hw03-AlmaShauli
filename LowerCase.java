/** String processing exercise 1. */
public class LowerCase {
    public static void main(String[] args) {
        String str = args[0];
        System.out.println(lowerCase(str));
    }

    /**
     * Returns a string which is identical to the original string,
     * except that all the upper-case letters are converted to lower-case letters.
     * Non-letter characters are left as is.
     */
    public static String lowerCase(String s) {

        // 
        String newS = "";
        for (int i = 0; i < s.length(); i++) {

            //
            int x = s.charAt(i);

            //
            if (x > 64 && x < 91) {
                newS += (char) (x + 32);
            } else {
                newS += (char) (x);
            }
        }
        return newS;
    }
}
