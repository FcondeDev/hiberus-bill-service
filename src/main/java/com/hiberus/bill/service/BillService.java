package com.hiberus.bill.service;

import java.util.List;

import com.hiberus.commons.dto.BillResponseDTO;
import com.hiberus.commons.dto.ProductDTO;

public interface BillService {

	public BillResponseDTO createBill(List<ProductDTO> products);

}
