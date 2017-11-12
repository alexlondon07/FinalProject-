package io.github.alexlondon07.finalproject.repository;

import io.github.alexlondon07.finalproject.helper.ServicesFactory;
import io.github.alexlondon07.finalproject.helper.TypeDecryption;
import io.github.alexlondon07.finalproject.model.Records;
import io.github.alexlondon07.finalproject.service.IServices;

/**
 * Created by alexlondon07 on 11/11/17.
 */

public class RecordRepository implements IRecord {

    private IServices services;

    public RecordRepository() {
        ServicesFactory servicesFactory = new ServicesFactory(TypeDecryption.XML);
        services = (IServices) servicesFactory.getInstance(IServices.class);
    }

    @Override
    public Records getRecords() {
        Records  records = services.getRecords();
        return  records;
    }
}
