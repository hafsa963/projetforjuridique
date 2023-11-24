package ma.maisonSoftware.maisonSoftaware.mapper;

import ma.maisonSoftware.maisonSoftaware.model.AttachmentEntity;
import ma.maisonSoftware.maisonSoftaware.model.Departement;

import java.util.ArrayList;
import java.util.List;

public class AttachmentConverter {
    public static AttachmentVo toVo(AttachmentEntity bo){
        if (bo == null)
            return null;
        AttachmentVo vo = new AttachmentVo();
        vo.setId(bo.getId());
       vo.setImagePath(bo.getImagePath());
       vo.setName(bo.getName());
       vo.setType(bo.getType());
        return vo;
    }
    public static AttachmentEntity toBo(AttachmentVo vo) {
        if (vo == null)
            return null;
        AttachmentEntity bo = new AttachmentEntity();
        bo.setId(vo.getId());

        bo.setImagePath(vo.getImagePath());
        bo.setName(vo.getName());
        bo.setType(vo.getType());
        return bo;
    }
    public static List<AttachmentVo> toVoList(List<AttachmentEntity> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<AttachmentVo> voList = new ArrayList<>();
        for (AttachmentEntity attachment : boList) {
            voList.add(toVo(attachment));
        }
        return voList;
    }
    public static List<AttachmentEntity> toBoList(List<AttachmentVo> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<AttachmentEntity> boList = new ArrayList<>();
        for (AttachmentVo attachmentVo : voList) {
            boList.add(toBo(attachmentVo));
        }
        return boList;
    }
}
