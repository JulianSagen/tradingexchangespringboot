package com.dave3615.tradingexchangespringboot.dao;

import com.dave3615.tradingexchangespringboot.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends CrudRepository<Role, Long> {

    Role findByRole(String role);


}