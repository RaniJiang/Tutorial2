package com.example.tutorial2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        int intentDetails = intent.getIntExtra("ID",0);
        //Creating the Articles
        Article article = FakeDatabase.getArticleById(intentDetails);

        //Linking Xml Elements and Variables
        articleImg = findViewById(R.id.articleIv);
        articleTitle = findViewById(R.id.articleTitleTv);
        articleAuthor = findViewById(R.id.articleAuthorTv);
        articleContent = findViewById(R.id.articleContentIv);

        //Setting the details
        //TODO article img
        articleTitle.setText(article.getHeadline());
        articleAuthor.setText(article.getAuthor());
        articleContent.setText(article.getContent());

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
