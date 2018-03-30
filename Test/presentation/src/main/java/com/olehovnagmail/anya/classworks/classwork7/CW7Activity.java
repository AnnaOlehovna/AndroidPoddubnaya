package com.olehovnagmail.anya.classworks.classwork7;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.olehovnagmail.anya.R;

public class CW7Activity extends AppCompatActivity {

    FragmentManager manager = getSupportFragmentManager();

    private boolean isOneFragment = true;

    private SharedPreferences sharedPreferences;

    private static final String SHARED_PREFS_NAME = "jdfhgldfkj";
    private static final String KEY = "key_name";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw7);

        //возвращает внутренюю папку в котором находится приложение
        getFilesDir();
        //путь к папке в определенными общими файлами - музыка, фото
        //getExternalFilesDir();

        sharedPreferences = getSharedPreferences(SHARED_PREFS_NAME,
                Context.MODE_PRIVATE);


        findViewById(R.id.button_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment();
            }
        });

        //для того, чтобы андройд не открыл сверху еще один фрагмент
        //если до этого андройд убил активити и её пересоздает
        if(savedInstanceState==null){
            showFragment(MyFragmentOne.getInstance(manager),false);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences.edit().putString(KEY,"Hello").apply();

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("AAAA", sharedPreferences.getString(KEY,""));
    }

    private void changeFragment() {
        if (isOneFragment) {
            showFragment(MyFragmentTwo.getInstance(manager,5),true);
            isOneFragment = false;
        } else {
            showFragment(MyFragmentOne.getInstance(manager),true);
            isOneFragment = true;

        }

    }

    private void showFragment(Fragment fragment, boolean addToBackStack) {
        //из support.v4

        FragmentTransaction transaction = manager.beginTransaction();

        //fragment.getClass().getSimpleName() - в качестве тега
        transaction.replace(R.id.conteiner_frag, fragment, fragment.getClass().getSimpleName());
        if(addToBackStack) {
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        //завершение транзакции
        transaction.commit();

    }

}
