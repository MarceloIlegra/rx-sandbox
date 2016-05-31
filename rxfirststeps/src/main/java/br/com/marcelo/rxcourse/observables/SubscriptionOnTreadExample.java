package br.com.marcelo.rxcourse.observables;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class SubscriptionOnTreadExample {

	public static void main(String[] args) {
	
		System.out.println("------------------");
		System.out.println("Thread: " + Thread.currentThread().getName());
		System.out.println("------------------");
		
		
		List<Integer> intList = new ArrayList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		intList.add(4);
		intList.add(5);
		Observable<Integer> observable = Observable.from(intList);
		
		observable.subscribe(
				//onNext
				(i) -> {
					//if(i == 4) throw new RuntimeException("Error test");
					System.out.println("Thread: " + Thread.currentThread().getName());
					System.out.println(i);
					System.out.println("Thread: " + Thread.currentThread().getName());
					System.out.println("");
				},
				//onError
				(t) -> {
					t.printStackTrace();
				},
				//onCompleted
				() -> {
					System.out.println("Completed");
				}
		);
		
	}
		
}
