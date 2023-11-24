package ma.maisonSoftware.maisonSoftaware.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataBaseFileVo implements Serializable{
	private String fileName;
	private String fileType;
	private byte[] data;
}
