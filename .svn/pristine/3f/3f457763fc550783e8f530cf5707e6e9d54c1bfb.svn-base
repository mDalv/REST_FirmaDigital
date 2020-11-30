package br.intelidata.mapfre.rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
//@PropertySource("file:${properties.externo}mapfre.properties")
public class PropertiesConfig {

	@Value("${security.signing-key}")
	private String signingKey;

	@Value("${security.resource-ids}")
	private String resourceIds;

}
