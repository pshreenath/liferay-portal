/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.search.experiences.rest.internal.resource.v1_0.util;

import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.test.rule.LiferayUnitTestRule;
import com.liferay.search.experiences.rest.dto.v1_0.ElementDefinition;
import com.liferay.search.experiences.rest.dto.v1_0.Field;
import com.liferay.search.experiences.rest.dto.v1_0.FieldSet;
import com.liferay.search.experiences.rest.dto.v1_0.SXPElement;
import com.liferay.search.experiences.rest.dto.v1_0.UiConfiguration;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;

/**
 * @author Selena Aungst
 */
public class DecodeSXPUtilTest {

	@ClassRule
	public static final LiferayUnitTestRule liferayUnitTestRule =
		LiferayUnitTestRule.INSTANCE;

	@Test
	public void testDecodeSXPElementWithCollectionDefaultValue()
		throws Exception {

		_testDecodeSXPElementWithDefaultValue(
			Arrays.asList(
				HashMapBuilder.put(
					"label", "com.liferay.blogs.model.BlogsEntry"
				).put(
					"value", "com.liferay.blogs.model.BlogsEntry"
				).build(),
				HashMapBuilder.put(
					"label", "com.liferay.journal.model.JournalArticle"
				).put(
					"value", "com.liferay.journal.model.JournalArticle"
				).build()));
	}

	@Test
	public void testDecodeSXPElementWithObjectArrayDefaultValue()
		throws Exception {

		_testDecodeSXPElementWithDefaultValue(
			new Object[] {
				HashMapBuilder.put(
					"label", "com.liferay.blogs.model.BlogsEntry"
				).put(
					"value", "com.liferay.blogs.model.BlogsEntry"
				).build(),
				HashMapBuilder.put(
					"label", "com.liferay.journal.model.JournalArticle"
				).put(
					"value", "com.liferay.journal.model.JournalArticle"
				).build()
			});
	}

	private void _testDecodeSXPElementWithDefaultValue(Object defaultValue)
		throws Exception {

		Field field = new Field();

		field.setDefaultValue(defaultValue);
		field.setLabel("Entry Class Names");
		field.setName("entry_class_names");
		field.setType("multiselect");

		FieldSet fieldSet = new FieldSet();

		fieldSet.setFields(new Field[] {field});

		UiConfiguration uiConfiguration = new UiConfiguration();

		uiConfiguration.setFieldSets(new FieldSet[] {fieldSet});

		ElementDefinition elementDefinition = new ElementDefinition();

		elementDefinition.setUiConfiguration(uiConfiguration);

		SXPElement sxpElement = new SXPElement();

		sxpElement.setElementDefinition(elementDefinition);

		DecodeSXPUtil.decodeSXPElement(sxpElement);

		FieldSet[] fieldSets = sxpElement.getElementDefinition(
		).getUiConfiguration(
		).getFieldSets();

		Assert.assertEquals(Arrays.toString(fieldSets), 1, fieldSets.length);

		Field[] fields = fieldSets[0].getFields();

		Assert.assertEquals(Arrays.toString(fields), 1, fields.length);

		Field decodedField = fields[0];

		Assert.assertEquals("entry_class_names", decodedField.getName());
		Assert.assertEquals("multiselect", decodedField.getType());

		String defaultValueString = Arrays.deepToString(
			(Object[])decodedField.getDefaultValue());

		Assert.assertTrue(
			defaultValueString,
			defaultValueString.contains("com.liferay.blogs.model.BlogsEntry"));
		Assert.assertTrue(
			defaultValueString,
			defaultValueString.contains(
				"com.liferay.journal.model.JournalArticle"));
	}

}