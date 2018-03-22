package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

   private MediaPlayer mMediaPlayer;
   private AudioManager mAudioManager;

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener(){
       public void onCompletion(MediaPlayer m){
           releaseMediaPlayer();
       }
   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        mAudioManager= (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
       final  ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son, R.raw.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather, R.raw.family_grandfather));


        //LinearLayout rootView = findViewById(R.id.rootView);


        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_family);
        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(wordAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this, words.get(position).getSound());



                AudioManager.OnAudioFocusChangeListener listnr = new AudioManager.OnAudioFocusChangeListener(){
                    public void onAudioFocusChange(int focusChange){

                        if(focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT){
                            mMediaPlayer.pause();
                        }
                        if(focusChange==AudioManager.AUDIOFOCUS_LOSS){
                            mMediaPlayer.stop();
                        }
                    }
                };
                int res = mAudioManager.requestAudioFocus(listnr, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                //AudioManager.requestAudioFocus();


                if(res == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    mMediaPlayer.start();
                }


                mMediaPlayer.setOnCompletionListener(onCompletionListener);

                mAudioManager.abandonAudioFocus(listnr);
            }
        });
    }


    private void releaseMediaPlayer(){

        if(mMediaPlayer!= null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
