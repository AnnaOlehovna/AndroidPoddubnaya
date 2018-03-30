package com.olehovnagmail.anya.classworks.classwork6;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.olehovnagmail.anya.R;


import java.util.ArrayList;
import java.util.List;



public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<User> itemList = new ArrayList<>();
    private OnUserClickListener listener;

    public void setItems(List<User> userList) {
        this.itemList.clear();
        this.itemList.addAll(userList);

        //метод заставляет перерисовывать элементы
        notifyDataSetChanged();
    }


    public void setListener(OnUserClickListener listener){
        this.listener = listener;
    }

    //создает Холдер который содержит layout-xml с видом одного элемента
    //Холдер кешируется, т.е. для разных позиций может использоваться один и тот же холдер
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,
                parent,false);
        return new Holder(view);
    }


    //вызывается для каждого элемента и используется для заполнения данных item - один элемент
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        Holder myHolder = (Holder) holder;
        final User user = itemList.get(position);

        Glide.with(holder.itemView.getContext()).load(user.getImageURL()).apply(RequestOptions.circleCropTransform()).into(myHolder.image);
        myHolder.name.setText(user.getName());
        myHolder.surname.setText(user.getSurname());

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!= null)listener.onClick(user,holder.getAdapterPosition());
            }
        });

    }

    //количество эелементов которое будет
    @Override
    public int getItemCount() {
        return itemList.size();
    }


    //внутренний класс Холдер
    private static class Holder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        TextView surname;

        public Holder(View itemView) {
            super(itemView);
            Log.e("UserAdapter","Holder");
            image = itemView.findViewById(R.id.imageView_user);
            name = itemView.findViewById(R.id.textName);
            surname = itemView.findViewById(R.id.textSurname);
        }
    }


    interface OnUserClickListener{
        void onClick (User user, int position);
    }



}
