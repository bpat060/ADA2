/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2.ada;

import java.util.Scanner;

/**
 *
 * @author Sheetal
 */
public class BruteForceMethod {

    public static void match(String txt, String pat) {
        int m = pat.length();
        int n = txt.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }

            if (j == n) {
                System.out.println("my pattern match at index" + i);
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
