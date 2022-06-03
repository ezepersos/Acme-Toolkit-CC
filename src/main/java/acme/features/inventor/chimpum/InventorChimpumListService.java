/*
 * AuthenticatedAnnouncementListService.java
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
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chimpum.Chimpum;
import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.entities.AbstractEntity;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorChimpumListService implements AbstractListService<Inventor, Chimpum> {

	// Internal state ---------------------------------------------------------

	private static final String TOOLKITID = "toolkitId";

	@Autowired
	protected InventorChimpumRepository repository;

	@Override
	public boolean authorise(Request<Chimpum> request) {
		assert request != null;
		return true;
	}

	@Override
	public Collection<Chimpum> findMany(Request<Chimpum> request) {
		assert request != null;
		return this.repository.findAllChimpums();
	}

	@Override
	public void unbind(Request<Chimpum> request, Chimpum entity, Model model) {

		request.unbind(entity, model, "code", "title", "description", "budget", "link", "creationMoment", "startTime",
				"endTime", "item");


	}
}
