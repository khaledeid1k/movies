
package com.example.movies.model.screenshots;

import android.os.Parcel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class screenshott  {
//    public  screenshott(String title,double rating ,List<String> genres,int year,
//                  String descriptionFull,String language,
//                  String smallCoverImage, String largeCoverImage,String largeScreenshotImage1){
//        this.title=title;
//        this.rating=rating;
//        this.genres=genres;
//        this.id=year;
//        this.descriptionFull=descriptionFull;
//        this.language=language;
//        this.smallCoverImage=smallCoverImage;
//        this.language=largeCoverImage;
//        this.largeScreenshotImage1=largeScreenshotImage1;
//    }
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("imdb_code")
    @Expose
    private String imdbCode;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("title_english")
    @Expose
    private String titleEnglish;
    @SerializedName("title_long")
    @Expose
    private String titleLong;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("rating")
    @Expose
    private Double rating;
    @SerializedName("runtime")
    @Expose
    private Integer runtime;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;
    @SerializedName("download_count")
    @Expose
    private Integer downloadCount;
    @SerializedName("like_count")
    @Expose
    private Integer likeCount;
    @SerializedName("description_intro")
    @Expose
    private String descriptionIntro;
    @SerializedName("description_full")
    @Expose
    private String descriptionFull;
    @SerializedName("yt_trailer_code")
    @Expose
    private String ytTrailerCode;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("mpa_rating")
    @Expose
    private String mpaRating;
    @SerializedName("background_image")
    @Expose
    private String backgroundImage;
    @SerializedName("background_image_original")
    @Expose
    private String backgroundImageOriginal;
    @SerializedName("small_cover_image")
    @Expose
    private String smallCoverImage;
    @SerializedName("medium_cover_image")
    @Expose
    private String mediumCoverImage;
    @SerializedName("large_cover_image")
    @Expose
    private String largeCoverImage;
    @SerializedName("medium_screenshot_image1")
    @Expose
    private String mediumScreenshotImage1;
    @SerializedName("medium_screenshot_image2")
    @Expose
    private String mediumScreenshotImage2;
    @SerializedName("medium_screenshot_image3")
    @Expose
    private String mediumScreenshotImage3;
    @SerializedName("large_screenshot_image1")
    @Expose
    private String largeScreenshotImage1;
    @SerializedName("large_screenshot_image2")
    @Expose
    private String largeScreenshotImage2;
    @SerializedName("large_screenshot_image3")
    @Expose
    private String largeScreenshotImage3;
    @SerializedName("cast")
    @Expose
    private List<Cast> cast = null;
    @SerializedName("torrents")
    @Expose
    private List<Torrent> torrents = null;
    @SerializedName("date_uploaded")
    @Expose
    private String dateUploaded;
    @SerializedName("date_uploaded_unix")
    @Expose
    private Integer dateUploadedUnix;

    protected screenshott(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        url = in.readString();
        imdbCode = in.readString();
        title = in.readString();
        titleEnglish = in.readString();
        titleLong = in.readString();
        slug = in.readString();
        if (in.readByte() == 0) {
            year = null;
        } else {
            year = in.readInt();
        }
        if (in.readByte() == 0) {
            rating = null;
        } else {
            rating = in.readDouble();
        }
        if (in.readByte() == 0) {
            runtime = null;
        } else {
            runtime = in.readInt();
        }
        genres = in.createStringArrayList();
        if (in.readByte() == 0) {
            downloadCount = null;
        } else {
            downloadCount = in.readInt();
        }
        if (in.readByte() == 0) {
            likeCount = null;
        } else {
            likeCount = in.readInt();
        }
        descriptionIntro = in.readString();
        descriptionFull = in.readString();
        ytTrailerCode = in.readString();
        language = in.readString();
        mpaRating = in.readString();
        backgroundImage = in.readString();
        backgroundImageOriginal = in.readString();
        smallCoverImage = in.readString();
        mediumCoverImage = in.readString();
        largeCoverImage = in.readString();
        mediumScreenshotImage1 = in.readString();
        mediumScreenshotImage2 = in.readString();
        mediumScreenshotImage3 = in.readString();
        largeScreenshotImage1 = in.readString();
        largeScreenshotImage2 = in.readString();
        largeScreenshotImage3 = in.readString();
        dateUploaded = in.readString();
        if (in.readByte() == 0) {
            dateUploadedUnix = null;
        } else {
            dateUploadedUnix = in.readInt();
        }
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImdbCode() {
        return imdbCode;
    }

    public void setImdbCode(String imdbCode) {
        this.imdbCode = imdbCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }

    public String getTitleLong() {
        return titleLong;
    }

    public void setTitleLong(String titleLong) {
        this.titleLong = titleLong;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getDescriptionIntro() {
        return descriptionIntro;
    }

    public void setDescriptionIntro(String descriptionIntro) {
        this.descriptionIntro = descriptionIntro;
    }

    public String getDescriptionFull() {
        return descriptionFull;
    }

    public void setDescriptionFull(String descriptionFull) {
        this.descriptionFull = descriptionFull;
    }

    public String getYtTrailerCode() {
        return ytTrailerCode;
    }

    public void setYtTrailerCode(String ytTrailerCode) {
        this.ytTrailerCode = ytTrailerCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMpaRating() {
        return mpaRating;
    }

    public void setMpaRating(String mpaRating) {
        this.mpaRating = mpaRating;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public String getBackgroundImageOriginal() {
        return backgroundImageOriginal;
    }

    public void setBackgroundImageOriginal(String backgroundImageOriginal) {
        this.backgroundImageOriginal = backgroundImageOriginal;
    }

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

    public String getLargeCoverImage() {
        return largeCoverImage;
    }

    public void setLargeCoverImage(String largeCoverImage) {
        this.largeCoverImage = largeCoverImage;
    }

    public String getMediumScreenshotImage1() {
        return mediumScreenshotImage1;
    }

    public void setMediumScreenshotImage1(String mediumScreenshotImage1) {
        this.mediumScreenshotImage1 = mediumScreenshotImage1;
    }

    public String getMediumScreenshotImage2() {
        return mediumScreenshotImage2;
    }

    public void setMediumScreenshotImage2(String mediumScreenshotImage2) {
        this.mediumScreenshotImage2 = mediumScreenshotImage2;
    }

    public String getMediumScreenshotImage3() {
        return mediumScreenshotImage3;
    }

    public void setMediumScreenshotImage3(String mediumScreenshotImage3) {
        this.mediumScreenshotImage3 = mediumScreenshotImage3;
    }

    public String getLargeScreenshotImage1() {
        return largeScreenshotImage1;
    }

    public void setLargeScreenshotImage1(String largeScreenshotImage1) {
        this.largeScreenshotImage1 = largeScreenshotImage1;
    }

    public String getLargeScreenshotImage2() {
        return largeScreenshotImage2;
    }

    public void setLargeScreenshotImage2(String largeScreenshotImage2) {
        this.largeScreenshotImage2 = largeScreenshotImage2;
    }

    public String getLargeScreenshotImage3() {
        return largeScreenshotImage3;
    }

    public void setLargeScreenshotImage3(String largeScreenshotImage3) {
        this.largeScreenshotImage3 = largeScreenshotImage3;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public List<Torrent> getTorrents() {
        return torrents;
    }

    public void setTorrents(List<Torrent> torrents) {
        this.torrents = torrents;
    }

    public String getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(String dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public Integer getDateUploadedUnix() {
        return dateUploadedUnix;
    }

    public void setDateUploadedUnix(Integer dateUploadedUnix) {
        this.dateUploadedUnix = dateUploadedUnix;
    }


}
