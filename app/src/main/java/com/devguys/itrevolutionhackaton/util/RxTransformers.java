package com.devguys.itrevolutionhackaton.util;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Helper class for common observable transformations
 */
public final class RxTransformers {

    /**
     * Apply standard {@link Schedulers}: io for {@link Observable}, ui for {@link Subscriber}
     */
    public static <T> Observable.Transformer<T, T> applyApiRequestSchedulers() {
        return tObservable -> tObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * Run code before running observable {@link Observable} and after its termination
     *
     * @param before code that will run onSubscribe
     * @param after  code that will run afterTerminate. This will not call if Observable doesn't emit
     *               {@code onCompleted} or {@code onError}
     * @param <T>    {@link Object}
     * @return {@link Observable}
     */
    public static <T> Observable.Transformer<T, T> applyOnBeforeAndAfter(Action0 before, Action0 after) {
        return tObservable -> tObservable
                .doAfterTerminate(after)
                .doOnUnsubscribe(after)
                .doOnSubscribe(before);
    }
}
