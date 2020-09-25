/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuevana.films.controller.util;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adrian
 */
public class TableModelMovie extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int column) {
        // Columna eliminar y editar
        if (column == 7 || column == 8) {
            return true;
        }

        return false;
    }

    @Override
    public Class getColumnClass(int column) {
        return Object.class;
    }
}
