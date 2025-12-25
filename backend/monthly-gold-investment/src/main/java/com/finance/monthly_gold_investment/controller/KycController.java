package com.finance.monthly_gold_investment.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.finance.monthly_gold_investment.service.KycService;
import com.finance.monthly_gold_investment.service.KycService.KycResult;

@RestController
@RequestMapping("/api/kyc")
public class KycController {

    @Autowired
    private KycService kycService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadKyc(
            @RequestParam Long userId,
            @RequestParam("file") MultipartFile file
    ) throws Exception {

        KycResult result = kycService.processKyc(userId, file);
        return ResponseEntity.ok(result);
    }
}
