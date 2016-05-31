package br.com.marcelo.rxcourse.observables;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class ObserveOnParallelTreadExample {

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
			intList.add(1);
			intList.add(2);
			intList.add(3);
			intList.add(4);
			intList.add(5);			
			intList.add(1);
			intList.add(2);
			intList.add(3);
			intList.add(4);
			intList.add(5);
			Observable<Integer> observable = Observable.from(intList);
			
			observable
				.subscribeOn(Schedulers.newThread())
				.parallel((a) -> {
					
					return a.filter((i) -> {
						System.out.println("---");
						return i != 0;
					}).doOnNext((xx) -> {
						System.out.println("Thread " +xx);
		                System.out.println("Observable thread " + Thread.currentThread().getName());
					});
						
				}, Schedulers.io())
				.subscribe(
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
		
}
