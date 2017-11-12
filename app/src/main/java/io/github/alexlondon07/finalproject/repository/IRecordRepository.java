package io.github.alexlondon07.finalproject.repository;

import java.util.ArrayList;

import io.github.alexlondon07.finalproject.model.Records;

/**
 * Created by alexlondon07 on 11/11/17.
 */

public interface IRecordRepository {

    ArrayList<Records> getRecords() throws RepositoryError;
}
