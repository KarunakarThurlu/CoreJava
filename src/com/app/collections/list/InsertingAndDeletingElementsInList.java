package com.app.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertingAndDeletingElementsInList {
	public static void main(String[] args) {
		System.out.println("========================================");
		List<Integer> list=new ArrayList<>();
		System.out.println("Enter List Size :");
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
		System.out.println("Enter "+size+" elements with space separated :");
		for(int i=0;i<size;i++) {
			list.add(sc.nextInt());
		}
		System.out.println("Enter Number of Questions :");
		int Q=sc.nextInt();
		for(int i=0;i<Q;i++) {
			System.out.println("Enter any One Insert Or Delete:");
			String s=sc.next();
			if(s.equals("Insert")) {
				System.out.println("Enter index , value :");
				int index=sc.nextInt();
				int value=sc.nextInt();
				list.add(index,value);
			}else {
				System.out.println("Enter index :");
				int index=sc.nextInt();
				list.remove(index);
			}
		}
		System.out.println("========================================");
		System.out.print("final list :  ");
		list.stream().forEach(s->System.out.print(s+" "));
		sc.close();
	}
}
/*Sample Output Example:-
========================================
Enter List Size :
5
Enter 5 elements with space separated :
12 34 56 78 90
Enter Number of Questions :
2
Enter any One Insert Or Delete:
Insert
Enter index , value :
4 100
Enter any One Insert Or Delete:
Delete
Enter index :
1
========================================
final list :  12 56 78 100 90 
*/