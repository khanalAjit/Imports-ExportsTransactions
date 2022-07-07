/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SAR_Transactions;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class SortSearch {

    static int jIndexInAll;

    public static ArrayList<Integer> sort(ArrayList<Integer> a, ArrayList<String> all) {   //method to sort all the data passed

        for (int i = 0; i < a.size() - 1; i++) {                                 //sorting the totalPrice arraylist
            int minPos = minimumPosition(a, i);
            swap(a, minPos, i, all);
        }
        return a;
    }

    private static int minimumPosition(ArrayList<Integer> a, int form) {        //finds the minmun postion in an arraylist and returns its value
        int minPos = form;        //min postion = 0;
        for (int i = form + 1; i < a.size(); i++) {
            if (a.get(i) < a.get(minPos)) {
                minPos = i;
            }
        }
        return minPos;
    }

    public static void swap(ArrayList<Integer> a, int i, int j, ArrayList<String> all) {   //swap two variables
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
        int jIndex = j;                                                    //swapping the passed variables places (i and J) in totalPrice arraylist
        int iIndex = i;  

        if (jIndex == 0) {                                                      //swapping the rows of the variables (i and j) in all arraylist
            jIndexInAll = 7; 
        } else {
            jIndexInAll = ((jIndex + 1) * 8) - 1; 
        }
        int iIndexInAll = ((iIndex + 1) * 8) - 1; 
        for (int k = 7; k >= 0; k--) {
            String tempo = all.get(jIndexInAll - k);
            all.set(jIndexInAll - k, all.get(iIndexInAll - k));
            all.set(iIndexInAll - k, tempo);
        }

    }

    public static void binarySearch(ArrayList<Integer> arr, int key) {         //binaray search method for searchig  whether if the entred price exsist in the table
        int first = 0;
        int last = arr.size() - 1;
        int mid = (first + last) / 2;
        while (first <= last) {
            if (arr.get(mid) < key) {
                first = mid + 1;
            } else if (arr.get(mid) == key) {
                JOptionPane.showMessageDialog(null, "This price is available in the table. Press ok for displaying the name.");
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            JOptionPane.showMessageDialog(null, "Item of the given price not found.");
        }
    }

}
