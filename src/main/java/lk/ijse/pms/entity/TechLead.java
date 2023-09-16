package lk.ijse.pms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/15/2023
 * Time : 2:27 AM
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TechLead {
    @Id
    String id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String email;
    @Column(nullable = false)
    BigDecimal salary;
    @Column(nullable = false)
    String telNumber;

    @OneToMany(mappedBy = "techLead", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Project> projects;
}
