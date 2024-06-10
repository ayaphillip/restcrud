package edu.cpp.a2RestCrud.rest;

import edu.cpp.a2RestCrud.dao.DepartmentDAO;
import edu.cpp.a2RestCrud.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentRestController {

    @Autowired
    private DepartmentDAO departmentDAO;

    @GetMapping("/departments")
    public List<Department> findAll() {
        return departmentDAO.findAll();
    }

    @GetMapping("/departments/{departmentId}")
    public Department getDepartment(@PathVariable int departmentId) {
        Department theDepartment = departmentDAO.findById(departmentId);
        if (theDepartment == null) {
            throw new RuntimeException("Department id not found - " + departmentId);
        }
        return theDepartment;
    }

    @PostMapping("/departments")
    public Department addDepartment(@RequestBody Department theDepartment) {
        theDepartment.setId(0);
        Department dbDepartment = departmentDAO.save(theDepartment);
        return dbDepartment;
    }

    @PutMapping("/departments")
    public Department updateDepartment(@RequestBody Department theDepartment) {
        Department dbDepartment = departmentDAO.save(theDepartment);
        return dbDepartment;
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartment(@PathVariable int departmentId) {
        Department tempDepartment = departmentDAO.findById(departmentId);
        if (tempDepartment == null) {
            throw new RuntimeException("Department id not found - " + departmentId);
        }
        departmentDAO.deleteById(departmentId);
        return "Deleted department id - " + departmentId;
    }
}
