package com.example.recyclerview;

public class Cake {

    private  String title;
    private  String description;
    private  int image;

    Cake(String t,String d,int i){
        this.title = t;
        this.description = d;
        this.image = i;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
