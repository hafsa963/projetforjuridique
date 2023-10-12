package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.dao.OperationRepository;
import ma.maisonSoftware.maisonSoftaware.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOperationServiceImpl implements IOperationService {

      @Autowired
      OperationRepository operationRepository ;

    @Autowired
    public IOperationServiceImpl(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public Operation FindByOperation(long id)
    {
        return operationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Operation> findAll()
    {
        return operationRepository.findAll();
    }

    @Override
    public Operation save(Operation operation) {
        operationRepository.save(operation);
        return operation;
    }

    @Override
    public void update(Operation operation) {
        operationRepository.save(operation);
    }



    @Override
    public Operation findById(long id) {
        return null;
    }


    @Override
    public void delete(long id)
    {
        operationRepository.deleteById(id);
    }






}





