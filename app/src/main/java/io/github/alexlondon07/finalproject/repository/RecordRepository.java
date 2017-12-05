package io.github.alexlondon07.finalproject.repository;

import java.util.ArrayList;

import io.github.alexlondon07.finalproject.helper.ServicesFactory;
import io.github.alexlondon07.finalproject.helper.TypeDecryption;
import io.github.alexlondon07.finalproject.model.Records;
import io.github.alexlondon07.finalproject.model.cinemas.Cinema;
import io.github.alexlondon07.finalproject.service.IServices;

/**
 * Created by alexlondon07 on 11/11/17.
 */

public class RecordRepository implements IRecordRepository {

    private IServices services;


    public RecordRepository(TypeDecryption typeDecryption) {
        ServicesFactory servicesFactory = new ServicesFactory(typeDecryption);
        services = (IServices) servicesFactory.getInstance(IServices.class);
    }


    @Override
    public Records getRecords() throws RepositoryError {
        return services.getRecordsList();
    }

    @Override
    public ArrayList<Cinema> getCinemas() throws RepositoryError {
        return services.getCinemas();
    }


}
