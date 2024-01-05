/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.service.impl;

import com.cusc.service.ChartService;
import org.springframework.stereotype.Service;

/**
 *
 * @author kyqua
 */
@Service
public class ChartServiceimpl implements ChartService {

    @Override
    public String homeChart() {
        return "ad_chart";
    }

}
