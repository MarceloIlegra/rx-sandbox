package br.com.marcelo.rxcourse.observables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

import rx.Observable;
import rx.schedulers.Schedulers;

public class FutureCreationExample {
	
	public static void main(String[] args) {
		
		Observable<List<Integer>> observableFutureList;
		
		FutureTask<List<Integer>> future = new FutureTask<>(() -> {
			List<Integer> x = new ArrayList<Integer>();
			x.add(1);
			x.add(0);
			x.add(3);
			x.add(2);
			x.add(5);
			return x;
		});
		
		observableFutureList = Observable.from(future);
		
		Schedulers.computation().schedule(() -> {
			future.run();
		});
		
		observableFutureList.subscribe((list) -> {
			list.forEach((i) -> {
				System.out.println(i);
			});
		});
		
	}
	
}
