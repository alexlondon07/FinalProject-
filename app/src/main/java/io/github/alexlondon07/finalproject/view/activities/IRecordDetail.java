package io.github.alexlondon07.finalproject.view.activities;

import java.util.ArrayList;

import io.github.alexlondon07.finalproject.model.cinemas.Cinema;
import io.github.alexlondon07.finalproject.view.IBaseView;

/**
 * Created by alexlondon07 on 11/14/17.
 */

public interface IRecordDetail  extends IBaseView {

    void showCinemas(ArrayList<Cinema> cinemaArrayList);

    void showAlertDialog(int error, int validate_internet);
}
