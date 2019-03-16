package com.app.jpr.market.Activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> cricket = new ArrayList<String>();
        cricket.add("Every effort is made to maintain accuracy of all information");



        List<String> football = new ArrayList<String>();
        football.add("Made with superior quality wheat  " +
                "Prepares soft and delicious roti" +
                "Rich source of Fibre");



        List<String> basketball = new ArrayList<String>();
        basketball.add("10 Kg");



        expandableListDetail.put("Description", cricket);
        expandableListDetail.put("Key Featurea", football);
        expandableListDetail.put("Disclaimer", cricket);
        expandableListDetail.put("Unit", basketball);

        return expandableListDetail;
    }
}
