package lk.ijse.pms.entity;

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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Project {
    @Id
    String projectId;
    @Column(nullable = false)
    String projectName;
    @Column(nullable = false)
    String projectType;
    @Column(nullable = false)
    String description;
    @Column(nullable = false)
    BigDecimal totalCost;

    @ManyToOne
    @JoinColumn(name = "tl_id", nullable = false)
    TechLead techLead;
}
