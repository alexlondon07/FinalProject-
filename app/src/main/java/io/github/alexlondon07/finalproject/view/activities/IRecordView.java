package io.github.alexlondon07.finalproject.view.activities;

import java.util.ArrayList;

import io.github.alexlondon07.finalproject.model.Records;
import io.github.alexlondon07.finalproject.view.IBaseView;

/**
 * Created by alexlondon07 on 11/11/17.
 */

public interface IRecordView extends IBaseView {

    void showRecords(ArrayList<Records> recordsArrayList);

    void showAlertDialogInternet(int error, int validate_internet);

    void showAlertError(int error, int error2);

    void showAlertError(int error, String error2);
}
