package com.hiberus.bill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.bill.service.BillService;
import com.hiberus.commons.dto.BillResponseDTO;
import com.hiberus.commons.dto.JsonDTO;
import com.hiberus.commons.dto.ProductDTO;

@RestController
public class BillController {

	@Autowired
	private BillService billService;

	@PostMapping("bills")
	public ResponseEntity<JsonDTO<BillResponseDTO>> store(@RequestBody List<ProductDTO> products) {
		return new ResponseEntity<>(new JsonDTO<>(billService.createBill(products)), HttpStatus.OK);
	}

}
