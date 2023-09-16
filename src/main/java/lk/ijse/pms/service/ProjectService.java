package lk.ijse.pms.service;

import lk.ijse.pms.dto.ProjectDTO;

import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/15/2023
 * Time : 3:07 AM
 */
public interface ProjectService {
    ProjectDTO saveProject(ProjectDTO projectDTO);

    void updateProject(String projectId, ProjectDTO projectDTO);

    void deleteProject(String projectId);

    List<ProjectDTO> getAllProject();

    ProjectDTO getProjectById(String projectId);
}
