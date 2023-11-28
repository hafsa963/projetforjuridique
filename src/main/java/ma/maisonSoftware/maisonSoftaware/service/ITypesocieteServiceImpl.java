package ma.maisonSoftware.maisonSoftaware.service;

import ma.maisonSoftware.maisonSoftaware.dao.TypeSocieteRepository;
import ma.maisonSoftware.maisonSoftaware.mapper.TypeSocieteConverter;
import ma.maisonSoftware.maisonSoftaware.mapper.TypeSocieteVo;
import ma.maisonSoftware.maisonSoftaware.model.TypeSociete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ITypesocieteServiceImpl implements ITypesocieteService {

    @Autowired
    TypeSocieteRepository typeSocieteRepository;


    @Override
    public void save(TypeSocieteVo typeSocieteVo) {
        try {
            TypeSociete typeSociete = TypeSocieteConverter.toBo(typeSocieteVo);
            TypeSociete savedTypeSociete= typeSocieteRepository.save(typeSociete);


        } catch (Exception e) {
            System.out.println("An error occurred while saving Societe: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public List<TypeSocieteVo> getAllTypeSociete() {
        List<TypeSociete> getAllTypesSociete = typeSocieteRepository.findAll();
        return   TypeSocieteConverter.tovolist(typeSocieteRepository.findAll());
    }

    @Override
    public TypeSocieteVo getTypeSocieteById(Long id) {
        boolean foundtype = typeSocieteRepository.existsById(id);
        if (!foundtype)
            return null;
        return TypeSocieteConverter.toVo(typeSocieteRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        typeSocieteRepository.deleteById(id);
    }

    @Override
    public void update(TypeSocieteVo typeSocieteVo) {
        Optional<TypeSociete> optional = typeSocieteRepository.findById(typeSocieteVo.getId());
        if (optional.isPresent()) {
            TypeSociete typeSociete = optional.get();
            typeSociete.setNom(typeSocieteVo.getNom());

        }
    }

}
