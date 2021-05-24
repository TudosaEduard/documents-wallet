package com.example.registerandlogin.document;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.registerandlogin.R;
import com.example.registerandlogin.objects.Items;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder> {
    private ArrayList <Items> items = new ArrayList<>();
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item);
        }
    }

    public Adapter(ArrayList<Items> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Adapter.ViewHolder holder, int position) {
        Items currentItem = items.get(position);
        holder.textView.setText(currentItem.getText());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ViewPhotoActivity.class);
                intent.putExtra("rawPhoto", currentItem.getPhotoData());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
