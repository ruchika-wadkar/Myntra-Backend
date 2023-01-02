package com.myntra.backend.Services;


import com.myntra.backend.Entities.Shipper;

import com.myntra.backend.Exceptions.ProductException;

import com.myntra.backend.Repository.ShipperRepository;

import com.myntra.backend.vo.ShipperVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipperService {

    @Autowired
    ShipperRepository shipperRepository;
    public ResponseEntity<List<Shipper>> getShippers() {
        return new ResponseEntity<>(shipperRepository.findAll(), HttpStatus.OK);
    }
    public void saveShipper(List<ShipperVo> shipper)  {
        // FOR-EACH LOOP (JAVA 5 FEATURE)
        for (ShipperVo ship: shipper) {
            if (shipperRepository.findById(ship.getShipperID()).isPresent()) {
                throw new ProductException("shipper already exists");
            }
            shipperRepository.save(getEntity(ship));
        }
    }

    public Shipper getEntity(ShipperVo shipper){
        Shipper S1 = new Shipper();
        S1.setShipperID(shipper.getShipperID());
        S1.setShipperName(shipper.getShipperName());
        S1.setPhone(shipper.getPhone());
        return S1;
    }
}
