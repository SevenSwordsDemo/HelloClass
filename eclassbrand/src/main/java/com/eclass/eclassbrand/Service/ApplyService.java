package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.ApplyDAO;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.POJO.Apply;
import com.eclass.eclassbrand.POJO.SelectedCourse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApplyService {
    @Resource
    ApplyDAO applyDAO;

    //查询当日学生安排
    public List<Apply> viewStudentPlan(String schedule){
        List<Apply> applies = applyDAO.findByScheduleAndState("%"+schedule+"%","通过");
        return applies;

    }
}
