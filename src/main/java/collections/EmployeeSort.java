package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeSort {

	static Comparator<Employee> NAMESORT = new Comparator<Employee>(){
		
		public int compare(Employee e1,Employee e2){
			return e1.name.compareTo(e2.name);
		}
		
		
	};
	
	public static void print(List<Employee> empList){
		for (Employee o :empList){
			System.out.println(o.name);
		}
	}
	
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		Employee e = new Employee("anil");
		Employee e1 = new Employee("babe");
		Employee e2 = new Employee("akhil");
		
		empList=Arrays.asList(e,e1,e2);
			
	    print(empList);
		
		Collections.sort(empList,NAMESORT);
		 print(empList);
		
		
		
	}

}
