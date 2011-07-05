package com.yannart.validation.converter.impl;

import java.lang.annotation.Annotation;
import java.util.Map;

import javax.validation.constraints.Max;

import com.yannart.validation.ConstrainedProperty;
import com.yannart.validation.converter.JSR303ConstraintConverter;

/**
 * Converter from the annotation <code>Max</code> to the attribute "max".
 * 
 * @author Yann Nicolas
 */
public class MaxConverter implements JSR303ConstraintConverter {

	/**
	 * {@inheritDoc}
	 */
	public Class<?>[] annotationClassConverted() {
		return new Class<?>[] { Max.class };
	}

	/**
	 * {@inheritDoc}
	 */
	public void fillConstrainedPropertyAttributes(final Annotation annotation,
			final Map<String, Object> attributes,
			final ConstrainedProperty validatedProperty) {

		if (annotation instanceof Max) {

			Max max = (Max) annotation;

			validatedProperty.addAttribute("max", Long.toString(max.value()));
		}
	}
}