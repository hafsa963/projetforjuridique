package ma.maisonSoftware.maisonSoftaware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataBaseFile implements Serializable{
	private String fileName;
	private String fileType;
	@Lob
	private byte[] data;
}
