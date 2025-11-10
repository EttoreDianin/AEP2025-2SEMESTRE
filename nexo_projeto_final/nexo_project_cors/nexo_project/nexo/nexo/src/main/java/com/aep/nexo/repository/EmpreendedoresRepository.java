package com.aep.nexo.repository;

import com.aep.nexo.model.EmpreendedoresModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpreendedoresRepository extends JpaRepository<EmpreendedoresModel, Long> {
}