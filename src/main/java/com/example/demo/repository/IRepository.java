
package com.example.demo.repository;

import org.springframework.data.repository.*;

import com.example.demo.model.BaseModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@NoRepositoryBean
public interface IRepository<T extends BaseModel<?>> extends CrudRepository<T, Integer> {

    /**
	 * Returns all entities sorted by the given options.
	 *
	 * @param sort
	 * @return all entities sorted by the given options
	 */
	Iterable<T> findAll(Sort sort);

	/**
	 * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
	 *
	 * @param pageable
	 * @return a page of entities
	 */
	Page<T> findAll(Pageable pageable);

}