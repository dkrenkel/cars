/**
 * 
 */
package br.com.cars.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cars.model.User;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Searches for a user with the given cpf
	 * @param cpf
	 * @return The found user
	 */
	User findByCpf(String cpf);
	
}
