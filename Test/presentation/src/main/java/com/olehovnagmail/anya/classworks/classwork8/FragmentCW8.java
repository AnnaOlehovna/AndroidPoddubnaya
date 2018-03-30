package com.olehovnagmail.anya.classworks.classwork8;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.olehovnagmail.anya.R;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;


public class FragmentCW8 extends Fragment {

    public TextView textView;
    private ObservableContractCW observableContractCW;
    private Disposable disposable;

    public static FragmentCW8 getInstance(){
        return new FragmentCW8();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getLayoutInflater().inflate(R.layout.fragment_hw7_one,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.counter_one);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subscribe();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
        if(disposable!=null){
            disposable.dispose();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if(activity!=null){
            observableContractCW =(ObservableContractCW) activity;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        observableContractCW =null;
    }


    private void subscribe(){
        //здесь мы подписались на observable
        disposable = observableContractCW
                .getObservable()
                //позволяет что-то делать с данными перед передачей подписчику
//                .doOnNext(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//
//                    }
//                })
                //будут проходить только те инты, что деляться на 10 -  в данном случае
                //если true - то пропускает данные, если false  - не пропускает
//                .filter(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) throws Exception {
//                        return integer%10==0;
//                    }
//                })
                //трансформация одного типа данных в другой

                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return String.valueOf(integer);
                    }
                })

                //показывает сколько данных надо получить - в данном случае 5 раз мы получим уведомления
                //а потом отпишемся
               // .take(5)
                //непосредственно подписка  - без нее ничего не будет работать
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String string) throws Exception {
                        //сюда прилетают данные
                        textView.setText(string);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
