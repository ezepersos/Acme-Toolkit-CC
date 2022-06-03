/*
 * EmployerJobCreateService.java
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

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import acme.entities.chimpum.Chimpum;
import acme.entities.items.Item;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorChimpumCreateService implements AbstractCreateService<Inventor, Chimpum> {

	@Autowired
	protected InventorChimpumRepository repository;
	
	@Override
	public boolean authorise(Request<Chimpum> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(Request<Chimpum> request, Chimpum entity, Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors,  "title", "description", "budget", "link", "startTime", "endTime");
	}
	@Override
	public void unbind(Request<Chimpum> request, Chimpum entity, Model model) {
		final Collection<Item> items = this.repository.findAllItems();
		model.setAttribute("items", items);
		request.unbind(entity, model,"code", "title", "description", "budget", "link", "startTime", "endTime","item");

	}

	@Override
	public Chimpum instantiate(Request<Chimpum> request) {
		Chimpum result = new Chimpum();
		result.setCode("222222");
		result.setCreationMoment(Date.from(Instant.now()));
		return result;
	}

	@Override
	public void validate(Request<Chimpum> request, Chimpum entity, Errors errors) {
		
	}

	@Override
	public void create(Request<Chimpum> request, Chimpum entity) {
		Date now = Date.from(Instant.now());
		LocalDate nowLocal = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		entity.setCreationMoment(now);
		String code = nowLocal.toString().substring(0,4)+now.toString().substring(6,8) + now.toString().substring(9,11);
		entity.setCode(code);
		int id = request.getModel().getInteger("itemID");
		entity.setItem(this.repository.findItemById(id));
		this.repository.save(entity);
	}
}
