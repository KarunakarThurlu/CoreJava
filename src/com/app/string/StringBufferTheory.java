package com.app.string;

public class StringBufferTheory {
    /***if the content is fixed and won't change frequently then it is recommended to go for String
     *  if the content is not fixed and keep on changing then is not recommended to use String, B'z for every change a new object will be created which effects performance of the system.To handle this requirement we should go for StringBuffer.
     * * * String Buffer initial capacity is 16 * * * 
     *==============
     * Constructors:-
     *==============
     *(1)StringBuffer sb=new StringBuffer();
     *   ~ creates an empty StringBuffer object with default initial capacity 16.
     *   ~ Once StringBuffer reaches max capacity a new StringBuffer object will be created with [new capacity=Current Capacity+1)*2];
     *   ~example:
     *  StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());//16
        sb.append("abcdefghijklmnop");
        System.out.println(sb.capacity());//16
        sb.append("r");
        System.out.println(sb.capacity());//34
        
     *(2). StringBuffer sb=new StringBuffer(int initialCapacity);
     *    ~creates an empty String buffer object with specified initial capacity.
     *    
     *(3).StringBuffer sb=new StringBuffer(String str);
     *   ~For the given String equivalent StringBuffer object will be created.
     *   ~with capacity = s.length()+16
     *   Example:-
     *   ========
     *   StringBuffer sb = new StringBuffer("karun");
     *   System.out.println(sb.capacity());//(5+16)=21
     *
     *===============================================Important Methods====================
     * * *Important methods of StringBuffer * * *
     * # public int lenth()
     * 
     * # public int capacity()
     * 
     * # public char charAt(int index);
     * 
     *  * Example:-
     * =========
     *  StringBuffer sb = new StringBuffer("karun");
     *  System.out.println(sb.charAt(3));//u
     *  System.out.println(sb.charAt(30));//RE :StringIndexOutOfBoundsException: index 30,length 5
     *
     * # public void setCharAt(int index, char ch);
     * 
     * # public StringBuffer append(String str);//it is overloaded method of append(int i),append(byte b),append(long i),append(float f),append(boolean b).... etc.
     * 
     * Example:-
     *=========
        StringBuffer sb = new StringBuffer();
        sb.append("PI Value is : ");
        sb.append(3.14f);
        sb.append(" it is absolutely ");
        sb.append(true);
        System.out.println(sb);
        
      output:- PI Value is : 3.14 it is absolutely true
      ========
     * 
     * # public StringBuffer insert(int i,String s);// it is over loaded method of insert(int i,int j),insert(int i,float f),insert(int i,long l),,insert(int i,boolean b) .... etc.
     * 
     * Example:-
     * ========
     *  StringBuffer sb = new StringBuffer("karunakaryadav");
        sb.insert(9,"Thurlu");
        System.out.println(sb);
        
        output:-karunakarThurluyadav
        =======
     * 
     * # public StringBuffer delete(int startindex,int endindex)
     * 
     * 
     * # public StringBuffer deleteCharAt(int index)
     * 
     * 
     * # public StringBuffer reverse()
     * 
     * Example:-
     * =======
     *  StringBuffer sb = new StringBuffer("karunakaryadav");
        System.out.println(sb.reverse());
        
        output:-vadayrakanurak
        =======
     *
     * # public void setLenth(int i)
     * 
     * Example:-
     * ========
     *  StringBuffer sb = new StringBuffer("karunakaryadav");
        sb.setLength(9);
        System.out.println(sb);
        
        output:-karunakar
        -------
     *
     *  # public void ensureCapacity(int capacity_size)
     *    ~ To increase capacity on fly based requirement
     * 
     * Example:-
     * =========
     *  StringBuffer sb = new StringBuffer("karunakaryadav");
        sb.ensureCapacity(100);
        System.out.println(sb.capacity());
        
        output:-100
        ----------
     *
     * # public void trimToSize();
     *   ~To Release extra allocated memory
     *   
     * Example:-
     * =========
     * StringBuffer sb = new StringBuffer(100);
        sb.append("karunakar");
        System.out.println(sb.capacity());//100
        sb.trimToSize();
        System.out.println(sb.capacity());//9
     *   
     *  # 
     * * *The main advantage of StringBuffer over String is all required changes will be performed in existing object only.
     * 1).StringBuffer is mutable (modifications allowed). 
     * 2).Every Method present in StringBuffer is synchronized. 
     * 3).In StringBuffer equals() is for Reference Comparison(i.e it is inheriting from object class)
     * 4).We can't compare(==) String Objects with StringBuffer Object ,other wise we will incomparable type exception.
     * 
     * 
     */
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer(100);
        sb.append("karunakar");
        System.out.println(sb.capacity());
        sb.trimToSize();
        System.out.println(sb.capacity());
        
       
        

    }
}
