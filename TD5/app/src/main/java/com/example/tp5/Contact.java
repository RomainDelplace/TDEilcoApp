package com.example.tp5;

import android.net.Uri;

public class Contact {

    private String CNom, CPrenom, CimageUrl;


    public Contact (String FirstName, String LastName, String ImageUrl){
        CNom=LastName;
        CPrenom=FirstName;
        CimageUrl=ImageUrl;
    }


    public String getmFirstName() {
        return CPrenom;
    }

    public String getmLastName() {
        return CNom;
    }

    public String getmImage() {
        return CimageUrl;
    }
}
