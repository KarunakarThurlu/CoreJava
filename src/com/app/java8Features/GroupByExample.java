package com.app.java8Features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.app.model.Employee;
import com.app.model.Product;

public class GroupByExample {
	public static void main(String[] args) {
		//Example 1
		List<String> l=Arrays.asList("java","groovy","spark","spring","java","kotlin","scala","spring");
		Map<String,Long> m= l.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(m);
		
		//Example 2
		List<Employee> emps=Arrays.asList(new Employee(1,"karun"),
				                          new Employee(2,"varun"),
				                          new Employee(3,"meanon"),
				                          new Employee(4,"varun"));
		
		Map<String,Long> e1= emps.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));
		System.out.println(e1);
		
		//Example 3
		Map<String,List<Employee>> e2= emps.stream().collect(Collectors.groupingBy(Employee::getName));
		System.out.println(e2);
		
		//Example 4	
		List<Product> products=Arrays.asList(new Product(1,"MI",9999.00),new Product(2,"Apple8",23999.00),new Product(3,"Apple",23999.00),new Product(4,"Apple",123999.00),new Product(5,"Samsung",13999.00),new Product(6,"moto",13999.00));
		Map<String,Double> p1= products.stream().collect(Collectors.groupingBy(Product::getName,Collectors.summingDouble(Product::getPrice)));
		System.out.println(p1);
		
		//Example 5
		Map<Double,List<Product>> p2= products.stream().collect(Collectors.groupingBy(Product::getPrice));
		System.out.println(p2);

	}
}
