package com.example.android.miwok;

/**
 * Created by Ala on 03/03/2018.
 */

public class Word {


    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;


    /** image id that we use ito illustrate the word */

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private  static final int NO_IMAGE_PROVIDED = -1;

    private int mSound;
    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int sound) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
        mSound =sound;
    }


    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Word(String defaultTranslation, String miwokTranslation, int sound) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSound= sound;
    }


    /**the default constructor
     * *
     * *
     *
     */



    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the id of the image we need to illutrate with
     */


    public int getImageResourceId(){

        return mImageResourceId;
    }


    public boolean hasImage(){


        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
    public int getSound(){

        return mSound;
    }


    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mSound=" + mSound +
                '}';
    }
}
