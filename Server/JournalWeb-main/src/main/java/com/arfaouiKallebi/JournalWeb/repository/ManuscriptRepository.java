package com.arfaouiKallebi.JournalWeb.repository;

import com.arfaouiKallebi.JournalWeb.model.Manuscript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManuscriptRepository extends JpaRepository<Manuscript,Long> {
    @Query("SELECT m FROM Manuscript m WHERE m.status = 'processed' and m.submitter.id = :idauth")
    List<Manuscript> getProcessedManuscripts(Long idauth);
    @Query("SELECT m FROM Manuscript m WHERE m.status = 'sentBack' and m.submitter.id = :idauth")
    List<Manuscript> getSentBackManuscripts(Long idauth);
    @Query("SELECT m FROM Manuscript m WHERE m.status = 'incompleted' and m.submitter.id = :idauth ")
    List<Manuscript> getIncompleteManuscripts(Long idauth);
    @Query("SELECT m FROM Manuscript m WHERE m.status = 'waiting' and m.submitter.id = :idauth ")
    List<Manuscript>  getWaitingManuscripts(Long idauth);
    @Query(value = "delete  from Manuscript a where a.id =:id")
    Manuscript deleteManuscriptById(Long id);
    @Query("SELECT m FROM Manuscript m WHERE m.status = 'waiting' and m.submitter.id = :idauth  ")
    List<Manuscript> getManuscripts(Long idauth);
    @Query(value = "delete  from Manuscript a where a.id =:id and a.submitter.id = :idauth")
    Manuscript deleteManuscriptById(Long idauth, Long id);

}
