package com.hiberus.bill.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.hiberus.bill.service.BillService;
import com.hiberus.commons.dto.BillResponseDTO;
import com.hiberus.commons.dto.ProductDTO;

import lombok.extern.java.Log;

@Log
@Service
public class BillServiceImpl implements BillService {

	@Override
	public BillResponseDTO createBill(List<ProductDTO> products) {

		log.info("--- Starting Service ---");
		Double totalPaymentAmount = 0.0;
		Integer totalProductsNumber = 0;

		for (ProductDTO productDTO : products) {
			log.info(String.format("Processing product with id : %s", productDTO.getId()));
			totalPaymentAmount += productDTO.getQuantity() * productDTO.getCost();
			totalProductsNumber += productDTO.getQuantity();
		}
		log.info(String.format("Total products processed : %s", totalProductsNumber));
		log.info("--- Finishing Service ---");
		return new BillResponseDTO(ThreadLocalRandom.current().nextLong(1000, 10000), totalPaymentAmount, new Date(),
				totalProductsNumber);
	}

}
