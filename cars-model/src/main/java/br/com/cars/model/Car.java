/**
 * 
 */
package br.com.cars.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 */
@Entity
@Table(name = "users")
public class Car implements BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Override
	public Long getId() {
		return id;
	}

}
