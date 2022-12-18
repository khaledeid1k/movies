
package com.example.movies.model.screenshots;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("movie")
    @Expose
    private screenshott screenshott;

    public screenshott getMovie() {
        return screenshott;
    }

    public void setMovie(screenshott screenshott) {
        this.screenshott = screenshott;
    }

}
