package io.github.alexlondon07.finalproject.presenter;

import io.github.alexlondon07.finalproject.repository.IRecordRepository;
import io.github.alexlondon07.finalproject.view.activities.IRecordDetail;

/**
 * Created by alexlondon07 on 11/14/17.
 */

public class DetailRecordPresenter extends BasePresenter<IRecordDetail> {

    private IRecordRepository recordRepository;

    public DetailRecordPresenter(IRecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }
}
