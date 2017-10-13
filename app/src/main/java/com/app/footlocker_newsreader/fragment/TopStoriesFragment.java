package com.app.footlocker_newsreader.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.footlocker_newsreader.R;
import com.app.footlocker_newsreader.adapter.NewsAdapter;
import com.app.footlocker_newsreader.restapi.api.BaseURL;
import com.app.footlocker_newsreader.restapi.api.NewsReaderAPI;
import com.app.footlocker_newsreader.restapi.model.Item;
import com.app.footlocker_newsreader.restapi.model.RootResponse;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TopStoriesFragment extends Fragment {

    @Bind(R.id.newsRecycler)
    RecyclerView storiesRV;

    private NewsReaderAPI newsReaderAPI;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        // Inflate the layout for this fragment
        final View mRootView = inflater.inflate(R.layout.news_fragment, container, false);
        ButterKnife.bind(this, mRootView);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        final DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),
                linearLayoutManager.getOrientation());
        storiesRV.addItemDecoration(dividerItemDecoration);
        storiesRV.setLayoutManager(linearLayoutManager);

        newsReaderAPI = BaseURL.getAPI();

        return mRootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        prepareNewsReaderCall();
    }

    /**
     * Method to make top stories web service call
     */
    private void prepareNewsReaderCall() {
        Call<RootResponse> call = newsReaderAPI.loadTopStories();
        call.enqueue(new Callback<RootResponse>() {
            @Override
            public void onResponse(Call<RootResponse> call, Response<RootResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    setUI(response.body().getItems());
                }
            }

            @Override
            public void onFailure(Call<RootResponse> call, Throwable t) {
                Toast.makeText(getContext(), "An error occurred", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Method to set data to the UI
     */
    private void setUI(List<Item> itemList) {
        final NewsAdapter adapter = new NewsAdapter(getContext(), itemList);
        storiesRV.setAdapter(adapter);
    }
}
