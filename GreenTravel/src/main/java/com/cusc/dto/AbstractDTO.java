/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cusc.dto;

/**
 *
 * @author kyqua
 */
public abstract class AbstractDTO<E,D> {

    public abstract E tranferToEntities();

    public abstract void getData(E e);
}
