/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2.Services;

import com.mycompany.mavenproject2.DataLayer.Show;

/**
 *
 * @author HP
 */
public class ShowDetailsService {
    
    private static Show show;

    public static Show getShow() {
        return show;
    }

    public static void setShow(Show selectedShow) {
        show = selectedShow;
    }
    
    
    
    
    
}
