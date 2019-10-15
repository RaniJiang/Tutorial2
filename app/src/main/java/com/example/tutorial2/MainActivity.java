package com.example.tutorial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    //Create xml view links
    ImageButton articlesbtn;
    ImageButton booksBtn;
    ImageButton profileBtn;

    //Create Frag links
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ArticlesFrag articlesFrag;
    ProfileFrag profileFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declare Frags
        articlesFrag = new ArticlesFrag();
        profileFrag = new ProfileFrag();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, articlesFrag);
        fragmentTransaction.commit();

        //Declare Views
        articlesbtn = findViewById(R.id.articlesBtn);
        booksBtn = findViewById(R.id.booksBtn);
        profileBtn = findViewById(R.id.profileBtn);

        //Create onClick Listeners
        articlesbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frameLayout, articlesFrag);
                transaction.addToBackStack(null);
                transaction.commit();
//                view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//                booksBtn.setDrawingCacheBackgroundColor(getResources().getColor(R.color.light));
//                articlesbtn.setDrawingCacheBackgroundColor(getResources().getColor(R.color.light));
            }
        });

        profileBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frameLayout, profileFrag);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }



}
