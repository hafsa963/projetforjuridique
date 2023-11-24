package ma.maisonSoftware.maisonSoftaware.mapper;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachmentVo {
    private Long id;
    private String name;
    private String type;
    private String imagePath;
}
