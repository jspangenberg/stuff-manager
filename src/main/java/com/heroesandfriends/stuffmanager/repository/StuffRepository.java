package com.heroesandfriends.stuffmanager.repository;

import com.heroesandfriends.stuffmanager.entity.Stuff;
import org.springframework.data.repository.CrudRepository;

/**
 * @author John Spangenberg
 */
public interface StuffRepository extends CrudRepository<Stuff, Long> {
}
