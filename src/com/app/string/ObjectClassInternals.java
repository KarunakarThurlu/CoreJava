package com.app.string;

import java.lang.reflect.Method;
import java.util.Arrays;

import com.app.model.Employee;

public class ObjectClassInternals {
/*
 * *). Object class is Root class for Entire Java.
 * *). Object class has 11 methods.
 *     1)hashCode().
 *     2)equals(Object o).
 *     3)clone().
 *     4)toString().
 *     5)notify().
 *     6)notifyAll().
 *     7)wait().
 *     8)wait(long l).
 *     9)wait(long l,int i).
 *     10)getClass()
 *     11)finalize()
 *     
 ******Object class equals method is for reference comparison.*******
 * 
 * *Contract Between hashCode() and equals() methods:-
 * ===================================================
 * If Two Objects are equal with respect to equals those two have same hash codes.
 * 
 * =============
 * (1)hashCode():-
 * =============For Every Object JVM will create an unique number that is HashCode.
 * * *The Main Advantage is "Searching will be very fast". 
 * * *Then the time complexity will be O(1).
 * Note:-
 * -------- toString() Vs hashCode()
 * 1). if we are giving chance to Object class toString() method it will internally calls hashCode() method.
 * 2). if we are over riding toString() method our toString() method may not call hashCode() method.
 * 
 * =====================
 * (2)equals(Object o):-
 * =====================We can equals(Object o) method to check equality of two Objects.
 * Ex:-obj1.equals(obj2)
 * =====================
 * 
 * 1). If our class dosn't override equals method then Object class equals(Object o) will be executed.
 * 2). Based on our requirement we can override equals(Object o) method for content comparison.
 * 3). While Overriding equals(Object o) method for content comparison we have to care about the following.
 *    (i). What is the meaning of equality(i.e weather we have to check only names,only roll numbers or both.
 *    (ii). if we are passing different type of Object our equals method CalssCastExcetion, i.e we have to handle CCE to return false.
 *    (iii). if we are passing null argument then our equals method should not raise NullPointerException,. i.e We have to handle NPE to return false;
 * Ex;-
 * ====
 * public boolean equals(Object obj) {
		try {
			String name1=this.name;
			int id1=this.id;
			Employee e=(Employee) obj; //ClassCastException
			String name2=e.getName(); //NPE
			int id2=e.getId(); //NPE
			if(name1.equals(name2) && id1==id2) {
				return true;
			}else {
				return false;
			}
		} catch (ClassCastException e) {
			return false;
		} catch(NullPointerException e) {
			return false;
		}
	}
 *    
 * =============
 * (4)toString():-
 * =============  getClass().getName+"@"+Integer.toHexTring(hashCode())
 * Note:- In All Wrapper classes,String,StringBuilder,StringBuffer,Collection classes toString() method is overridden for meaningful representation of content. 
 * 
 * ==========
 * (7)wait(),(8)notify():-
 * ==========
 * -We can use these methods for inter thread communication 
 * -the thread which is expecting updation ,it is responsible to call wait() method. then immediately the thread will entered into waiting state.
 * -the thread which is responsible to perform updation ,after performing updation the thread can call notify() method, the waiting thread will get that notification and continues its execution with those updates.
 * 
 * ===============
 * (10)getClass():- public final Class getClass();
 * ===============
 * -We can use getClass() method to get runtime class definition of an object.
 * -By using this Class class object we can access class level properties like ,fully qualified name of the class,methods information,constructor info etc.
 *  Ex-
 *  =====
 *      Object o=new String("foo");
		Class c=o.getClass();
		Method m[]=c.getDeclaredMethods();
		for(Method method : m) {
			System.out.println(method.getName());
		}
		System.out.println(c.getName());
 * 
 * -After loading every .class file JVM will create an object of the type java.lang.class in the heap area.
 * -programmer can use this class object to get class level information.
 * -we can use getClass() method very frequently in reflection API.
 * 
 * 
 * ==============
 * (11)finalize():-
 * ==============
 * -Just before destroying an object garbage collector calls finalize() method to perform cleanup activities.
 * -Once finalize() method completed automatically garbage collector destroys that object.
 * 
 * 
 */
	public static void main(String[] args) {
		String s[]=new String[5];
		Arrays.fill(s, "hello");
		Arrays.stream(s).forEach(System.out::println);
	}
}
