/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuevana.films.util;

import java.io.File;

/**
 *
 * @author adrian
 */
public class Utils {
    
    public static final String REGULAR_EXPRESSION_ONLY_NUMBERS = "^[0-9]*$";
    public static final String REGULAR_EXPRESSION_DATE = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))";
    
    public static boolean existsFile(String path) {
        File file = new File(path);
        return file.exists();
    }
}
