/**
 * 
 */
package com.yannart.validation.impl;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.Validation;

import org.junit.Before;
import org.junit.Test;

import com.yannart.validation.ConstrainedProperty;
import com.yannart.validation.JSR303ToConstrainedProperties;
import com.yannart.validation.User;
import com.yannart.validation.converter.impl.ConstraintConverterFactoryImpl;

/**
 * Test for JSR303ToConstrainedPropertiesImpl.
 * 
 * @author Yann Nicolas
 */
public class JSR303ToConstrainedPropertiesImplTest {

	JSR303ToConstrainedProperties jsr303ToConstrainedProperties;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		jsr303ToConstrainedProperties = new JSR303ToConstrainedPropertiesImpl();
		jsr303ToConstrainedProperties
				.setConverterFactory(new ConstraintConverterFactoryImpl());
	}

	/**
	 * Test method for
	 * {@link com.yannart.validation.impl.JSR303ToConstrainedPropertiesImpl#generateConstrainedProperties(java.lang.Class, javax.validation.Validator)}
	 * .
	 */
	@Test
	public void testGenerateConstrainedProperties() {

		Set<ConstrainedProperty> contraintPropertySet = jsr303ToConstrainedProperties
				.generateConstrainedProperties(User.class, Validation
						.buildDefaultValidatorFactory().getValidator());

		// 4 properties have constraints
		assertEquals(4, contraintPropertySet.size());
		for (ConstrainedProperty constrainedProperty : contraintPropertySet) {
			if (constrainedProperty.getName().equals("firstname")) {
				assertEquals("1",
						constrainedProperty.getAttributeMap().get("minlength"));
				assertEquals("20",
						constrainedProperty.getAttributeMap().get("maxlength"));
				assertEquals("true",
						constrainedProperty.getAttributeMap().get("required"));
			} else if (constrainedProperty.getName().equals("middlename")) {
				assertEquals("1",
						constrainedProperty.getAttributeMap().get("minlength"));
				assertEquals("35",
						constrainedProperty.getAttributeMap().get("maxlength"));
				assertNull(constrainedProperty.getAttributeMap()
						.get("required"));
			} else if (constrainedProperty.getName().equals("lastname")) {
				assertEquals("1",
						constrainedProperty.getAttributeMap().get("minlength"));
				assertEquals("45",
						constrainedProperty.getAttributeMap().get("maxlength"));
				assertEquals("true",
						constrainedProperty.getAttributeMap().get("required"));
			} else if (constrainedProperty.getName().equals("age")) {
				assertEquals("13",
						constrainedProperty.getAttributeMap().get("min"));
				assertEquals("110",
						constrainedProperty.getAttributeMap().get("max"));
				assertEquals("true",
						constrainedProperty.getAttributeMap().get("required"));
			}
		}

	}

	/**
	 * Test method for
	 * {@link com.yannart.validation.impl.JSR303ToConstrainedPropertiesImpl#setConverterFactory(com.yannart.validation.converter.ConstraintConverterFactory)}
	 * .
	 */
	@Test
	public void testSetConverterFactory() {

	}
}