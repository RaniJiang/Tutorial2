package com.example.tutorial2.ArticleFragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutorial2.DetailActivity;
import com.example.tutorial2.R;
import com.example.tutorial2.model.ViewedArticle;

import java.util.ArrayList;


public class ArticleAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    ArrayList<ViewedArticle> articles;

    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article, parent, false);
        ArticleViewHolder articleViewHolder = new ArticleViewHolder((view));
        return articleViewHolder;

    }

    //onclick give onclick listener
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, final int position){
        final ViewedArticle articleAtPosition = articles.get(position);
        //TODO: Store url at img and display url - don't worry for now
        holder.articleTitle.setText(articleAtPosition.getTitle());
        holder.articleSummary.setText(articleAtPosition.get_abstract());

        holder.view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("ID",articleAtPosition.getId());
                v.getContext().startActivity(intent);

            }
        });

    }

    public int getItemCount(){
        return articles.size();
    }

    public void setData(ArrayList<ViewedArticle> a){
        articles = new ArrayList<>(a);
    }





}
