/*
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.liferay.audit.web.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;

/**
 * @author Brian Greenwald
 */
@Component(
	property = {
		"javax.portlet.display-name=Audit Portlet",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.expiration-cache=0",
		"javax.portlet.portlet-mode=text/html;view",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.portlet-info.title=Audit Portlet",
		"javax.portlet.portlet-info.short-title=Audit Portlet",
		"javax.portlet.security-role-ref=administrator,guest,power-user,user",
		"com.liferay.portlet.icon=/icon.png",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.display-category=category.sample"
	},
	service = Portlet.class
)
public class AuditPortlet extends MVCPortlet {
}
