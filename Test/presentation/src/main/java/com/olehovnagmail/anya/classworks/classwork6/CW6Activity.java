package com.olehovnagmail.anya.classworks.classwork6;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.olehovnagmail.anya.R;

import java.util.ArrayList;

public class CW6Activity extends AppCompatActivity {

    private static final String TAG = CW6Activity.class.getSimpleName();

    private RecyclerView recyclerView;

    UserListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw6);

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("http://sovet-ok.ru/wp-content/uploads/2017/03/1.jpeg","User1","A"));
        users.add(new User("http://sovet-ok.ru/wp-content/uploads/2017/03/1.jpeg","User2","B"));
        users.add(new User("http://sovet-ok.ru/wp-content/uploads/2017/03/1.jpeg","User3","C"));
        users.add(new User("http://sovet-ok.ru/wp-content/uploads/2017/03/1.jpeg","User4","D"));
        users.add(new User("http://sovet-ok.ru/wp-content/uploads/2017/03/1.jpeg","User5","E"));

        adapter = new UserListAdapter();
        adapter.setItems(users);
        adapter.setListener(new UserListAdapter.OnUserClickListener() {
            @Override
            public void onClick(User user, int position) {
                Toast.makeText(CW6Activity.this,user.getName()+" position "+position,
                        Toast.LENGTH_SHORT).show();
            }
        });


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);






    }
}
