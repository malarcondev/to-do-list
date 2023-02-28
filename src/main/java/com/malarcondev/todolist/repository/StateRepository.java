package com.malarcondev.todolist.repository;

import com.malarcondev.todolist.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Long> {
}
