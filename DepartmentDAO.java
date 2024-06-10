package edu.cpp.a2RestCrud.dao;

import java.util.List;
import edu.cpp.a2RestCrud.entity.Department;

public interface DepartmentDAO {
    public abstract List<Department> findAll();
    public abstract Department findById(int id);
    public abstract Department save(Department department);
    public abstract void deleteById(int id);
}
