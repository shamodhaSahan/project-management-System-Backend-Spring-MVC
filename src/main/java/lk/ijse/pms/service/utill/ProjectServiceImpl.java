package lk.ijse.pms.service.utill;

import lk.ijse.pms.dto.ProjectDTO;
import lk.ijse.pms.entity.Project;
import lk.ijse.pms.entity.TechLead;
import lk.ijse.pms.repo.ProjectRepo;
import lk.ijse.pms.repo.TechLeadRepo;
import lk.ijse.pms.service.ProjectService;
import lk.ijse.pms.utill.EntityDtoConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/15/2023
 * Time : 2:24 AM
 */

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    EntityDtoConvertor entityDtoConvertor;

    @Autowired
    ProjectRepo projectRepo;

    @Autowired
    TechLeadRepo techLeadRepo;

    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {
        Optional<Project> optionalProject = projectRepo.findById(projectDTO.getProjectId());
        if (optionalProject.isPresent())
            throw new RuntimeException(projectDTO.getProjectId()+" is duplicate project id..!");
        Optional<TechLead> optionalTechLead = techLeadRepo.findById(projectDTO.getTechLeadId());
        if (!optionalTechLead.isPresent())
            throw new RuntimeException("Id : "+projectDTO.getTechLeadId()+" Tech Lead not found..!");
        Project projectEntity = entityDtoConvertor.getProjectEntity(projectDTO);
        projectEntity.setTechLead(optionalTechLead.get());
        projectRepo.save(projectEntity);
        return projectDTO;
    }

    @Override
    public void updateProject(String projectId, ProjectDTO projectDTO) {
        Optional<Project> optionalProject = projectRepo.findById(projectId);
        if (!optionalProject.isPresent())
            throw new RuntimeException("Id : " + projectId + " project not found..!");
//        techLeadRepo.save(entityDtoConvertor.getTechLeadEntity(techLeadDTO));
    }

    @Override
    public void deleteProject(String projectId) {
        Optional<Project> optionalProject = projectRepo.findById(projectId);
        if (!optionalProject.isPresent())
            throw new RuntimeException("Id : " + projectId + " project not found..!");
        projectRepo.deleteById(projectId);
    }

    @Override
    public List<ProjectDTO> getAllProject() {
        return projectRepo.findAll().stream().map(project -> entityDtoConvertor.getProjectDTO(project)).collect(Collectors.toList());
    }

    @Override
    public ProjectDTO getProjectById(String projectId) {
        Optional<Project> optionalProject = projectRepo.findById(projectId);
        if (!optionalProject.isPresent())
            throw new RuntimeException("Id : " + projectId + " project not found..!");
        return entityDtoConvertor.getProjectDTO(optionalProject.get());
    }
}
