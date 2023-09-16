package lk.ijse.pms.utill;

import lk.ijse.pms.dto.ProjectDTO;
import lk.ijse.pms.dto.TechLeadDTO;
import lk.ijse.pms.entity.Project;
import lk.ijse.pms.entity.TechLead;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/15/2023
 * Time : 2:26 AM
 */

@Component
public class EntityDtoConvertor {
    @Autowired
    ModelMapper modelMapper;

    public Project getProjectEntity(ProjectDTO projectDTO){
        return modelMapper.map(projectDTO,Project.class);
    }

    public ProjectDTO getProjectDTO(Project project){
        return modelMapper.map(project,ProjectDTO.class);
    }

    public TechLead getTechLeadEntity(TechLeadDTO techLeadDTO){
        return modelMapper.map(techLeadDTO,TechLead.class);
    }

    public TechLeadDTO getTechLeadDTO(TechLead techLead){
        return modelMapper.map(techLead,TechLeadDTO.class);
    }
}
