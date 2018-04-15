package br.com.support.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.support.model.Analyst;

/**
 * 
 * @author Luiz Vieira <jun.luiz@gmail.com>
 *
 */
public interface AnalystRepository extends JpaRepository<Analyst, Long>{

}
