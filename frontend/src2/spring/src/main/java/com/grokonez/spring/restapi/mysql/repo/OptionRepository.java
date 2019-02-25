package com.grokonez.spring.restapi.mysql.repo;

import java.util.List;

import com.grokonez.spring.restapi.mysql.model.Option;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, Long> {
    List<Option> findByParentId(long parentId);
}
