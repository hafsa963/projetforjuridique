package ma.maisonSoftware.maisonSoftaware.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.maisonSoftware.maisonSoftaware.model.Client;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class ManagerVo {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String nameManager;


    @Column(name = "Datedebut")
    @NotNull
    @Getter
    @Setter
    //@DateTimeFormat(pattern = "YYYY-MM-DD")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "UTC")
    @JsonProperty(value = "datedebut")
    private Date Datedebut;

    //@Column(name = "DateFin")
    @NotNull
    @JsonProperty(value = "dateFin")
    @Getter
    @Setter
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING, timezone = "UTC")
    private Date  DateFin;

    @Getter
    @Setter
    private String  mandatGerance;


    @Getter
    @Setter
    @Nullable
    private Client client;


}
