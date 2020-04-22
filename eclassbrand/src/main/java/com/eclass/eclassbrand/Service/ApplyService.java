package com.eclass.eclassbrand.Service;

import com.eclass.eclassbrand.DAO.ApplyDAO;
import com.eclass.eclassbrand.Modal.CommonResult;
import com.eclass.eclassbrand.Modal.Variable;
import com.eclass.eclassbrand.POJO.Apply;
import com.eclass.eclassbrand.POJO.SelectedCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApplyService {
    @Resource
    ApplyDAO applyDAO;

    //查询当日学生安排

//    public List<Apply> viewStudentPlan(String schedule){
//        List<Apply> applies = applyDAO.findByScheduleAndState("%"+schedule+"%","通过");
//        return applies;
//    }

    public List<Apply> viewStudentPlan(int week,String date){
        List<Apply> applies = applyDAO.findByWeekAndDayOfWeekAndState(week,date,"通过");
        return applies;
    }

    //获取申请纪录
    public CommonResult getApply(int page,int size)
    {
        CommonResult result=new CommonResult();
        PageRequest pageRequest=PageRequest.of(page,size);
        Page<Apply> a=applyDAO.findByState("待审核",pageRequest);
        List<Apply> applies=a.getContent();
        System.out.println("ApplySize:"+applies.size());
        for(Apply apply:applies)
            System.out.println("APPPPPP:"+apply.getReason());
        if(applies.size()==0)
        {
            result.setStatus(201);
            result.setMsg("暂无申请");
            result.setResult("success");
        }
        else
        {
            result.setStatus(200);
            result.setResult("success");
            result.setMsg("成功获取纪录");
            result.setLengthOfData(a.getTotalElements());
            result.setData(applies);
        }
        return result;
    }
}
