package com.kh.spring11.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.http.MediaType;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Encoding;


@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.PARAMETER)
@io.swagger.v3.oas.annotations.parameters.RequestBody(
		content = @Content(
				encoding = @Encoding(
							name = "sale",
//							contentType = "application/json"
							contentType = MediaType.APPLICATION_JSON_VALUE
						)
				)
		)
public @interface SaleJsonPart {

}
