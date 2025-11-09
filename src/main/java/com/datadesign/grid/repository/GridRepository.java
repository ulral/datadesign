package com.datadesign.grid.repository;

import com.datadesign.grid.model.Grid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GridRepository extends JpaRepository<Grid, Long> {
}

