package net.local.poc.camel.aggregator.service.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.base.HttpOperationFailedException;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

import net.local.poc.camel.aggregator.service.aggregators.DepartmentAggregator;

@Component
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration()
            .component("servlet")
                .bindingMode(RestBindingMode.auto)
                    .dataFormatProperty("json.in.disableFeatures", "FAIL_ON_UNKNOWN_PROPERTIES")
                    .dataFormatProperty("json.in.disableFeatures", "FAIL_ON_EMPTY_BEANS");

        rest("/integration")
            .get("/{organizationId}")
                .to("direct:detail-organization-service");

        from("direct:detail-organization-service")
            .to("direct:organization-service")
                    .setHeader("organization", simple("${body}"))
                    .setHeader("organizationId", jsonpath("$.organizationId"))
                    .enrich("direct:department-service", new DepartmentAggregator());
        
        from("direct:organization-service")
            .removeHeaders("CamelHttp*")
            .setHeader(Exchange.HTTP_METHOD, constant("GET"))
        .toD("http://localhost:8080/organizations/${header.organizationId}");
        
        from("direct:department-service")
            .removeHeaders("CamelHttp*")
            .setHeader(Exchange.HTTP_METHOD, constant("GET"))
			.onException(HttpOperationFailedException.class)
				.handled(true)
				.setBody(constant("[]"))
			.end()
        .toD("http://localhost:8081/departments/byorganization/${header.organizationId}");
        
        from("direct:employee-service")
            .removeHeaders("CamelHttp*")
            .setHeader(Exchange.HTTP_METHOD, constant("GET"))
			.onException(HttpOperationFailedException.class)
				.handled(true)
				.setBody(constant("[]"))
			.end()
        .toD("http://localhost:8082/employees/bydepartment/${header.departmentId}");
    }
}
