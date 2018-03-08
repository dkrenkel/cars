/**
 * 
 */
package br.com.support.model;

import java.io.Serializable;

/**
 * The JPA Base Entity 
 * @author David Krenkel <david.melo1992@gmail.com>
 *
 * @param <T> Id Entity type
 */
public interface BaseEntity<T extends Serializable> extends Serializable {

	public T getId();
}
