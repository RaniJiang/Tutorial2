package com.example.tutorial2;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.tutorial2.ArticleAdapter;

public class ArticleViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public ImageView articleImg;
    public TextView articleTitle;
    public TextView articleSummary;
    public Button articleButton;

    public ArticleViewHolder(View v){
        super(v);
        view = v;
        articleImg = v.findViewById(R.id.iV);
        articleTitle = v.findViewById(R.id.tVt);
        articleSummary = v.findViewById(R.id.tV);
        articleButton = v.findViewById(R.id.btn);
    }




}
