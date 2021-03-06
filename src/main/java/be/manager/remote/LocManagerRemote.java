package be.manager.remote;

import be.dto.FreeTimeDTO;
import be.dto.LocDTO;
import be.exceptions.BusinessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LocManagerRemote {

    LocDTO insertLoc(LocDTO locDTO) throws BusinessException;

    List<LocDTO> findAllLocuri();

    List<LocDTO> findAllLocuriByEtaj(Integer etaj);

    void deleteLocByPosition(String position) throws BusinessException;

    List<FreeTimeDTO> findAllFreeTimes(Integer id);

}
