package com.datadesign.grid.repository;

import com.datadesign.grid.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<Data, Long> {
}
