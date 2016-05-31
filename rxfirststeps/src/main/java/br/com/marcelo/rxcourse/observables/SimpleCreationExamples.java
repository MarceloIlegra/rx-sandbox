package br.com.marcelo.rxcourse.observables;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;


public class SimpleCreationExamples {
	
	public static void main(String args[]){
		
		Observable<Integer> observable = null;

		System.out.println("--------------------");
		System.out.println("Observable created from Object");
		System.out.println("--------------------");

		observable = Observable.from(Integer.valueOf(42));		
		observable.subscribe((i) -> {
			System.out.println(i);
		});		
		
		System.out.println("--------------------");
		System.out.println("Observable created from ArrayList");
		System.out.println("--------------------");
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(2);
		numbers.add(5);
		observable = Observable.from(numbers);		
		observable.subscribe((i) -> {
			System.out.println(i);
		});

		System.out.println("--------------------");
		System.out.println("Observable created from Array");
		System.out.println("--------------------");
		Integer[] numbersArray = {1, 2, 3};
		observable = Observable.from(numbersArray);		
		observable.subscribe((i) -> {
			System.out.println(i);
		});		
	}
	
}
