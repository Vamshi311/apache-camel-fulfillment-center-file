package com.pmic.apachecamelfulfillmentcenterfile.domain;

import java.math.BigDecimal;

import com.pmic.apachecamelfulfillmentcenterfile.entity.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

	private Long id;

	private String address;

	private BigDecimal total;

	private String purchaser;

	private String seller;

	private OrderStatus status;

	private String fulfillmentCenter;
}
