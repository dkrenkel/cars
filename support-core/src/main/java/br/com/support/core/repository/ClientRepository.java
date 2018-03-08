/**
 * 
 */
package br.com.support.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.support.model.Client;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

}
