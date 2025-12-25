package com.finance.monthly_gold_investment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.finance.monthly_gold_investment.entity.User;
import com.finance.monthly_gold_investment.repo.UserRepository;
import com.finance.monthly_gold_investment.service.analysis.ImageProcessingService;

@Service
public class KycService {

    @Autowired
    private ImageProcessingService imageProcessingService;

    @Autowired
    private UserRepository userRepository;

    public static class KycResult {
        public boolean passed;
        public String extractedText;
        public boolean faceDetected;
        public KycResult(boolean passed, String extractedText, boolean faceDetected) {
            this.passed = passed;
            this.extractedText = extractedText;
            this.faceDetected = faceDetected;
        }
    }

    public KycResult processKyc(Long userId, MultipartFile idImage) throws Exception {
        byte[] imageBytes = idImage.getBytes();

        String ocrText = imageProcessingService.extractText(imageBytes);
        boolean faceDetected = imageProcessingService.detectFace(imageBytes);

        boolean nameFound = ocrText != null && ocrText.toLowerCase().contains("name");
        boolean idFound = ocrText != null && ocrText.toLowerCase().matches(".*[0-9]{6,}.*");

        boolean passed = faceDetected && nameFound && idFound;

        User user = userRepository.findById(userId).orElseThrow();
        user.setKycVerified(passed);
        userRepository.save(user);

        return new KycResult(passed, ocrText, faceDetected);
    }
}
