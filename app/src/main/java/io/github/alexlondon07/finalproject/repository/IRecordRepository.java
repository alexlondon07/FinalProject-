package io.github.alexlondon07.finalproject.repository;

import java.util.ArrayList;

import io.github.alexlondon07.finalproject.model.Records;
import io.github.alexlondon07.finalproject.model.cinemas.Cinema;

/**
 * Created by alexlondon07 on 11/11/17.
 */

public interface IRecordRepository {

    Records getRecords() throws RepositoryError;

    ArrayList<Cinema> getCinemas() throws RepositoryError;
}
