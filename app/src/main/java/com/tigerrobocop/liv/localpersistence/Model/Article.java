package com.tigerrobocop.liv.localpersistence.Model;

import java.io.Serializable;

/**
 * Created by Livia on 12/08/2017.
 */

public class Article implements Serializable {

    public String author;
    public String title;
    public String description;
    public String url;
    public String urlToImage;

    public Article(String author
            , String title
            , String description
            , String url
            , String urlToImage) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
    }
}
