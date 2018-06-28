package com.example.android.miwok;

/**
 * Created by skh on 13-04-2017.
 */
public class Word {
    private String miwokWord, defaultWord;

    private int imageResourceId = 0,audioFileResourceId = R.raw.number_one;
        //R.id.resource_name returns 0 if no such resource is found.
        //b.t.w. 0 is a invalid(say.null) resource id.

    public Word(String defaultWord, String miwokWord) {
        this.miwokWord = miwokWord;
        this.defaultWord = defaultWord;
    }

    public Word(String defaultWord, String miwokWord,int imageResourceId) {
        this.miwokWord = miwokWord;
        this.defaultWord = defaultWord;
        this.imageResourceId = imageResourceId ;
    }

    public Word(String defaultWord, String miwokWord,int imageResourceId,int audioFileResourceId)
    {
        this.defaultWord = defaultWord;
        this.miwokWord = miwokWord;
        this.imageResourceId = imageResourceId;
        this.audioFileResourceId = audioFileResourceId;
    }

    public String getMiwokWord()

    {
        return (this.miwokWord);
    }

    public String getDefaultWord()
    {
        return this.defaultWord;
    }

    public int getImageResourceId ()
    {
        return imageResourceId ;
    }

    public void setMiwokWord(String miwokWord)
    {
        this.miwokWord = miwokWord; return;
    }

    public void setDefaultWord(String defaultWord)
    {
        this.defaultWord = defaultWord;
        return;
    }

    public void setImageResourceId (int imageResourceId)
    {
        this.imageResourceId = imageResourceId ;
        return;
    }

    public int getAudioFileResourceId() {
        return audioFileResourceId;
    }

    public void setAudioFileResourceId(int audioFileResourceId) {
        this.audioFileResourceId = audioFileResourceId;
    }
}
