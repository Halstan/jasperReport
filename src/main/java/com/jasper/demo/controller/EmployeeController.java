package com.jasper.demo.controller;

import com.jasper.demo.entity.Employee;
import com.jasper.demo.repository.EmployeeRepository;
import com.jasper.demo.service.EmployeeService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getEmployees")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("/getReport/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return employeeService.exportReport(format);
    }

    @GetMapping("/getReports")
    public ModelAndView generateReports(Model model){
        List<String> listOption = Arrays.asList("html", "pdf");
        model.addAttribute("listOption", listOption);
        return new ModelAndView("employee");
    }

    @PostMapping("/getReports")
    public String generateReports(@RequestParam(name = "option", required = false) String option) throws FileNotFoundException, JRException {
        return employeeService.exportReport(option);
    }
}
