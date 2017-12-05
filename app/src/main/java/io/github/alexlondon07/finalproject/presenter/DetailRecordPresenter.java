package io.github.alexlondon07.finalproject.presenter;

import android.util.Log;

import java.util.ArrayList;

import io.github.alexlondon07.finalproject.R;
import io.github.alexlondon07.finalproject.helper.TypeDecryption;
import io.github.alexlondon07.finalproject.model.cinemas.Cinema;
import io.github.alexlondon07.finalproject.repository.IRecordRepository;
import io.github.alexlondon07.finalproject.repository.RecordRepository;
import io.github.alexlondon07.finalproject.repository.RepositoryError;
import io.github.alexlondon07.finalproject.view.activities.IRecordDetail;
import retrofit.RetrofitError;

/**
 * Created by alexlondon07 on 11/14/17.
 */

public class DetailRecordPresenter extends BasePresenter<IRecordDetail> {

    private IRecordRepository recordRepository;
    private  final  static  String TAG = "DetailRecordPresenter";


    public DetailRecordPresenter() {
        this.recordRepository = new RecordRepository(TypeDecryption.JSON);
    }

    public void getCinemaPresenter() {
        if(getValidateInternet().isConnected()){
            createThreadCinemas();
        }else{
            getView().showAlertDialog(R.string.error, R.string.validate_internet);
        }
    }

    private void createThreadCinemas() {
        getView().showProgress(R.string.loading_message);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getCinemasRepository();
            }
        });
        thread.start();
    }

    private void getCinemasRepository() {
        try {
            ArrayList<Cinema> cinemaArrayList = recordRepository.getCinemas();
            getView().showCinemas(cinemaArrayList);

        } catch (RetrofitError retrofitError) {

            retrofitError.getBody();
            Log.e(TAG,retrofitError.toString(),retrofitError);

        } catch (RepositoryError repositoryError) {
            repositoryError.printStackTrace();
        } finally {
            getView().hidePorgress();
        }
    }

}
