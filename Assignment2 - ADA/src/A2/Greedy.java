/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A2;

/**
 *
 * @author Sheetal
 */
public class Greedy {

    public static void NQueenFunc(int N, int[][] qBoard, int i1, int j1, boolean isFound) {
        //Check condition
        if (!isFound) {
            //Check condition
            if (IsValidOne(qBoard, i1, j1)) {
                //Initialize
                qBoard[i1][j1] = 1;

                //Check condition
                if (i1 == N - 1) {
                    //Update
                    isFound = true;

                    //Function call
                    ShowBoard(qBoard);
                }

                //Function call
                NQueenFunc(N, qBoard, i1 + 1, 0, isFound);
            } //Otherwise
            else {
                //Loop
                while (j1 >= N - 1) {
                    //Function call
                    int[] arr = BackTrackingDFSGreedy(qBoard, i1, j1);

                    //Update
                    i1 = arr[0];
                    j1 = arr[1];
                }

                //Function call
                NQueenFunc(N, qBoard, i1, j1 + 1, false);
            }
        }

    }
