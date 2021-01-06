package com.example.palakArora_COMP304_Lab2;

public class Home {
    private  int image;
    private String address;
    private  String price;

    public Home(int image, String address, String price) {
        this.image = image;
        this.address = address;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


}
