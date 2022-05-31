package acme.entities.chimpum;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

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

	@Column(unique = true)
	@Pattern(regexp = "^[0-9]{6}$")
	@NotBlank
	protected String			code;

	
	@NotBlank
	@Length(min = 1, max = 255)
	protected String			description;
	
	@NotBlank
	@Length(min = 1, max = 101)
	protected String			title;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	protected Date creationTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date endingTime;
	
	@NotNull
	protected Money budget;
	
	@URL
	protected String			link;
	

	
}


