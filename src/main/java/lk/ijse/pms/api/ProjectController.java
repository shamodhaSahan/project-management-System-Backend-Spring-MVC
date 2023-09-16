package lk.ijse.pms.api;

import lk.ijse.pms.dto.ProjectDTO;
import lk.ijse.pms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/15/2023
 * Time : 3:02 AM
 */

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProject() {
        return new ResponseEntity<>(projectService.getAllProject(), HttpStatus.OK);
    }

    @GetMapping(value = "{projectId}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable String projectId) {
        return new ResponseEntity<>(projectService.getProjectById(projectId), HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<ProjectDTO> saveProject(
            @RequestParam String projectId,
            @RequestParam String projectName,
            @RequestParam String projectType,
            @RequestParam String description,
            @RequestParam BigDecimal totalCost,
            @RequestParam String techLeadId
    ) {
        return new ResponseEntity<>(projectService.saveProject(new ProjectDTO(
                projectId,
                projectName,
                projectType,
                description,
                totalCost,
                techLeadId
        )), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectDTO> saveProject(
            @RequestBody ProjectDTO projectDTO
    ) {
        return new ResponseEntity<>(projectService.saveProject(projectDTO), HttpStatus.OK);
    }

    @PutMapping("{projectId}")
    public ResponseEntity<String> updateProject(@PathVariable String projectId, @RequestBody ProjectDTO projectDTO) {
        projectService.updateProject(projectId, projectDTO);
        return new ResponseEntity<>(projectId + " is updated", HttpStatus.OK);
    }

    @DeleteMapping("{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable String projectId) {
        projectService.deleteProject(projectId);
        return new ResponseEntity<>(projectId + " is deleted", HttpStatus.OK);
    }
}
