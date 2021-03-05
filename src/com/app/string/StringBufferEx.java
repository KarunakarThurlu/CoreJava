package com.app.string;

public class StringBufferEx {
    /*
     * 1).StringBuffer is mutable (modifications allowed). 2).Every Method present
     * in StringBuffer is synchronized. 3).In StringBuffer equls() is for Reference
     * Comparison.
     * 
     */
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        final String s = "foo";
        String ss = s + "foo2";
        System.out.println(ss);

    }
}
