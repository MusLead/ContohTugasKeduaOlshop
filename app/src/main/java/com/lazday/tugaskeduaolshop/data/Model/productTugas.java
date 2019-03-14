package com.lazday.tugaskeduaolshop.data.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class productTugas {

    

    @SerializedName("results")
    public List<Result> results;

    public List<Result> getResults() {
        return results;
    }


    public class Result{

//          "id": "1",
//          "title": "Tutorial Android Pemula",
//          "description": "DVD video tutorial pembuatan aplikasi android dengan android studio dan database sqlite untuk pemula, studi kasus membuat aplikasi manajemen keuangan.",
//          "image": "android-pemula.png",
//          "checkout": "https://tokopedia.link/LYvG3iCfSU",
//          "sku": "android-pemula",
//          "release_date": "2019-03-06 08:40:02",
//          "image_path": "https://demo.lazday.com/restserver/assets/flyer/android-pemula.png"

        @SerializedName("id")
        private int id;
        @SerializedName("title")
        private String title;
        @SerializedName("description")
        private String description;
        @SerializedName("checkout")
        private String checkout;
        @SerializedName("sku")
        private String sku;
        @SerializedName("release_date")
        private String release_date;
        @SerializedName("image_path")
        private String image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCheckout() {
            return checkout;
        }

        public void setCheckout(String checkout) {
            this.checkout = checkout;
        }

        public String getSku() {
            return sku;
        }

        public void setSku(String sku) { this.sku = sku; }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
