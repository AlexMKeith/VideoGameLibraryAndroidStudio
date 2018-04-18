package com.example.alexkeith.videogamelibrary;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by alexkeith on 4/16/18.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<VideoGame> videoGamesList;
    private AdapterCallback adapterCallback;

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
        holder.itemView.setOnClickListener(holder.onClick(videoGamesList.get(position));
        holder.itemView.setOnLongClickListener();
    }

    @Override
    public int getItemCount() {
        return videoGamesList.size();
    }
    public void updateList(List<VideoGame> list) {
        videoGamesList = list;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.item_row_layout)
        protected RelativeLayout rowLayout;
        @BindView(R.id.item_title)
        protected TextView gameTitle;
        @BindView(R.id.item_date)
        protected TextView gameDate;
        @BindView(R.id.item_genre)
        protected TextView gameGenre;
//        private TextView gameName;
//        private TextView gameGenre;
//        private TextView gameDate;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            gameTitle = itemView.findViewById(R.id.add_game_title_editText);
            gameGenre = itemView.findViewById(R.id.add_game_genre_editText);
            gameDate = itemView.findViewById(R.id.item_date);
            itemView.setOnClickListener(this);
        }

        public void bindGame(VideoGame videoGame) {
            gameTitle.setText(videoGame.getGameTitle());
            gameGenre.setText(videoGame.getGameGenre());
            gameDate.setText(videoGame.getDate().toString());
        }
        @Override
        public void onClick(View v) {
            videoGamesList.get(getAdapterPosition()).setGameTitle("New name!");
            notifyDataSetChanged();
        }
    }
    public interface AdapterCallback {

    }

}
