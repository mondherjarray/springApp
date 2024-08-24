package com.formation.spring.Repository;

import com.formation.spring.Entities.AdresseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresseRepository extends CrudRepository<AdresseEntity, Long> {
    AdresseEntity findByAdresseId (String id);
    List<AdresseEntity> findByUserId (String id);


}
