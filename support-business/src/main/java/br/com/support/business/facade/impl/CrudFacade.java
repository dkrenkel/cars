package br.com.support.business.facade.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.support.business.dto.Transferable;
import br.com.support.business.error.EntityNotFoundException;
import br.com.support.business.error.ExistingEntityException;
import br.com.support.business.facade.CrudFacadeable;
import br.com.support.business.mapper.Mappeable;
import br.com.support.model.BaseEntity;

public abstract class CrudFacade<DTO extends Transferable, 
								ENTITY extends BaseEntity<Long>, 
								REPO extends JpaRepository<ENTITY, Long>, 
								MAPPER extends Mappeable<ENTITY, DTO>> 
								implements CrudFacadeable<DTO>{
	@Autowired
	private REPO repository;

	@Autowired
	private MAPPER mapper;

	@Override
	public DTO save(DTO dto) throws ExistingEntityException {
		Example<ENTITY> example = Example.of(this.mapper.map(dto));
		// TODO implementation of the ExampleMatcher
		ENTITY entity = this.repository.findOne(example);
		if (entity != null) {
			throw new ExistingEntityException("Entity already exists");
		}
		return this.mapper.map(this.repository.save(this.mapper.map(dto)));
	}

	@Override
	public Transferable update(long id, DTO dto) throws EntityNotFoundException {
		if(mapper.map(dto).getId() != id)
			throw new EntityNotFoundException("Path id and object id do not match");
			
		ENTITY entity = this.repository.findOne(id);
		
		if(entity == null)
			throw new EntityNotFoundException("Entity does not exist");
		
		entity = this.repository.saveAndFlush(mapper.map(dto));
		return mapper.map(entity);
	}

	@Override
	public void delete(long id) throws EntityNotFoundException {
		this.repository.delete(id);
	}

	@Override
	public DTO findOne(long id) throws EntityNotFoundException {
		ENTITY entity = this.repository.findOne(id);
		
		if(entity == null)
			throw new EntityNotFoundException("Entity does not exist");
		
		return mapper.map(entity);
	}

	@Override
	public List<DTO> findAll() {
		List<DTO> list = new ArrayList<DTO>();
		for(ENTITY entity : this.repository.findAll()) {
			list.add(mapper.map(entity));
		}
		return list;
	}

}
