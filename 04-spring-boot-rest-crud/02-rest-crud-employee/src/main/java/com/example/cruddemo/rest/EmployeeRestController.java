package com.example.cruddemo.rest;

import com.example.cruddemo.dao.EmployeeDAO;
import com.example.cruddemo.dao.EmployeeDaoImpl;
import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.apache.tomcat.jni.SSLConf.apply;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
     private ObjectMapper objectmapper;
   private EmployeeService employeeservice;

    public EmployeeRestController(EmployeeService service,ObjectMapper theObjectMapper)
    {
        employeeservice=service;
        objectmapper=theObjectMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll()
    {
        return employeeservice.findAll();
    }

    @GetMapping("/employees/{theEmployeeId}")
    public Employee getEmployeeById(@PathVariable int theEmployeeId)
    {
           Employee theEmployee=employeeservice.findById(theEmployeeId);
           if(theEmployee==null)
           {
               throw  new RuntimeException("Employee id not found!");
           }
           return  theEmployee;
    }
//

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeservice.save(theEmployee);

        return dbEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        Employee dbEmployee= employeeservice.save(theEmployee);
        return dbEmployee;
    }

    //patch mapping

    @PatchMapping("/employees/{employeeId}")
    public Employee updateWithId(@PathVariable int employeeId,
                                 @RequestBody Map<String, Object> patchPayload)
    {
            Employee tempEmployee=employeeservice.findById(employeeId);
            if(tempEmployee==null)
            {
                throw new RuntimeException("employee id not found"+employeeId);
            }
            if(patchPayload.containsKey("id"))
            {
                throw new RuntimeException("employee id not allowedin request body");
            }
            Employee patchedEmployee=apply(patchPayload,tempEmployee);
            Employee dbEmployee=employeeservice.save(patchedEmployee);
            return dbEmployee;
    }

    private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) {
        //conerting employee and patchpayload objects to json obj node
        ObjectNode employeeNode=objectmapper.convertValue(tempEmployee,ObjectNode.class);
        ObjectNode patchNode=objectmapper.convertValue(patchPayload,ObjectNode.class);

        //merge the patch updates
        employeeNode.setAll(patchNode);
        return objectmapper.convertValue(employeeNode,Employee.class);
    }


}
