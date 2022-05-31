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
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.chimpum.Chimpum;
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
	public boolean authorise(final Request<Chimpum> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "title", "description", "startTime", "endingTime", "budget", "link");
		
		
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "startTime", "endingTime", "budget", "link");
		
	}

	@Override
	public Chimpum instantiate(final Request<Chimpum> request) {
		assert request != null;
		Chimpum result;
		result = new Chimpum();
		return result;
	}

	@Override
	public void validate(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(final Request<Chimpum> request, final Chimpum entity) {
		assert request != null;
		assert entity != null;
		entity.setCreationTime(Date.from(Instant.now()));
		entity.setCode(String.valueOf(entity.getCreationTime().getDay()) + String.valueOf(entity.getCreationTime().getMonth())+String.valueOf( entity.getCreationTime().getYear()));
		this.repository.save(entity);
		
	}

}
