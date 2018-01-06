package com.guoyie.www.delivery.easy.rx;

import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class RxUtil {

    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
  /*  public static <T> Observable.Transformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }*/


  public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(io.reactivex.Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }


        };
    }



    /**
     * 从缓存取数据
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
   /* public static <T> Observable rxCreateDiskObservable(final String key, final Class<T> clazz) {
        Observable<T> on = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String json = ACache.get(GApp.getInstance()).getAsString(key);
                if (!TextUtils.isEmpty(json)) {
                    subscriber.onNext(json);

                }
                subscriber.onCompleted();
            }
        })
                .map(new Func1<String, T>() {
                    @Override
                    public T call(String s) {
                        return JSON.parseObject(s, clazz);
                    }

                })
                .subscribeOn(AndroidSchedulers.mainThread());
        return on;
    }
    */









/*

    public static <T> Observable.Transformer<T, T> rxCacheListHelper(final String key) {
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())//指定doOnNext执行线程是新线程
                        .doOnNext(new Action1<T>() {
                            @Override
                            public void call(final T data) {

                                Schedulers.io().createWorker().schedule(new Action0() {
                                    @Override
                                    public void call() {
                                        //通过反射获取List,再判空决定是否缓存
                                        Class clazz = data.getClass();
                                        Field[] fields = clazz.getFields();
                                        for (Field field : fields) {
                                            String className = field.getType().getSimpleName();
                                            // 得到属性值
                                            if (className.equalsIgnoreCase("List")) {
                                                try {
                                                    List list = (List) field.get(data);
                                                    if (!list.isEmpty()) {
                                                        ACache.get(GApp.getInstance())
                                                                .put(key, JSON.toJSONString(data));
                                                    }
                                                } catch (IllegalAccessException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        }
                                    }
                                });
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
*/

   /* public static <T> Observable.Transformer<T, T> rxCacheBeanHelper(final String key) {
        Observable.Transformer<T, T> transformer = new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable
                        .subscribeOn(Schedulers.io())//指定doOnNext执行线程是新线程
                        .doOnNext(new Action1<T>() {
                            @Override
                            public void call(final T data) {
                                Schedulers.io().createWorker().schedule(new Action0() {
                                    @Override
                                    public void call() {
                                        ACache.get(GApp.getInstance())
                                                .put(key, JSON.toJSONString(data));

                                    }
                                });
                            }
                        })
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };

        return transformer;
    }*/
}
