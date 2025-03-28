/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ceos.phoebus.runtime;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ceos
 */
public class ComCeosPhoebusRuntime {

    public static void main(String[] args) {
        Connection con = CeosUtils.getConnection();
        String seleccion = "Hit Uva Sin Calorías 2L";
     try {
            String query = "SELECT * FROM receta WHERE nameproduct='"+seleccion+"';";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            System.out.println(rs);
            while (rs.next()) {
                double syrupBrix=0, drinkBrix=0;
                if (rs.getString("type").equalsIgnoreCase("brix")) {
                    syrupBrix = rs.getDouble("syrupbrix");
                    drinkBrix = rs.getDouble("drinkbrix");
                }
                int recipeNumber = rs.getInt("recipenumber");
                
                double specificWeightSyrup = rs.getDouble("specificweightsyrup");
                
                double nominalRatio = rs.getDouble("nominalratio");
                double co2Volume = rs.getDouble("co2volume");
                double saturatorPressure = rs.getDouble("saturatorpressure");
                double temperatureDrinking = rs.getDouble("temperaturedrinking");
                double nominalProduction = rs.getDouble("nominalproduction");
                double minLevel = rs.getDouble("minLevel");
                int vm1 = rs.getInt("vm1");
                int vm2 = rs.getInt("vm2");
                int vm3 = rs.getInt("vm3");
                
                
                //asignar valores
                
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
        }
    }
}
