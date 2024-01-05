/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.bef;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayOutputStream;

/**
 *
 * @author kyqua
 */
public class ZXingHelper {

    public static byte[] getQrcodeimage(String text, int width, int height) {
        ByteArrayOutputStream byteOutputStream = null;
        try {
            QRCodeWriter qRCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qRCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            byteOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "png", byteOutputStream);
        } catch (Exception e) {
        }
        return byteOutputStream.toByteArray();
    }
}
