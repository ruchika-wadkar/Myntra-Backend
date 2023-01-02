package com.myntra.backend.MyController;
import com.myntra.backend.Services.ShipperService;
import com.myntra.backend.Entities.Shipper;
import com.myntra.backend.vo.ProductVo;
import com.myntra.backend.vo.ShipperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class ShippersController {

    @Autowired
    ShipperService shipperService;

    @GetMapping("/api/v1/shipper")
    ResponseEntity<List<Shipper>> getShippers(){
        return shipperService.getShippers();
    }

    @PostMapping("/api/v1/shipper")
    ResponseEntity<String> saveShipper(@RequestBody @Valid List<ShipperVo> shipper)  {
        shipperService.saveShipper(shipper);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
