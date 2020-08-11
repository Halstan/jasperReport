package com.jasper.demo.controller;

import com.jasper.demo.entity.Pedidos;
import com.jasper.demo.repository.PedidosRepository;
import com.jasper.demo.service.PedidosService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

@RestController
public class PedidosController {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private PedidosService pedidosService;

    @GetMapping ("/getPedidos")
    private List<Pedidos> getPedidos(){
        return pedidosRepository.findAll();
    }

    @GetMapping("/getReportsPedidos")
    public ModelAndView generateReports(Model model){
        List<String> listOption = Arrays.asList("html", "pdf");
        model.addAttribute("listOption", listOption);
        return new ModelAndView("pedidos");
    }

    @PostMapping("/getReportsPedidos")
    public String generateReports(@RequestParam(name = "option", required = false) String option) throws FileNotFoundException, JRException {
        return pedidosService.exportReport(option);
    }

}
