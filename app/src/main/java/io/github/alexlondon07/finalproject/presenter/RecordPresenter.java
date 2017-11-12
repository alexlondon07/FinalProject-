package io.github.alexlondon07.finalproject.presenter;

import java.util.ArrayList;

import io.github.alexlondon07.finalproject.R;
import io.github.alexlondon07.finalproject.model.Records;
import io.github.alexlondon07.finalproject.repository.IRecordRepository;
import io.github.alexlondon07.finalproject.repository.RecordRepository;
import io.github.alexlondon07.finalproject.repository.RepositoryError;
import io.github.alexlondon07.finalproject.view.activities.IRecordView;

/**
 * Created by alexlondon07 on 11/9/17.
 */

public class RecordPresenter extends BasePresenter<IRecordView> {

    private IRecordRepository recordRepository;
    private  final  static  String TAG = "RecordPresenter";

    public RecordPresenter() {
        recordRepository = new RecordRepository();
    }

    public void getRecordPresenter() {
        if(getValidateInternet().isConnected()){
            createThreadRecord();
        }else{
            getView().showAlertDialogInternet(R.string.error, R.string.validate_internet);
        }
    }

    private void createThreadRecord() {
        getView().showProgress(R.string.loading_message);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getRecordRepository();
            }
        });
        thread.start();
    }

    private void getRecordRepository() {
        try {

            ArrayList<Records> recordsArrayList = recordRepository.getRecords();
            getView().showRecords(recordsArrayList);

        } catch (RepositoryError repositoryError) {
            repositoryError.printStackTrace();
        } finally {
            getView().hidePorgress();
        }
    }


}
