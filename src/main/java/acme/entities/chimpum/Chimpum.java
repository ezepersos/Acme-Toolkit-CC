package acme.entities.chimpum;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.items.Item;
import acme.framework.datatypes.Money;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Chimpum extends AbstractEntity {
	// Serialisation identifier

		private static final long	serialVersionUID	= 1L;
		
		// Attributes -------------------------------------------------------------

	
		
		@Column(unique = false)
		@Pattern(regexp = "^[0-9]{2}[0-1][0-9][0-3][0-9]$")
		@NotBlank
		protected String			code;
		
		@Temporal(TemporalType.TIMESTAMP)
		@Past
		protected Date			creationMoment;
		
		@Temporal(TemporalType.TIMESTAMP)
		@Future
		protected Date			startTime;
		
		@Temporal(TemporalType.TIMESTAMP)
		@Future
		protected Date			endTime;
		
		@NotBlank
		@Length(min = 1, max = 101)
		protected String			title;
		
		@NotBlank
		@Length(min = 1, max = 256)
		protected String			description;
		
		@NotNull
		protected Money			budget;
		
		@URL
		protected String			link;

		
		// Relations -------------------------------------------------------------
		
		@Valid
		@NotNull
		@OneToOne(optional = true)
		protected Item item;
		
	}
