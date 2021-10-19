package com.pmic.apachecamelfulfillmentcenterfile.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.springframework.stereotype.Component;

import com.pmic.apachecamelfulfillmentcenterfile.domain.OrderDto;
import com.pmic.apachecamelfulfillmentcenterfile.processor.ShippingProcessor;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ShipRoutes extends RouteBuilder {

	private final ShippingProcessor shippingProcessor;

	public ShipRoutes(ShippingProcessor shippingProcessor) {
		this.shippingProcessor = shippingProcessor;
	}

	@Override
	public void configure() throws Exception {
		JacksonDataFormat orderListformat = new ListJacksonDataFormat(OrderDto.class);

		from("{{fulfillment-center-file-route}}").routeId("ulfillment-center-file-route")
				.log("Received file for shipping : ${body}")
				.to("{{fulfillment-center-file-processed}}")
				.unmarshal(orderListformat)
				.process(shippingProcessor);

	}
}
