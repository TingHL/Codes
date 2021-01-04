package com.atguigu.controller;

import com.atguigu.dao.DepartmentDao;
import com.atguigu.dao.EmployeeDao;
import com.atguigu.entities.Department;
import com.atguigu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 快速添加
     * 页面发送的数据是 quickadd?empinfo=empAdmin-admin@qq.com-1-101
     * @param employee
     * @return
     */
    @RequestMapping("/quickadd")
    public String quickAdd(@RequestParam("empinfo") Employee employee){
        System.out.println("将要添加的employee："+employee);
        return "redirect:/emps";
    }

    /**
     * 通过自定义类型的转换器让 string类型 --> Employee对象
     */


    //展示所有员工
    @RequestMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> all=employeeDao.getAll();
        model.addAttribute("emps",all);
        return "list";
    }

    //去员工添加页面，去页面之前查所有部门信息，进行展示
    //再去添加页面
    @RequestMapping("/toaddpage")
    public String toAddPage(Model model){
        Collection<Department> departments= departmentDao.getDepartments();
        model.addAttribute("employee",new Employee());
        model.addAttribute("depts",departments);
        return "add";
    }

    /**
     * 添加员工 保存员工
     * @param employee
     * @return
     */
    @RequestMapping(value="/emp",method = RequestMethod.POST)
    public String addEmp(Employee employee){
        System.out.println("要添加的员工："+employee);
        employeeDao.save(employee);
        //返回列表，直接重定向到查询所有员工的请求
        return "redirect:/emps";
    }

    /**
     * 查询员工
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String getEmp(@PathVariable("id")Integer id,Model model){
        //查出员工信息
        Employee employee=employeeDao.get(id);
        //放在请求域中
        model.addAttribute("employee",employee);
        //查询部门信息放在隐含模型中
        Collection<Department> departments= departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        System.out.println("departments:"+departments);
        return "edit";
    }

    /**
     * 查询员工来到修改页面
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.PUT)
    public String updateEmp(@ModelAttribute("employee") Employee employee){
        System.out.println("要修改的员工："+employee);
        //保存修改二合一功能
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //修改员工页面之前，查询员工的ID信息
    @ModelAttribute
    public void myModelAttribute(@RequestParam(value="id",required = false)Integer id,Model model){
        if(id!=null){
            Employee employee = employeeDao.get(id);
            model.addAttribute("employee",employee);
        }
    }

    /**
     * 删除员工来到员工页面
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }



}
