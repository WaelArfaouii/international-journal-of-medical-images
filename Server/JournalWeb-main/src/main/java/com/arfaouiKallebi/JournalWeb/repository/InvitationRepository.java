package com.arfaouiKallebi.JournalWeb.repository;

import com.arfaouiKallebi.JournalWeb.model.Invitation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    @Query(value = "delete  from Invitation a where a.id =:id")
    Invitation deleteInvitationById(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from Invitation i where i.reviewer.id = :id ")
    void deleteInv(Long id);
}
