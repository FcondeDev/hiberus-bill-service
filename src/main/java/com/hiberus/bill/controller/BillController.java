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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BillController {

	@Autowired
	private BillService billService;

	@PostMapping("bills")
	@ApiOperation(value = "Calculate the bill", httpMethod = "POST")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "The bill information") })
	public ResponseEntity<JsonDTO<BillResponseDTO>> store(@RequestBody List<ProductDTO> products) {
		return new ResponseEntity<>(new JsonDTO<>(billService.createBill(products)), HttpStatus.OK);
	}

}
