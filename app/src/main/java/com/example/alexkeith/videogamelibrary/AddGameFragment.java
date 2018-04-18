package com.example.alexkeith.videogamelibrary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddGameFragment extends Fragment {

    private ActivityCallback activityCallback;
    private VideoGameDatabase videoGameDatabase;
    @BindView(R.id.add_game_title_editText)
    private String gameTitle;
    @BindView(R.id.add_game_genre_editText)
    private String genre;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_game, container, false);
        ButterKnife.bind(this, view);
        
        return view;
    }

    public static AddGameFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AddGameFragment fragment = new AddGameFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onStart() {
        super.onStart();
        videoGameDatabase = ((VideoGameApplication) getActivity().getApplicationContext()).getDatabase();
    }

    @OnClick(R.id.add_game_fab)
    protected void addButtonClicked() {
        if (gameTitle.getText().toString().isEmpty() || genre.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Please input all options.", Toast.LENGTH_LONG).show();
        } else {
            String gameTitle = gameTitle.getText().toString();
            String genre = genre.getText().toString();
            addGameToDatabase(gameTitle, genre);
            Toast.makeText(getActivity(), "Game Added!", Toast.LENGTH_LONG).show();
        }
    }
    private void addGameToDatabase(final String gameName, final String genre) {
        VideoGame videoGame = new VideoGame(gameName, genre, new Date());
        videoGameDatabase.videoGameDao().addVideoGame(videoGame);
        activityCallback.addClicked();
    }
    public void attachParent(ActivityCallback activityCallBack) {
        this.activityCallback = activityCallback;
    }
    public interface ActivityCallback {
        void addClicked();
//        @BindView()
    }
}
