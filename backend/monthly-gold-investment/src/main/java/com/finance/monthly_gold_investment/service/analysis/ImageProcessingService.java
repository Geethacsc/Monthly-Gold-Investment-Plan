package com.finance.monthly_gold_investment.service.analysis;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.opencv.global.opencv_core;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.global.opencv_imgproc;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ImageProcessingService {

    /** ----------------------
     *  🔹 OCR (Tesseract)
     *  ---------------------- */
    public String extractText(String imagePath) throws TesseractException {
        ITesseract tesseract = new Tesseract();
        return tesseract.doOCR(new File(imagePath));
    }

    public String extractText(byte[] imageBytes) throws Exception {
        Path tmp = Files.createTempFile("kyc-id-", ".jpg");
        Files.write(tmp, imageBytes);

        try {
            return extractText(tmp.toString());
        } finally {
            tmp.toFile().delete();
        }
    }


    /** ----------------------
     *  🔹 FACE DETECTION (OpenCV)
     *  ---------------------- 
     * @throws IOException */
    public boolean detectFace(String imagePath) throws IOException {

        // Load OpenCV native library
        Loader.load(opencv_core.class);

        // Extract Haar Cascade from resources
        File xmlFile = Loader.extractResource(
                CascadeClassifier.class,
                "/haarcascades/haarcascade_frontalface_default.xml",
                null,
                "classifier",
                "1"
        );

        try (CascadeClassifier detector = new CascadeClassifier(xmlFile.getAbsolutePath())) {
			// Read image
			Mat img = opencv_imgcodecs.imread(imagePath);
			if (img == null || img.empty()) return false;

			//Convert to grayscale
			Mat gray = new Mat();
			opencv_imgproc.cvtColor(img, gray, opencv_imgproc.COLOR_BGR2GRAY);
			opencv_imgproc.equalizeHist(gray, gray);

			// Detect faces
			org.bytedeco.opencv.opencv_core.RectVector faces =
			        new org.bytedeco.opencv.opencv_core.RectVector();

			detector.detectMultiScale(gray, faces);

			return faces.size() > 0;
		}
    }

    public boolean detectFace(byte[] imageBytes) throws Exception {
        Path tmp = Files.createTempFile("kyc-face-", ".jpg");
        Files.write(tmp, imageBytes);

        try {
            return detectFace(tmp.toString());
        } finally {
            tmp.toFile().delete();
        }
    }
}
