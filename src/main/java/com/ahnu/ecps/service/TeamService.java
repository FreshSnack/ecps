package com.ahnu.ecps.service;

import com.ahnu.ecps.dao.TeamRepository;
import com.ahnu.ecps.domain.Team;
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
}
