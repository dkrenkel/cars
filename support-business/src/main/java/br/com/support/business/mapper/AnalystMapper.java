package br.com.support.business.mapper;

import br.com.support.business.dto.AnalystDTO;
import br.com.support.model.Analyst;

public class AnalystMapper implements Mappeable<Analyst, AnalystDTO> {

	@Override
	public Analyst map(AnalystDTO dto) {
		Analyst analyst = new Analyst();
		analyst.setId(dto.getId());
		analyst.setName(dto.getName());
		return analyst;
	}

	@Override
	public AnalystDTO map(Analyst entity) {
		AnalystDTO analystDTO = new AnalystDTO();
		analystDTO.setId(entity.getId());
		analystDTO.setName(entity.getName());
		return analystDTO;
	}

}
