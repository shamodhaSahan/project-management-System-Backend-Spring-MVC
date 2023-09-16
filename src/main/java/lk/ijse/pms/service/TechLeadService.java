package lk.ijse.pms.service;

import lk.ijse.pms.dto.TechLeadDTO;

import java.util.List;

/**
 * Created By shamodha_s_rathnamalala
 * Date : 9/15/2023
 * Time : 3:07 AM
 */
public interface TechLeadService {
    TechLeadDTO saveTechLead(TechLeadDTO techLeadDTO);

    void updateTechLead(String id, TechLeadDTO techLeadDTO);

    void deleteTechLead(String id);

    List<TechLeadDTO> getAllTechLead();

    TechLeadDTO getTeachLeadById(String id);
}
