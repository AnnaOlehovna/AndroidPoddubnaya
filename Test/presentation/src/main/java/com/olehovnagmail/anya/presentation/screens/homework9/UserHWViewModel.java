package com.olehovnagmail.anya.presentation.screens.homework9;


import android.databinding.BindingAdapter;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.olehovnagmail.anya.presentation.base.BaseViewModel;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UserHWViewModel extends BaseViewModel {

    public ObservableField<String> imageUrl = new ObservableField<>();
    public ObservableField<String> surnameName = new ObservableField<>();
    public ObservableField<String> firstName = new ObservableField<>();
    public ObservableField<String> secondName = new ObservableField<>();
    public ObservableField<String> age = new ObservableField<>();
    public ObservableBoolean isMan = new ObservableBoolean();

   private User myUser = new User("https://petpop.cc/upload/post/2017/12/11/1715938/ulybayushyjsya-kot-29-23.jpg"
            , "Кузнецов", "Иван", "Алексеевич", 40, true);

    private Observable<User> observable = Observable.just(myUser);

    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myUser.setImageUrl("http://goodnewsanimal.ru/_nw/67/63811891.jpg");
            myUser.setAge(30);
            myUser.setMan(false);
            myUser.setFirstName("Надежда");
            myUser.setSecondName("Олеговна");
            myUser.setSurnameName("Милашка");
            observer.onNext(myUser);
        }
    });


    private Observer<User> observer = new Observer<User>() {
        @Override
        public void onSubscribe(Disposable d) {
            compositeDisposable.add(d);
        }

        @Override
        public void onNext(User user) {
                imageUrl.set(user.getImageUrl());
                surnameName.set(user.getSurnameName());
                firstName.set(user.getFirstName());
                secondName.set(user.getSecondName());
                age.set("Возраст: ".concat(String.valueOf(user.getAge())));
                isMan.set(user.isMan());
        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onComplete() {
        }
    };

    @Override
    public void createInject() {

    }

    @Override
    public void onResume() {
        observable.subscribe(observer);
        thread.start();
    }
    

    @BindingAdapter("android:src")
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(view);
    }
}
