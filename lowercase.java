/** String processing exercise 1. */
public class lowercase {
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

        // Set new string
        String newS = "";

        for (int i = 0; i < s.length(); i++) {

            // Set x to a certain letter
            int x = s.charAt(i);

            // Check is it a capital letter
            if (x > 64 && x < 91) {
                newS += (char) (x + 32);
            } else {
                newS += (char) (x);
            }
        }
        return newS;
    }
}
