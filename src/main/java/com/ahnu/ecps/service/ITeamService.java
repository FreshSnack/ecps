package com.ahnu.ecps.service;

import com.ahnu.ecps.domain.Team;

import java.util.List;

/**
 * 教学团队服务接口
 * @author mxding
 * @date 2019-08-11
 */
public interface ITeamService {

    /**
     * 根据id获取team
     * @param id
     * @return
     */
    Team getTeamById(Long id);

    /**
     * 删除团队
     * @param id
     */
    void deleteTeam(Long id);

    /**
     * 保存团队
     * @param team
     */
    void saveTeam(Team team);

    /**
     * 获取团队列表
     * @return
     */
    List<Team> listTeam();
}
