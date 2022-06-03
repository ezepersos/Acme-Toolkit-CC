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
	<acme:input-textbox code="inventor.Chimpum.form.label.title" path="title"/>	
	<acme:input-textbox code="inventor.Chimpum.form.label.description" path="description"/>
	<acme:input-money code="inventor.Chimpum.form.label.budget" path="budget"/>
	<acme:input-textbox code="inventor.Chimpum.form.label.link" path="link"/>
	<acme:input-moment code="inventor.Chimpum.form.label.startTime" path="startTime"/>
	<acme:input-moment code="inventor.Chimpum.form.label.endTime" path="endTime"/>
	<acme:input-select code="authenticated.inventor.chimpum.form.label.select.item" path="itemID">
		<jstl:forEach items="${listaItems}" var="optionItem">
			<acme:input-option code="${optionItem.name}" value="${optionItem.id}" selected="${optionItem == itemSelected}" />
		</jstl:forEach>
	</acme:input-select>
	<jstl:choose>	 
		<jstl:when test="${acme:anyOf(command, 'show, update, delete')}">
			<acme:submit code="inventor.item.form.button.update" action="/inventor/chimpum/update"/>
			<acme:submit code="inventor.item.form.button.delete" action="/inventor/chimpum/delete"/>
			<acme:submit code="inventor.item.form.button.publish" action="/inventor/chimpum/publish"/>
		</jstl:when>
		<jstl:when test="${acme:anyOf(command, 'create')}">
		<acme:submit code="inventor.item.form.button.createComponent" action="/inventor/chimpum/create"/>
		</jstl:when>	
	</jstl:choose>
</acme:form>
