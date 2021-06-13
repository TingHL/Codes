package com.atguigu.controller;

import com.atguigu.dao.DepartmentDao;
import com.atguigu.dao.EmployeeDao;
import com.atguigu.entities.Department;
import com.atguigu.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    /**
     * ��������
     * ҳ�淢�͵������� quickadd?empinfo=empAdmin-admin@qq.com-1-101
     * @param employee
     * @return
     */
    @RequestMapping("/quickadd")
    public String quickAdd(@RequestParam("empinfo") Employee employee){
        System.out.println("��Ҫ���ӵ�employee��"+employee);
        return "redirect:/emps";
    }

    /**
     * ͨ���Զ������͵�ת������ string���� --> Employee����
     */


    //չʾ����Ա��
    @RequestMapping("/emps")
    public String getEmps(Model model){
        Collection<Employee> all=employeeDao.getAll();
        //model���ô��䵽ҳ��Ĳ���
        model.addAttribute("emps",all);
        return "list";
    }

    //ȥԱ������ҳ�棬ȥҳ��֮ǰ�����в�����Ϣ������չʾ
    //��ȥ����ҳ��
    @RequestMapping("/toaddpage")
    public String toAddPage(Model model){
        model.addAttribute("employee",new Employee());
        return "add";
    }

    /**
     * ����Ա�� ����Ա��
     * @param employee
     * @return
     */
    @RequestMapping(value="/emp",method = RequestMethod.POST)
    public String addEmp(@Valid Employee employee, BindingResult result,Model model){
        System.out.println("Ҫ���ӵ�Ա����"+employee);
        boolean hasErrors = result.hasErrors();
        Map<String,Object> errorMap=new HashMap<>();
        if(hasErrors){
            System.out.println("��У�����");

            //��ȡ�����ֶεĻ�ȡ����
            List<FieldError> fieldError = result.getFieldErrors();
            for(FieldError fieldError1:fieldError){
                System.out.println("������Ϣ��ʾ��"+ fieldError1.getDefaultMessage());
                System.out.println("������ֶ��ǣ�"+fieldError1.getField());
                System.out.println(fieldError1);
                errorMap.put(fieldError1.getField(),fieldError1.getDefaultMessage());
            }
            model.addAttribute("errorInfo",errorMap);
            return "add";
        }else{
            employeeDao.save(employee);
            //�����б���ֱ���ض��򵽲�ѯ����Ա��������
            return "redirect:/emps";
        }
    }

    /**
     * ��ѯԱ��
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
    public String getEmp(@PathVariable("id")Integer id,Model model){
        //���Ա����Ϣ
        Employee employee=employeeDao.get(id);
        //������������
        model.addAttribute("employee",employee);
        //��ѯ������Ϣ��������ģ����
        Collection<Department> departments= departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        System.out.println("departments:"+departments);
        return "edit";
    }

    /**
     * ��ѯԱ�������޸�ҳ��
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.PUT)
    public String updateEmp(@ModelAttribute("employee") Employee employee){
        System.out.println("Ҫ�޸ĵ�Ա����"+employee);
        //�����޸Ķ���һ����
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //�޸�Ա��ҳ��֮ǰ����ѯԱ����ID��Ϣ
    @ModelAttribute
    public void myModelAttribute(@RequestParam(value="id",required = false)Integer id,Model model){
        if(id!=null){
            Employee employee = employeeDao.get(id);
            model.addAttribute("employee",employee);
        }
        Collection<Department> departments= departmentDao.getDepartments();
        model.addAttribute("depts",departments);
    }

    /**
     * ɾ��Ա������Ա��ҳ��
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}