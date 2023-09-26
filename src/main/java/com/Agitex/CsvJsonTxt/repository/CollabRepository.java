package com.Agitex.CsvJsonTxt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Agitex.CsvJsonTxt.entity.Collab;

@Repository
public interface CollabRepository extends JpaRepository<Collab, Long> {

}
