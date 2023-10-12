package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.model.Operation;

import java.util.List;

public interface IOperationService {


    void update(Operation operation);

    Operation findById(long id);

    Operation FindByOperation(long id);

    List<Operation> findAll();

    Operation save(Operation operation);

    void delete(long id);


}
