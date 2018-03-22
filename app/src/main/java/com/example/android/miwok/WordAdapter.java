package com.example.android.miwok;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ala on 03/03/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {

int mColor;
Context contextC;
    MediaPlayer mp;
    /**
     * Create a new {@link WordAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param words is the list of {@link Word}s to be displayed.
     */
    public WordAdapter(Context context, ArrayList<Word> words, int color) {
        super(context, 0, words);

        mColor=color;
contextC = context;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);




       LinearLayout backgroudView = listItemView.findViewById(R.id.linear_text);
        int color = ContextCompat.getColor(getContext(), mColor);
        backgroudView.setBackgroundColor(color);


// Find the TextView in the list_item.xml layout with the ID miwok_text_view.


        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the Miwok translation from the currentWord object and set this text on
        // the Miwok TextView.
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID default_text_view.
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        defaultTextView.setText(currentWord.getDefaultTranslation());




// Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView  = listItemView.findViewById(R.id.image_view);



        if(currentWord.hasImage()){

// Set the ImageView to the image resource specified in the current Word
            imageView.setImageResource(currentWord.getImageResourceId());

        }
        else{

    imageView.setVisibility(View.GONE);

        }


        /*
        Context context;
        Button bt = listItemView.findViewById(R.id.playbutton);

        mp = MediaPlayer.create(contextC,currentWord.getSound() );

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();


            }

        });

*/


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;

    }


}
