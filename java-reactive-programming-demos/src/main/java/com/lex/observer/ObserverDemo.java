package com.lex.observer;


import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;

/**
 * @author : Lex Yu
 */
public class ObserverDemo {
    public static void main(String[] args) {
        // rxjava 1
        Observable<Integer> observable = Observable.create(new Observable.OnSubscribe<Integer>(){
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 5; i++) {
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        });

        // Observable.subscribe(Observer), Observer Subscribe Observable
        Subscription subscribe = observable.subscribe(new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Completed !");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("Exception !");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Receiving Observable Pushing Data: " + integer);
            }
        });

    }
}
