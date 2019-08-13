package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.PlanRepository;
import com.ahnu.ecps.domain.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 授课教案服务
 * @author mxding
 * @date 2019-08-11
 */
@Service
public class PlanService implements IPlanService {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private PlanRepository planRepository;

    @Override
    public void deletePlan(Long id) {
        Plan plan = planRepository.getOne(id);
        planRepository.deleteById(id);
        attachService.deleteAttach(plan.getAttach().getId());
    }

    @Override
    public void addPlan(Plan plan) {
        planRepository.save(plan);
    }

    @Override
    public List<Plan> listPlan() {
        Sort sort = new Sort(Sort.Direction.ASC, "sort");
        return planRepository.findAll(sort);
    }
}
