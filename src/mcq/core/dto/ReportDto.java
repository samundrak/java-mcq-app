/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq.core.dto;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author samundra-sage
 */
public class ReportDto {

    public ArrayList<ReportFormat> report = new ArrayList<>();

    public int getTotals() {
        Iterator it = report.iterator();

        int total = 0;

        while (it.hasNext()) {
            ReportFormat format = (ReportFormat) it.next();
            total += format.getMarksObtained();
        }
        return total;
    }

}
