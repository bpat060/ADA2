/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A2;

import java.util.Scanner;

/**
 *
 * @author Sheetal
 */
public class BruteForceMethod {

    public static void match(String txt, String pat) {
        int first = pat.length();
        int second = txt.length();

        for (int l = 0; l <= second - first; l++) {
            int z;
            for (z = 0; z < first; z++) {
                if (txt.charAt(l + z) != pat.charAt(z)) {
                    break;
                }
            }

            if (z == second) {
                System.out.println("my pattern match at index" + l);
            }
        }
    }

    public static void main(String args[]) {

        System.out.println("Single Run Test");

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        String p = sc.next();

        String text = s;

        String pattern = p;

        match(text, pattern);
    }

}
