package com.app.footlocker_newsreader.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.footlocker_newsreader.R;
import com.app.footlocker_newsreader.restapi.model.Item;
import com.app.footlocker_newsreader.util.Constants;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @Bind(R.id.thumbNail)
    ImageView thumbNailImg;

    @Bind(R.id.title)
    TextView title;

    @Bind(R.id.description)
    TextView description;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        final Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        if (bundle != null && bundle.containsKey(Constants.NEWS_DETAILS)) {
            final Item item = bundle.getParcelable(Constants.NEWS_DETAILS);
            if (item != null) {
                title.setText(item.getTitle());
                description.setText(item.getDescription());
                Picasso.with(this).load(item.getThumbnailUrl()).into(thumbNailImg);
            }
        }
    }
}
