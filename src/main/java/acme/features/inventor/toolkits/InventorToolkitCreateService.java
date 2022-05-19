package acme.features.inventor.toolkits;

import java.util.ArrayList;
import java.util.Collection;

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


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.items.Item;
import acme.entities.quantities.Quantity;
import acme.entities.toolkit.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;
import acme.util.SpamFilterService;

@Service
public class InventorToolkitCreateService implements AbstractCreateService<Inventor, Toolkit> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorToolkitRepository repository;
	
	@Autowired
	protected SpamFilterService spamFilterService;

	// AbstractCreateService<Employer, Job> interface -------------------------


	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;

		return true;
	}

	@Override
	public void validate(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		Integer toolsSize;
		Integer componentsSize;
		final ArrayList<Item> components = new ArrayList<Item>();
		final ArrayList<Item> tools = new ArrayList<Item>();
		
		toolsSize = this.repository.findToolsByInvertor(request.getPrincipal().getActiveRoleId()).size();
		componentsSize = this.repository.findComponentsByInvertor(request.getPrincipal().getActiveRoleId()).size();
		for (int i = 1; i < componentsSize+1; i++) {
			  final String index = Integer.toString(i);
			  final String componentName = (String) request.getModel().getAttribute(index);
			  if(!componentName.equals("none")) {
				  final Item component = this.repository.findComponentsByName(componentName);
				  if(!components.contains(component)) {
					  components.add(component);
				  }else {
					  errors.state(request, false, index, "authenticated.inventor.toolkit.form.error.duplicated.item");
				  }
			  }

		}
		for (int i = 1; i < toolsSize+1; i++) {
			  final String index = Integer.toString(i+200);
			  final String toolsName = (String) request.getModel().getAttribute(index);
			  if(!toolsName.equals("none")) {
				  final Item tool = this.repository.findToolsByName(toolsName);
		
				  if(!tools.contains(tool)) {
					  tools.add(tool);
				  }else {
					  errors.state(request, false, index, "authenticated.inventor.toolkit.form.error.duplicated.item");
				  }
			  }

		}

		if (!errors.hasErrors("code")) {
			Toolkit existing;

			existing = this.repository.findToolkitByCode(entity.getCode());
			errors.state(request, existing == null, "code", "authenticated.inventor.toolkit.form.error.duplicated");
		}
		
		if(this.spamFilterService.isSpam(entity.getDescription())) {
			errors.state(request, false, "description", "authenticated.inventor.toolkit.form.error.spam");
		}
		
		if(this.spamFilterService.isSpam(entity.getTitle())) {
			errors.state(request, false, "title", "authenticated.inventor.toolkit.form.error.spam");
		}
		
		if(this.spamFilterService.isSpam(entity.getLink())) {
			errors.state(request, false, "link", "authenticated.inventor.toolkit.form.error.spam");
		}
		
		if(this.spamFilterService.isSpam(entity.getAssemblyNotes())) {
			errors.state(request, false, "assemblyNotes", "authenticated.inventor.toolkit.form.error.spam");
		}

	}

	@Override
	public void bind(final Request<Toolkit> request, final Toolkit entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "title", "code", "description", "assemblyNotes", "link");
		
	}

	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final Collection<Item> tools = this.repository.findToolsByInvertor(request.getPrincipal().getActiveRoleId());
		final Collection<Item> components = this.repository.findComponentsByInvertor(request.getPrincipal().getActiveRoleId());


		request.unbind(entity, model, "title", "code", "description","assemblyNotes", "link", "isPublished");
		model.setAttribute("tools", tools);
		model.setAttribute("components", components);
	}

	@Override
	public Toolkit instantiate(final Request<Toolkit> request) {
		assert request != null;

		Toolkit result;
		
		result = new Toolkit();
		result.setPublished(false);

		return result;
	}

	@Override
	public void create(final Request<Toolkit> request, final Toolkit entity) {
		assert request != null;
		assert entity != null;

		
		Integer toolsSize;
		Integer componentsSize;
		toolsSize = this.repository.findToolsByInvertor(request.getPrincipal().getActiveRoleId()).size();
		componentsSize = this.repository.findComponentsByInvertor(request.getPrincipal().getActiveRoleId()).size();
		for (int i = 1; i < componentsSize+1; i++) {
			  final String index = Integer.toString(i);
			  final String componentName = (String) request.getModel().getAttribute(index);
			  if(!componentName.equals("none")) {
				  final Item component = this.repository.findComponentsByName(componentName);
				  final String amountIndex = Integer.toString(i+100);
				  final String amount = (String) request.getModel().getAttribute(amountIndex);
				  final Quantity q = new Quantity();
					q.setAmount(Integer.parseInt(amount));
					q.setItem(component);
					q.setToolkit(entity);
					this.repository.save(q);
			  }

		}
		
		for (int i = 1; i < toolsSize+1; i++) {
			  final String index = Integer.toString(i+200);
			  final String toolsName = (String) request.getModel().getAttribute(index);
			  if(!toolsName.equals("none")) {
				  final Item tool = this.repository.findToolsByName(toolsName);
				  final Quantity q = new Quantity();
					q.setAmount(1);
					q.setItem(tool);
					q.setToolkit(entity);
					this.repository.save(q);
			  }

		}
		this.repository.save(entity);
	}

}