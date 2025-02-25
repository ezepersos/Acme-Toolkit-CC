/*
 * EmployerJobDeleteService.java
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

import org.springframework.stereotype.Service;

import acme.entities.chimpum.Chimpum;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractDeleteService;
import acme.roles.Inventor;

@Service
public class InventorChimpumDeleteService implements AbstractDeleteService<Inventor, Chimpum> {

	@Override
	public boolean authorise(final Request<Chimpum> request) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void bind(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unbind(final Request<Chimpum> request, final Chimpum entity, final Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Chimpum findOne(final Request<Chimpum> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate(final Request<Chimpum> request, final Chimpum entity, final Errors errors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(final Request<Chimpum> request, final Chimpum entity) {
		// TODO Auto-generated method stub
		
	}

	
	/*
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorChimpumRepository repository;

	// AbstractDeleteService<Inventor, Item> interface -------------------------


	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;

		final boolean result;
		final int itemId;
		final Item item;
		final Inventor inventor;
		
		itemId = request.getModel().getInteger("id");
		item = this.repository.findItemById(itemId);
		inventor = item.getInventor();
		result = !item.isPublished() && request.isPrincipal(inventor);

		return result;
	}

	@Override
	public void bind(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "name", "code", "technology", "description", "retailPrice", "link");
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "code", "description", "technology", "retailPrice", "link", "isPublished");
	}

	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;

		Item result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findItemById(id);

		return result;
	}
	

	@Override
	public void validate(final Request<Item> request, final Item entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<Item> request, final Item entity) {
		assert request != null;
		assert entity != null;

		if(!entity.isPublished()) {
			Collection<Quantity> quantities;

			quantities = this.repository.findAllDutiesByItemId(entity.getId());
			for (final Quantity qty : quantities) {
				this.repository.deleteQuantityById(qty.getId());
			}
			
			this.repository.delete(entity);
		}
	}
*/
}
