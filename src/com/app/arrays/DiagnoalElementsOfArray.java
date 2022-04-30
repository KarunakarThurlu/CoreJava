package com.app.arrays;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.List;

public class DiagnoalElementsOfArray {

    private static final Logger logger = System.getLogger(DiagnoalElementsOfArray.class.getName());
    public static void main(String[] args) {
        int[][] array = {
            {11,21,93,74},
            {62,70,83,99},
            {10,11,23,13},
            {34,21,56,89}
        };
        
        logger.log(Level.INFO,getDiagonalElements(array));
        logger.log(Level.INFO,getBelowDiagonalElements(array));
        logger.log(Level.INFO,getAboveDiagonalElements(array));
    }
    public static  List<Integer> getDiagonalElements(int[][] array){
        int count=array.length-1;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i<array.length; i++) {
            list.add(array[i][count]);
            count--;
        }
        return list;
    }
    public static  List<Integer> getBelowDiagonalElements(int[][] array){
        int count=array.length-1;
        List<Integer> list=new ArrayList<>();
        int tempCount=count;
        for (int i = 0; i<array.length; i++) {
           for(int j=tempCount;j<array.length;j++){
               list.add(array[i][j]);
           }
           tempCount=count;
           tempCount=tempCount-(i+1);
        }
        return list;
    }
    public static List<Integer> getAboveDiagonalElements(int[][] array){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <=i; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }
}
