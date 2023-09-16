package lk.ijse.pms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/15/2023
 * Time : 2:27 AM
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProjectDTO {
    String projectId;
    String projectName;
    String projectType;
    String description;
    BigDecimal totalCost;
    String techLeadId;
}
