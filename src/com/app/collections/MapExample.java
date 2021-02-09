package com.app.collections;

import java.util.Map;
import java.util.TreeMap;

public class MapExample {
	/*
	 * ****Map is not Child Interface of Collection****
	 * 
	 * 1).To Store data in key,value pairs we can go for Map(I)
	 * 2).Map(I) Implementation classes are
	 *    (i).   HashMap<T,T> m;
	 *    (ii).  LinkedHashMap<T,T> m;
	 *    (iii). TreeMap<T,T> m;
	 *    (iv).  IdentityHashMap<T,T> m;
	 *    (v).   WeekHashMap<T,T> m;
	 *    (vi).  NavigableHashMap<T,T> m;
	 */
	public static void main(String[] args) {
		Map<String,String> m=new TreeMap<>();
		m.put("Malavika","India");
		m.put("Emma","Britan");
		m.put("Dayana","Uk");
		m.put("Smith","Us");
		m.put("Loha", "Us");
		m.put("Jessika","Canada");
       
		m.entrySet().stream().forEach(s->System.out.println(s.getKey()+" : "+s.getValue()));

		/*Map<Entry<String, String>, Long> count=m.entrySet().stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

		System.out.println(count);

		m.forEach((k,v)->System.out.println(k+" : "+v));

		m.entrySet().stream().forEach(s->System.out.println(s.getKey()+" : "+s.getValue()));


		//see the power of lambdas and streams


		//itarating map elements
		m.entrySet().forEach(k->System.out.println(k.getKey()+" "+k.getValue()));
		//finding key starts with specific  char
		m.entrySet().stream().filter(s->s.getKey().startsWith("k")).forEach(s->System.out.println(s));


		List<String> l=Arrays.asList("saritha","namitha","haritha","mamatha","kavitha","susmitha");
		l.stream().filter(s->s.startsWith("k")).forEach(System.out::println);
		//customized sorting in single step
		l.stream().sorted((o1,o2)->o2.compareTo(o1)).forEach(s->System.out.print(s+" "));
		//finding longest string in given array
		l.stream().reduce((o1,o2)->(o1.length()>o2.length())?o1:o2).ifPresent(s->System.out.println(s));
		//finding each string repeated how many times
		Map<String,Long> ll=l.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		ll.entrySet().stream().forEach(s->System.out.print(s.getKey()+"="+s.getValue()+" "));

		//finding even numbers without any loop
		IntStream.range(1,100).filter(s->s%2==0).forEach(s->System.out.println(s));


		int a[]= {2,3,4,57,54,2,57,56,3};
		//itearting array eleemts 
		Arrays.stream(a).forEach(s->System.out.print(s+" "));
		System.out.println();
		//removing duplicates in an array
		Arrays.stream(a).distinct().forEach(s->System.out.print(s+" "));
		 */




		//SQL
		//finding 2nd max salary from given table and second minimum salary from a table
		//mysql> select esal from emp order by esal desc limit 1,1;
		//mysql> select esal from emp order by esal  limit 1,1;
	}


}
