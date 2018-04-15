package br.com.support.business.facade.impl;

import br.com.support.business.dto.AnalystDTO;
import br.com.support.business.mapper.AnalystMapper;
import br.com.support.core.repository.AnalystRepository;
import br.com.support.model.Analyst;

public class AnalystFacade extends CrudFacade<AnalystDTO, 
												Analyst,
												AnalystRepository,
												AnalystMapper>{

}
