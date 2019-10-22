package com.example.tutorial2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ImageView articleImg;
    TextView articleTitle;
    TextView articleAuthor;
    TextView articleContent;
    ImageButton share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        //Get Intent Details and Parse in details
        Intent intent = getIntent();
        long intentDetails = intent.getLongExtra("ID",0);

        //Creating the Articles
        String api = FakeApi.getMostViewedStoriesJsonString();
        Gson gson = new Gson();
        NYTime nyTime = gson.fromJson(api, NYTime.class);

        ArrayList<ViewedArticle> results = nyTime.getResults();
        ViewedArticle article = results.get(0);
        for (int x =0;x<results.size();x++){
            if (results.get(x).getId() == intentDetails){
                article = results.get(x);
                System.out.println("Hi");
            }
        }


        //Linking Xml Elements and Variables
        articleImg = findViewById(R.id.articleIv);
        articleTitle = findViewById(R.id.articleTitleTv);
        articleAuthor = findViewById(R.id.articleAuthorTv);
        articleContent = findViewById(R.id.articleContentIv);

        //Setting the details
        //TODO article img
        articleTitle.setText(article.getTitle());
        articleAuthor.setText(article.getByline());
        articleContent.setText(article.get_abstract());

        //Share Button Implicit Listener
        share = findViewById(R.id.shareBtn);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent implicitIntent = new Intent(Intent.ACTION_SEND);
                implicitIntent.setType("text/plain");
                startActivity(implicitIntent);
            }
        });


    }

}
