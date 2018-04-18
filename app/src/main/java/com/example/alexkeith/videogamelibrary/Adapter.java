package com.example.alexkeith.videogamelibrary;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by alexkeith on 4/16/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<VideoGame> videoGamesList;
    private ViewHolder.AdapterCallback adapterCallback;

    public Adapter(List<VideoGame> videoGamesList) {
        this.videoGamesList = videoGamesList;
        this.adapterCallback = adapterCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_game, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindGame(videoGamesList.get(position));
    }

    @Override
    public int getItemCount() {
        return videoGamesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView gameName;
        private TextView gameGenre;

        public interface AdapterCallback {

        }

        public ViewHolder(View itemView) {
            super(itemView);
            gameName = itemView.findViewById(R.id.add_game_title_editText);
            gameGenre = itemView.findViewById(R.id.add_game_genre_editText);
            itemView.setOnClickListener(this);
        }

        public void bindGame(int position) {
            gameName.setText(videoGamesList.get(position).getGameName());
            gameGenre.setText(videoGamesList.get(position).getGameGenre());
        }
        @Override
        public void onClick(View v) {
            videoGamesList.get(getAdapterPosition()).setGameName("New name!");
            notifyDataSetChanged();
        }
    }

}
