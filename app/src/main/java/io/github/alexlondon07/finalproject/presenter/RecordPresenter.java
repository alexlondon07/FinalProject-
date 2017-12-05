package io.github.alexlondon07.finalproject.presenter;

import io.github.alexlondon07.finalproject.R;
import io.github.alexlondon07.finalproject.helper.TypeDecryption;
import io.github.alexlondon07.finalproject.model.Records;
import io.github.alexlondon07.finalproject.repository.RecordRepository;
import io.github.alexlondon07.finalproject.repository.RepositoryError;
import io.github.alexlondon07.finalproject.view.activities.IRecordView;

/**
 * Created by alexlondon07 on 11/9/17.
 */

public class RecordPresenter extends BasePresenter<IRecordView> {

    private RecordRepository recordRepository;
    private  final  static  String TAG = "RecordPresenter";

    public RecordPresenter(TypeDecryption typeDecryption) {
        recordRepository = new RecordRepository(typeDecryption);
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
            Records records = recordRepository.getRecords();
            getView().showMovies(records.getMovieInfo());
        } catch (RepositoryError repositoryError) {
            repositoryError.printStackTrace();
        } finally {
            getView().hidePorgress();
        }
    }


}
