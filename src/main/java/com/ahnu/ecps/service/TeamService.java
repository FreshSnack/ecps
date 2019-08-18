package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.TeamRepository;
import com.ahnu.ecps.domain.Plan;
import com.ahnu.ecps.domain.Team;
import com.ahnu.ecps.utils.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 授课教案服务
 * @author mxding
 * @date 2019-08-11
 */
@Service
public class TeamService implements ITeamService {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team getTeamById(Long id) {
        return teamRepository.findById(id).get();
    }

    @Override
    public void deleteTeam(Long id) {
        Team team = teamRepository.getOne(id);
        teamRepository.deleteById(id);
        attachService.deleteAttach(team.getAttach().getId());
    }

    @Override
    public void saveTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public List<Team> listTeam() {
        Sort sort = new Sort(Sort.Direction.ASC, "sort");
        return teamRepository.findAll(sort);
    }

    @Override
    public Date getLastDate() {
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        Page<Team> page = teamRepository.findAll(PageRequest.of(0 , 1, sort));
        if(page != null) {
            List<Team> content = page.getContent();
            if(!SetUtils.isNullList(content)) {
                return content.get(0).getCreateTime();
            }
        }
        return new Date();
    }
}
