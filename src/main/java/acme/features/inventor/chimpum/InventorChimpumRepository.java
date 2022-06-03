/*
 * AuthenticatedAnnouncementRepository.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.inventor.chimpum;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.chimpum.Chimpum;
import acme.entities.items.Item;
import acme.entities.quantities.Quantity;
import acme.entities.system_configurations.SystemConfiguration;
import acme.entities.toolkit.Toolkit;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Inventor;

@Repository
public interface InventorChimpumRepository extends AbstractRepository {
	
	@Query("select c from Chimpum c")
	Collection<Chimpum> findAllChimpums();
	@Query("select c from Chimpum c where c.id =:id")
	Chimpum findChimpumById(int id);
	@Query("select i from Item i")
	Collection<Item> findAllItems();
	@Query("select i from Item i where i.id =: id")
	Item findItemById(int id);

}
