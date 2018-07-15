package com.example.anurag.retrofit_task0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        SearchedCharacter searchedCharacter = RealmHelper.GetCharacterById(getIntent().getLongExtra("id", 0));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        if(searchedCharacter == null){
            Toast.makeText(this, "Sorry Character not found", Toast.LENGTH_SHORT).show();
            return;
        }

        TextView textView = findViewById(R.id.info);
        String information = "<b>Name - </b>" + searchedCharacter.getData().getName() + "<br><br>" +
                "<b>Male - </b>" + searchedCharacter.getData().getMale() +   "<br><br>"  +
                "<b>Slug Name - </b>" + searchedCharacter.getData().getSlug() +   "<br><br>"   +
                "<b>House - </b>" + searchedCharacter.getData().getHouse() +   "<br><br>"  +
                "<b>Books - </b>" + searchedCharacter.getData().getBooks().toString().replace("RealmList@", "") +   "<br><br>"  +
                "<b>Titles - </b>" + searchedCharacter.getData().getTitles().toString().replace("RealmList@", "");

        ImageView imageView = findViewById(R.id.image);
        String imageUrl = "https://api.got.show" + searchedCharacter.getData().getImageLink();
        if(searchedCharacter.getData().getImageLink() != null) {
            Picasso.get().load(imageUrl).into(imageView);
        }else{
           imageView.setBackgroundResource(R.mipmap.ic_launcher);
        }
        textView.setText(Html.fromHtml(information));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //do whatever
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
