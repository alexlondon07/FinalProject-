package io.github.alexlondon07.finalproject.view.activities;

import io.github.alexlondon07.finalproject.view.IBaseView;

/**
 * Created by alexlondon07 on 11/14/17.
 */

public interface IRecordDetail  extends IBaseView {

    void showAlertDialog(int error);

    void showToast(String msg);
}
