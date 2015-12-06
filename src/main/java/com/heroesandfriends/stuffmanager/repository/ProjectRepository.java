package com.heroesandfriends.stuffmanager.repository;

import com.heroesandfriends.stuffmanager.entity.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * @author John Spangenberg
 */
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
