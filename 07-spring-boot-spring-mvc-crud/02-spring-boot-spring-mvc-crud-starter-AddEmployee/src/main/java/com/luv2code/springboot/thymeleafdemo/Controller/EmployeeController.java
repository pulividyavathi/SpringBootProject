package com.luv2code.springboot.thymeleafdemo.Controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService){
        employeeService= theEmployeeService;
    }
//    add mapping for '/list'

    @GetMapping("/list")
    public String listEmployees(Model theModel){
//        get the employeess from the db
        List<Employee> theEmployees=employeeService.findAll();
//        add to the spring model
        theModel.addAttribute("employees",theEmployees);
        return "employees/list-employees";
    }


    @GetMapping("/showFormToAdd")
    public String showFormToAdd(Model theModel){
//        create model attribute to bind form datew
        Employee theEmployee=new Employee();
        theModel.addAttribute("employee",theEmployee);
        return "employees/employee-form";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,Model theModel){
//        get the employee from the service
        Employee theEmployee=employeeService.findById(theId);
//        set employee in the model to prepopulate the form
        theModel.addAttribute("employee",theEmployee);

//        send over to our form to display
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int theId){
//        delete the employee
        employeeService.deleteById(theId);
//        redireet to /employees/list
        return "redirect:/employees/list";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){
//        save the employee
        employeeService.save(theEmployee);
//        use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }


}
