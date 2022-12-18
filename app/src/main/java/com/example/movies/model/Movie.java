
package com.example.movies.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie implements Parcelable {

//    public  Movie(String title,double rating ,List<String> genres,int year,
//                  String descriptionFull,String language,
//                  String smallCoverImage, String largeCoverImage){
//        this.title=title;
//        this.rating=rating;
//        this.genres=genres;
//        this.id=year;
//        this.descriptionFull=descriptionFull;
//        this.language=language;
//        this.smallCoverImage=smallCoverImage;
//        this.language=largeCoverImage;
//    }
    public Movie(int id) {
        this.id=id;
    }
    @SerializedName("id")
    @Expose
    private Integer id;
//    @SerializedName("url")
//    @Expose
//    private String url;
//    @SerializedName("imdb_code")
//    @Expose
//    private String imdbCode;
    @SerializedName("title")
    @Expose
    private String title;
//    @SerializedName("title_english")
//    @Expose
//    private String titleEnglish;
//    @SerializedName("title_long")
//    @Expose
//    private String titleLong;
//    @SerializedName("slug")
//    @Expose
//    private String slug;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("rating")
    @Expose
    private double rating;
//    @SerializedName("runtime")
//    @Expose
//    private Integer runtime;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;
//    @SerializedName("summary")
//    @Expose
//    private String summary;
    @SerializedName("description_full")
    @Expose
    private String descriptionFull;
//    @SerializedName("synopsis")
//    @Expose
//    private String synopsis;
//    @SerializedName("yt_trailer_code")
//    @Expose
//    private String ytTrailerCode;
    @SerializedName("language")
    @Expose
    private String language;
//    @SerializedName("mpa_rating")
//    @Expose
//    private String mpaRating;
//    @SerializedName("background_image")
//    @Expose
//    private String backgroundImage;
//    @SerializedName("background_image_original")
//    @Expose
//    private String backgroundImageOriginal;
    @SerializedName("small_cover_image")
    @Expose
    private String smallCoverImage;
    @SerializedName("medium_cover_image")
    @Expose
    private String mediumCoverImage;
    @SerializedName("large_cover_image")
    @Expose
    private String largeCoverImage;

    protected Movie(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        title = in.readString();
        if (in.readByte() == 0) {
            year = null;
        } else {
            year = in.readInt();
        }
        rating = in.readDouble();
        genres = in.createStringArrayList();
        descriptionFull = in.readString();
        language = in.readString();
        smallCoverImage = in.readString();
        mediumCoverImage = in.readString();
        largeCoverImage = in.readString();
    }


    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    //    @SerializedName("state")
//    @Expose
//    private String state;
//    @SerializedName("torrents")
//    @Expose
//    private List<Torrent> torrents = null;
//    @SerializedName("date_uploaded")
//    @Expose
//    private String dateUploaded;
//    @SerializedName("date_uploaded_unix")
//    @Expose
//    private Integer dateUploadedUnix;
//
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getImdbCode() {
//        return imdbCode;
//    }
//
//    public void setImdbCode(String imdbCode) {
//        this.imdbCode = imdbCode;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getTitleEnglish() {
//        return titleEnglish;
//    }
//
//    public void setTitleEnglish(String titleEnglish) {
//        this.titleEnglish = titleEnglish;
//    }
//
//    public String getTitleLong() {
//        return titleLong;
//    }
//
//    public void setTitleLong(String titleLong) {
//        this.titleLong = titleLong;
//    }
//
//    public String getSlug() {
//        return slug;
//    }
//
//    public void setSlug(String slug) {
//        this.slug = slug;
//    }
//
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
//
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
//
//    public Integer getRuntime() {
//        return runtime;
//    }
//
//    public void setRuntime(Integer runtime) {
//        this.runtime = runtime;
//    }
//
    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
//
//    public String getSummary() {
//        return summary;
//    }
//
//    public void setSummary(String summary) {
//        this.summary = summary;
//    }
//
    public String getDescriptionFull() {
        return descriptionFull;
    }

    public void setDescriptionFull(String descriptionFull) {
        this.descriptionFull = descriptionFull;
    }
//
//    public String getSynopsis() {
//        return synopsis;
//    }
//
//    public void setSynopsis(String synopsis) {
//        this.synopsis = synopsis;
//    }
//
//    public String getYtTrailerCode() {
//        return ytTrailerCode;
//    }
//
//    public void setYtTrailerCode(String ytTrailerCode) {
//        this.ytTrailerCode = ytTrailerCode;
//    }
//
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
//
//    public String getMpaRating() {
//        return mpaRating;
//    }
//
//    public void setMpaRating(String mpaRating) {
//        this.mpaRating = mpaRating;
//    }
//
//    public String getBackgroundImage() {
//        return backgroundImage;
//    }
//
//    public void setBackgroundImage(String backgroundImage) {
//        this.backgroundImage = backgroundImage;
//    }
//
//    public String getBackgroundImageOriginal() {
//        return backgroundImageOriginal;
//    }
//
//    public void setBackgroundImageOriginal(String backgroundImageOriginal) {
//        this.backgroundImageOriginal = backgroundImageOriginal;
//    }
//
    public String getSmallCoverImage() {
        return smallCoverImage;
    }

    public void setSmallCoverImage(String smallCoverImage) {
        this.smallCoverImage = smallCoverImage;
    }

    public String getMediumCoverImage() {
        return mediumCoverImage;
    }

    public void setMediumCoverImage(String mediumCoverImage) {
        this.mediumCoverImage = mediumCoverImage;
    }
//
    public String getLargeCoverImage() {
        return largeCoverImage;
    }
//
    public void setLargeCoverImage(String largeCoverImage) {
        this.largeCoverImage = largeCoverImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(title);
        if (year == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(year);
        }
        dest.writeDouble(rating);
        dest.writeStringList(genres);
        dest.writeString(descriptionFull);
        dest.writeString(language);
        dest.writeString(smallCoverImage);
        dest.writeString(mediumCoverImage);
        dest.writeString(largeCoverImage);
    }


//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public List<Torrent> getTorrents() {
//        return torrents;
//    }
//
//    public void setTorrents(List<Torrent> torrents) {
//        this.torrents = torrents;
//    }
//
//    public String getDateUploaded() {
//        return dateUploaded;
//    }
//
//    public void setDateUploaded(String dateUploaded) {
//        this.dateUploaded = dateUploaded;
//    }
//
//    public Integer getDateUploadedUnix() {
//        return dateUploadedUnix;
//    }
//
//    public void setDateUploadedUnix(Integer dateUploadedUnix) {
//        this.dateUploadedUnix = dateUploadedUnix;
//    }

}
