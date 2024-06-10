package edu.cpp.a2RestCrud.dao;

import edu.cpp.a2RestCrud.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    // Injecting EntityManager to interact with the database
    @Autowired
    private EntityManager entityManager;

    // Method to retrieve all departments from the database
    @Override
    public List<Department> findAll() {
        // Creating a query to select all departments
        TypedQuery<Department> q = entityManager.createQuery("Select d from Department d", Department.class);
        // Executing the query and retrieving the list of departments
        List<Department> departments = q.getResultList();
        // Returning the list of departments
        return departments;
    }

    // Method to find a department by its ID
    @Override
    public Department findById(int theId) {
        // Retrieving the department with the specified ID from the database
        Department theDepartment = entityManager.find(Department.class, theId);
        // Returning the department
        return theDepartment;
    }

    // Method to save a new department or update an existing one
    @Override
    @Transactional
    public Department save(Department theDepartment) {
        // Merging the provided department object with the database
        Department dbDepartment = entityManager.merge(theDepartment);
        // Returning the merged department object
        return dbDepartment;
    }

    // Method to delete a department by its ID
    @Override
    @Transactional
    public void deleteById(int theId) {
        // Finding the department with the specified ID in the database
        Department theDepartment = entityManager.find(Department.class, theId);
        // Removing the department from the database
        entityManager.remove(theDepartment);
    }
}
