package io.github.alexlondon07.finalproject.service;

import java.util.ArrayList;

import io.github.alexlondon07.finalproject.model.cinemas.Cinema;
import io.github.alexlondon07.finalproject.model.Records;
import retrofit.http.GET;

/**
 * Created by alexlondon07 on 11/9/17.
 */

public interface IServices {

    @GET("/current.xml")
    Records getRecordsList();


    @GET("/cinemas")
    ArrayList<Cinema> getCinemas();


}
