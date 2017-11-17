package com.twobasetechnologies.recylerviewwithswipeonrefresh.DataModel;

/**
 * Created by suraj on 27/10/17.
 */

public class Developer {

    private  String name;

    private  String Language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    private  String Rating;


    public  Developer(String name,String language,String rating)
    {
        this.name=name;
        this.Language=language;
        this.Rating=rating;

    }
}
