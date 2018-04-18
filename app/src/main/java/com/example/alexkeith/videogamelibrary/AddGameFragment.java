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
    @OnClick(R.id.add_game_fab)
    protected void addButtonClicked() {
        if (gameTitle.getText().toString().isEmpty() || gameGenre.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Please input all options.", Toast.LENGTH_LONG).show();
        } else {
            String gameName = gameTitle.getText().toString();
            String gameGenre = genre.getText().toString();
            callback.saveQuestion(videoGame);
        }
    }
    private void addGameToDatabase(final String gameName, final String genre) {
        VideoGame videoGame = new VideoGame(gameName, genre, new Date);
    }
    public void attachParent(ActivityCallback activityCallBack) {
        this.activityCallback = activityCallback;
    }
    public interface ActivityCallback {
        @BindView()
    }
}
