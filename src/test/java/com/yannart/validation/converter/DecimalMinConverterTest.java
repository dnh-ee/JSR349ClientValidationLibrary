/**
 * Copyright (C) 2011 Yann Nicolas <yannart@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yannart.validation.converter;

import com.yannart.validation.model.ConstrainedProperty;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test for MinConverter.
 * 
 * @author Yann Nicolas
 */
public class DecimalMinConverterTest {

	/**
	 * Tested object.
	 */
    DecimalMinConverter converter;

	@Before
	public void setUp() {
		converter = new DecimalMinConverter();
	}

	/**
	 * Test method for
	 * {@link MinConverter#annotationClassConverted()}
	 * .
	 */
	@Test
	public void testAnnotationClassConverted() {
		assertEquals(DecimalMin.class,
                converter.annotationClassConverted());
	}

	/**
	 * Test method for
	 * {@link MinConverter#fillConstrainedPropertyAttributes(java.lang.annotation.Annotation, java.util.Map, com.yannart.validation.model.ConstrainedProperty)}
	 * .
	 */
	@Test
	public void testFillConstrainedPropertyAttributes() {
		ConstrainedProperty property = new ConstrainedProperty("property");
		Map<String, Object> attributeMap = new HashMap<>();

        DecimalMin min = mock( DecimalMin.class);
		when(min.value()).thenReturn( "1.0");

		converter.fillConstrainedPropertyAttributes(min, attributeMap,
                property);
        assertEquals(2, property.getAttributeMap().size());
		assertEquals("1.0", property.getAttributeMap().get("min"));
        assertEquals("true", property.getAttributeMap().get("number"));
	}

}
