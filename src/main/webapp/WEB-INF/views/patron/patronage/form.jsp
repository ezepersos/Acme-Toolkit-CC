<%--
- form.jsp
-
- Copyright (C) 2012-2022 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
    <acme:input-textbox code="authenticated.patron.patronage.form.label.status" path="status"/>	
	<acme:input-textbox code="authenticated.patron.patronage.form.label.code" path="code"/>	
	<acme:input-textbox code="authenticated.patron.patronage.form.label.legalStuff" path="legalStuff"/>	
	<acme:input-textbox code="authenticated.patron.patronage.form.label.budget" path="budget"/>	
	<acme:input-textbox code="authenticated.patron.patronage.form.label.startTime" path="startTime"/>
	<acme:input-textbox code="authenticated.patron.patronage.form.label.creationTime" path="creationTime"/>
	<acme:input-textbox code="authenticated.patron.patronage.form.label.endingTime" path="endingTime"/>
	<acme:input-textbox code="authenticated.patron.patronage.form.label.link" path="link"/>
	<acme:button code="authenticated.patron.patronage.form.button.inventor" action="/any/user-account/show?id=${inventor.userAccount.id}"/>

	<jstl:choose>	 
		<jstl:when test="${acme:anyOf(command, 'show, update, delete, publish') && isPublished == false}">
			<acme:submit code="authenticated.patron.patronage.form.button.update" action="/patron/patronage/update"/>
			<acme:submit code="authenticated.patron.patronage.form.button.delete" action="/patron/patronage/delete"/>
			<acme:submit code="authenticated.patron.patronage.form.button.publish" action="/patron/patronage/publish"/>
		</jstl:when>
		<jstl:when test="${acme:anyOf(command, 'create-patronage')}">
			<acme:submit code="authenticated.patron.patronage.form.button.createPatronage" action="/patron/patronage/create-patronage"/>
		</jstl:when>		
	</jstl:choose>
</acme:form>