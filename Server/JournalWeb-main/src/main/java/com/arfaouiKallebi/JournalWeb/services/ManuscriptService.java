package com.arfaouiKallebi.JournalWeb.services;


import com.arfaouiKallebi.JournalWeb.dto.ManuscriptDTO;
import java.util.List;

public interface ManuscriptService {
    List<ManuscriptDTO> findAll() ;
    ManuscriptDTO findById(Long id) ;
    ManuscriptDTO deleteById(Long id) ;

    ManuscriptDTO save(ManuscriptDTO dto);

    List<ManuscriptDTO> getIncompleteManuscripts(Long idauth);

    List<ManuscriptDTO> getWaitingManuscripts(Long idauth);

    List<ManuscriptDTO> findManuscripts(Long idauth);

    ManuscriptDTO deleteManuscriptById(Long idauth, Long id);

    ManuscriptDTO saveManuscript(Long idauth, ManuscriptDTO manuscript);

    List<ManuscriptDTO> getProcessedManuscripts(Long idauth);

    List<ManuscriptDTO> getSentBackManuscripts(Long idauth);
}
