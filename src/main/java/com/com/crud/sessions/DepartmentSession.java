package com.com.crud.sessions;

import com.crud.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DepartmentSession extends JpaRepository<Department, Integer> {

    void delete(int id);
}
