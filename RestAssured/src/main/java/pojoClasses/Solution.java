package pojoClasses;

import java.util.Arrays;

class Solution {
    public static void main(String args[]) {

        char newstr[ 10] ="aabbba";

        int b_found = 0;
        int result = 1;
        for (int i = 0; newstr[i] != '\0'; i++) {
            if (newstr[i] == 'b') {
                b_found = 1;
            } else if ((newstr[i] == 'a')) {
                if (b_found == 0) {



                    /* 'a' is found after 'b' */
                    result = 0;
                }
            }
            System.out.println( result);
        }

    }
}
