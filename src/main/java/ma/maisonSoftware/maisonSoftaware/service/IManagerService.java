package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.mapper.ManagerVo;

import java.util.List;

public interface IManagerService {

    void calculateMandatDurationInYears(ManagerVo managerVo);

    void save(ManagerVo managerVo);

    void update(ManagerVo managerVo);

    List<ManagerVo> getAllManager();
    List<ManagerVo> findAllMangers();
}
