package br.com.marcelo.rxcourse.observables;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class ObserveOnTreadExample {

	public static void main(String[] args) {
		
		Object waitMonitor = new Object();
		
		synchronized (waitMonitor) {
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
			
			observable
				.observeOn(Schedulers.io())
				.subscribe(
					//onNext
					(i) -> {
						//if(i == 4) throw new RuntimeException("Error test");
						System.out.println("Thread " + i);
		                System.out.println("Observable thread " + Thread.currentThread().getName());
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
		
}
