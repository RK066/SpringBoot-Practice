package com.project.xml2Json;

import org.springframework.data.repository.CrudRepository;

public interface dataRepo extends CrudRepository<data,String> {

    boolean existsByName(String f);

    data findByName(String f);

}
