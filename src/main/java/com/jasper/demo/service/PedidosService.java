package com.jasper.demo.service;

import com.jasper.demo.entity.Employee;
import com.jasper.demo.entity.Pedidos;
import com.jasper.demo.repository.PedidosRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PedidosService {

    @Autowired
    PedidosRepository pedidosRepository;

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        final String PATH = "C:\\Users\\PC\\Downloads";
        List<Pedidos> pedidos = pedidosRepository.findAll();
        //CARGAR ARCHIVO Y COMPILARLO
        File file = ResourceUtils.getFile("classpath:reportes.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(pedidos);
        Map<String, Object> map = new HashMap<>();
        map.put("Creado por", "Enzo Arauco");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, dataSource);

        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint, PATH + "\\pedidos.html");
        }else if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint, PATH + "\\pedidos.pdf");
        }

        return "Report generated in: " + PATH;
    }

}
