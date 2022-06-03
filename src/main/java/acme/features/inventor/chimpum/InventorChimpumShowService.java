/*
 * AuthenticatedAnnouncementShowService.java
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chimpum.Chimpum;
import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorChimpumShowService implements AbstractShowService<Inventor, Chimpum> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorChimpumRepository repository;

	// AbstractShowService<Administrator, Announcement> interface --------------

	@Override
	public boolean authorise(Request<Chimpum> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(Request<Chimpum> request, Chimpum entity, Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		Item item = entity.getItem();
		model.setAttribute("itemSelected", item);
		Collection<Item> items = this.repository.findAllItems();
		model.setAttribute("listaItems", items);
		request.unbind(entity, model, "title", "description", "budget", "link", "startTime", "endTime");
	}

	@Override
	public Chimpum findOne(final Request<Chimpum> request) {
		Chimpum result;
		int id = request.getModel().getInteger("id");
		result = this.repository.findChimpumById(id);
		return result;
	}

}
