package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.ApplyDAO;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.Modal.Variable;
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
<<<<<<< Updated upstream
//    public List<Apply> viewStudentPlan(String schedule){
//        List<Apply> applies = applyDAO.findByScheduleAndState("%"+schedule+"%","通过");
//        return applies;
//    }
=======
    public List<Apply> viewStudentPlan(String week,String date){
        List<Apply> applies = applyDAO.findByWeekAndDateAndState(week,date,"通过");
        return applies;
    }
>>>>>>> Stashed changes

    //获取申请纪录
    public CommonResult getApply()
    {
        CommonResult result=new CommonResult();
        List<Apply> applies=applyDAO.findByState("待审核");
        if(applies.size()==0)
        {
            result.setStatus(200);
            result.setMsg("暂无申请");
            result.setResult("success");
        }
        else
        {
            result.setStatus(200);
            result.setResult("success");
            result.setMsg("成功获取纪录");
            result.setData(applies);
        }
        return result;
    }
}
