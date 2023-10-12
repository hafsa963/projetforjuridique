package ma.maisonSoftware.maisonSoftaware.controller.rest;

import ma.maisonSoftware.maisonSoftaware.service.IOperationService;
import ma.maisonSoftware.maisonSoftaware.service.IOperationServiceImpl;
import ma.maisonSoftware.maisonSoftaware.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/operation")
public class OperationController {


    @Autowired
    IOperationService ioperationService;


    @GetMapping("/")
    public List<Operation> getAllOperations() {
        return ioperationService.findAll();

    }


    @PostMapping("/")
    public Operation  createOperation(@Valid @RequestBody Operation operation){
        return ioperationService.save(operation);

    }

     @PutMapping("update/{id}")
     public Operation updateOperation(@PathVariable long id , @RequestBody Map<String ,Object>updates)
     {
         Optional<Operation> operationOptional = Optional.ofNullable(ioperationService.findById(id));
         if(operationOptional.isPresent())
         {
             Operation operation = operationOptional.get();

             if (updates.containsKey("nameOperation")) {
                 operation.setNameOperation((String) updates.get("nameOperation"));
             }

            /* logger.info("operation  information edited successfully");*/
             return  ioperationService.save(operation);
         }
         return  null;
     }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOperation(@PathVariable("id") long id) {
        ioperationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }






}
