<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<%
long groupId = ParamUtil.getLong(request, "groupId", themeDisplay.getScopeGroupId());

if (groupId == 0) {
	groupId = themeDisplay.getScopeGroupId();
}

String typeSelection = ParamUtil.getString(request, "typeSelection");
long subtypeSelectionId = ParamUtil.getLong(request, "subtypeSelectionId");

PortletURL portletURL = (PortletURL)request.getAttribute("view.jsp-portletURL");

AssetRendererFactory<?> assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(typeSelection);
%>

<c:choose>
	<c:when test="<%= assetRendererFactory.isSupportsClassTypes() && (subtypeSelectionId > 0) %>">

		<%
		PortletURL addPortletURL = AssetUtil.getAddPortletURL(liferayPortletRequest, liferayPortletResponse, groupId, typeSelection, subtypeSelectionId, null, null, portletURL.toString());
		%>

		<c:if test="<%= addPortletURL != null %>">

			<%
			addPortletURL.setParameter("groupId", String.valueOf(groupId));

			String addPortletURLString = addPortletURL.toString();

			addPortletURLString = HttpUtil.addParameter(addPortletURLString, "refererPlid", plid);
			%>

			<aui:nav-item href="<%= addPortletURLString %>" label='<%= LanguageUtil.format(request, "add-x", assetRendererFactory.getTypeName(locale, subtypeSelectionId)) %>' />
		</c:if>
	</c:when>
	<c:otherwise>

		<%
		PortletURL addPortletURL = AssetUtil.getAddPortletURL(liferayPortletRequest, liferayPortletResponse, groupId, typeSelection, 0, null, null, portletURL.toString());
		%>

		<c:if test="<%= addPortletURL != null %>">

			<%
			addPortletURL.setParameter("groupId", String.valueOf(groupId));

			String addPortletURLString = addPortletURL.toString();

			addPortletURLString = HttpUtil.addParameter(addPortletURLString, "refererPlid", plid);
			%>

			<aui:nav-item href="<%= addPortletURLString %>" label='<%= LanguageUtil.format(request, "add-x", assetRendererFactory.getTypeName(locale), false) %>' />
		</c:if>
	</c:otherwise>
</c:choose>