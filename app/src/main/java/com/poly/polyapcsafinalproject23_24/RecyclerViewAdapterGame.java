package com.poly.polyapcsafinalproject23_24;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapterGame extends RecyclerView.Adapter<RecyclerViewAdapterGame.MyViewHolder> {
    Context context;
    private OnItemClickListener listener;
    ArrayList<ModelGame> gameModels;

    public interface OnItemClickListener {
        void onItemClick(ModelGame modelGame);
    }

    public RecyclerViewAdapterGame(Context context, ArrayList<ModelGame> gameModels) {
        this.context = context;
        this.gameModels = gameModels;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(R.layout.recycler_view_row, parent, false));
    }

    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(this.gameModels.get(position), this.listener);
    }

    public int getItemCount() {
        return this.gameModels.size();
    }

    public void setOnClickListener(OnItemClickListener listener2) {
        this.listener = listener2;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvAuthor;
        TextView tvTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            this.tvAuthor = (TextView) itemView.findViewById(R.id.tv_author);
        }

        public void bind(final ModelGame model, final OnItemClickListener listener) {
            this.tvTitle.setText(model.getGameName());
            this.tvAuthor.setText(model.getAuthorName());
            Log.d("bind", model.getGameName()  );
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Log.d("click", model.getGameName());
                    listener.onItemClick(model);
                }
            });
        }
    }
}
