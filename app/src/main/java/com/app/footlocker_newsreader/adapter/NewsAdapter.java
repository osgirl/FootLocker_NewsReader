package com.app.footlocker_newsreader.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.footlocker_newsreader.R;
import com.app.footlocker_newsreader.activity.DetailActivity;
import com.app.footlocker_newsreader.restapi.model.Item;
import com.app.footlocker_newsreader.util.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private final List<Item> itemList;
    private final Context context;

    public NewsAdapter(Context context, List<Item> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        final Item item = itemList.get(position);
        if (item != null) {
            holder.title.setText(item.getTitle());

            if (item.getThumbnailUrl() != null && !item.getThumbnailUrl().isEmpty()) {
                Picasso.with(context).load(item.getThumbnailUrl()).into(holder.thumbNailImg);
            }

            holder.newsLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Intent intent = new Intent(context, DetailActivity.class);
                    final Bundle bundle = new Bundle();
                    bundle.putParcelable(Constants.NEWS_DETAILS, item);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return itemList != null ? itemList.size() : 0;
    }

    public class NewsHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.thumbNail)
        ImageView thumbNailImg;

        @Bind(R.id.title)
        TextView title;

        @Bind(R.id.newsLayout)
        LinearLayout newsLayout;

        public NewsHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}





