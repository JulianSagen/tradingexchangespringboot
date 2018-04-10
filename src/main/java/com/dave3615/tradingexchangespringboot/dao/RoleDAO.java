package com.dave3615.tradingexchangespringboot.dao;

import com.dave3615.tradingexchangespringboot.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDAO extends CrudRepository<Role, Long> {

    Role findByRole(String role);


}