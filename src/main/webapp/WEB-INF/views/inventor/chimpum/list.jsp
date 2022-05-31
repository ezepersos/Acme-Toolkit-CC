<%--
- list.jsp
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

<acme:list>
	<acme:list-column code="inventor.chimpum.list.label.code" path="code" width="20%"/>
	<acme:list-column code="inventor.chimpum.list.label.title" path="title" width="10%"/>
	<acme:list-column code="inventor.chimpum.list.label.description" path="description" width="50%"/>
	<acme:list-column code="inventor.chimpum.list.label.startTime" path="startTime" width="20%"/>
	<acme:list-column code="inventor.chimpum.list.label.creationTime" path="creationTime" width="20%"/>
	<acme:list-column code="inventor.chimpum.list.label.endingTime" path="endingTime" width="20%"/>
	<acme:list-column code="inventor.chimpum.list.label.budget" path="budget" width="20%"/>
	<acme:list-column code="inventor.chimpum.list.label.link" path="link" width="20%"/>
</acme:list>
<acme:form>
<acme:button code="inventor.chimpum.list.button.create" action="/inventor/chimpum/create-chimpum"/>
</acme:form>


