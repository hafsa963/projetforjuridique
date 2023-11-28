package ma.maisonSoftware.maisonSoftaware.service;


import ma.maisonSoftware.maisonSoftaware.mapper.TypeSocieteVo;

import java.util.List;

public interface ITypesocieteService {
    void save(TypeSocieteVo typeSocieteVo);

    List<TypeSocieteVo>  getAllTypeSociete();

    TypeSocieteVo getTypeSocieteById(Long id);
    void delete(Long id);

    void update(TypeSocieteVo typeSocieteVo);
}
