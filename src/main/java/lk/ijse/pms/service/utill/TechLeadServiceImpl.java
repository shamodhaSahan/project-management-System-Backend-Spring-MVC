package lk.ijse.pms.service.utill;

import lk.ijse.pms.dto.TechLeadDTO;
import lk.ijse.pms.entity.TechLead;
import lk.ijse.pms.repo.TechLeadRepo;
import lk.ijse.pms.service.TechLeadService;
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
public class TechLeadServiceImpl implements TechLeadService {
    @Autowired
    EntityDtoConvertor entityDtoConvertor;

    @Autowired
    TechLeadRepo techLeadRepo;

    @Override
    public TechLeadDTO saveTechLead(TechLeadDTO techLeadDTO) {
        Optional<TechLead> optionalTechLead = techLeadRepo.findById(techLeadDTO.getId());
        if (optionalTechLead.isPresent()) {
            throw new RuntimeException("Duplicate Tech Lead id..!");
        }
        techLeadRepo.save(entityDtoConvertor.getTechLeadEntity(techLeadDTO));
        return techLeadDTO;
    }

    @Override
    public void updateTechLead(String id, TechLeadDTO techLeadDTO) {
        Optional<TechLead> optionalTechLead = techLeadRepo.findById(id);
        if (!optionalTechLead.isPresent())
            throw new RuntimeException("Id : " + id + " Tech Lead not found..!");
//        techLeadRepo.save(entityDtoConvertor.getTechLeadEntity(techLeadDTO));
    }

    @Override
    public void deleteTechLead(String id) {
        Optional<TechLead> optionalTechLead = techLeadRepo.findById(id);
        if (!optionalTechLead.isPresent())
            throw new RuntimeException("Id : " + id + " Tech Lead not found..!");
        techLeadRepo.deleteById(id);
    }

    @Override
    public List<TechLeadDTO> getAllTechLead() {
        return techLeadRepo.findAll().stream().map(techLead -> entityDtoConvertor.getTechLeadDTO(techLead)).collect(Collectors.toList());
    }

    @Override
    public TechLeadDTO getTeachLeadById(String id) {
        Optional<TechLead> optionalTechLead = techLeadRepo.findById(id);
        if (!optionalTechLead.isPresent())
            throw new RuntimeException("Id : " + id + " Tech Lead not found..!");
        return entityDtoConvertor.getTechLeadDTO(optionalTechLead.get());
    }
}
