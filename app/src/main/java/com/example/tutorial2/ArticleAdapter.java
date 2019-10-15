package com.example.tutorial2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    ArrayList<Article> articles;

    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article, parent, false);
        ArticleViewHolder articleViewHolder = new ArticleViewHolder((view));
        return articleViewHolder;

    }

    //onclick give onclick listener
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, final int position){
        final Article articleAtPosition = articles.get(position);
        //TODO: Store url at img and display url - don't worry for now
        holder.articleTitle.setText(articleAtPosition.getHeadline());
        holder.articleSummary.setText(articleAtPosition.getSummary());

        holder.view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("ID",articleAtPosition.getArticleID());
                v.getContext().startActivity(intent);
            }
        });

    }

    public int getItemCount(){
        return articles.size();
    }

    public void setData(ArrayList<Article> a){
        articles = new ArrayList<>(a);
    }





}
