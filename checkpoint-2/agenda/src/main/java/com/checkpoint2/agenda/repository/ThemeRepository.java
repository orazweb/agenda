package com.checkpoint2.agenda.repository;

import com.checkpoint2.agenda.entity.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> { }
