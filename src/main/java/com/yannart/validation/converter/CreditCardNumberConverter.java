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

import com.yannart.validation.JSR349ConstraintConverter;
import com.yannart.validation.model.ConstrainedProperty;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Email;

import java.util.Map;

/**
 * Converter from the annotation <code>CreditCardNumber</code> to the attribute
 * "creditcard".
 * 
 */
public class CreditCardNumberConverter implements JSR349ConstraintConverter<CreditCardNumber> {

	/**
	 * {@inheritDoc}
	 */
	public Class annotationClassConverted() {
		return CreditCardNumber.class;
	}

	/**
	 * {@inheritDoc}
	 */
	public void fillConstrainedPropertyAttributes(final CreditCardNumber annotation,
			final Map<String, Object> attributes,
			final ConstrainedProperty validatedProperty) {

		validatedProperty.addAttribute("creditcard", "true");
	}
}