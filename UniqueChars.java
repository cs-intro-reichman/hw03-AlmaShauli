/** String processing exercise 2. */
public class uniquechars {
    public static void main(String[] args) {
        String str = args[0];
        System.out.println(uniqueChars(str));
    }

    /**
     * Returns a string which is identical to the original string,
     * except that all the duplicate characters are removed,
     * unless they are space characters.
     */
    public static String uniqueChars(String s) {

        // Sets new string
        String newS = "";

        for (int i = 0; i < s.length(); i++) {

            // Checks if the letter has already appeared

            if (newS.indexOf(s.charAt(i)) == -1) {

                // Adds the letter to the new word
                newS += s.charAt(i);
            } else {

                // Check if the character is space
                if (s.charAt(i) == ' ') {
                    newS += s.charAt(i);
                }
            }
        }

        return newS;
    }
}
