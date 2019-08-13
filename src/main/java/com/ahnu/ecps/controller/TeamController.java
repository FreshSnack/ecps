package com.ahnu.ecps.controller;

import com.ahnu.ecps.domain.Attach;
import com.ahnu.ecps.domain.Team;
import com.ahnu.ecps.service.IAttachService;
import com.ahnu.ecps.service.ITeamService;
import com.ahnu.ecps.utils.AjaxReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 教学团队处理器
 * @author mxding
 * @date 2019-08-11
 */
@Controller
public class TeamController {

    @Autowired
    private IAttachService attachService;

    @Autowired
    private ITeamService teamService;

    /**
     * 教学团队
     * @return
     */
    @RequestMapping("/admin/team")
    public String team(Model model) {
        model.addAttribute("pic_list", teamService.listTeam());
        return "admin/team";
    }

    /**
     * 授课教案
     * @return
     */
    @RequestMapping("/admin/teamEdit")
    public String teamEdit(Model model, Long id) {
        model.addAttribute("team", teamService.getTeamById(id));
        return "admin/teamEdit";
    }

    /**
     * 删除教学团队
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/team/delete")
    public AjaxReturn delete(Long id) {
        teamService.deleteTeam(id);
        return AjaxReturn.success();
    }

    /**
     * 保存教学团队
     * @param team
     * @return
     */
    @ResponseBody
    @RequestMapping("/admin/team/save")
    public AjaxReturn save(Team team) {
        teamService.saveTeam(team);
        return AjaxReturn.success();
    }

    /**
     * 上传教学团队图片
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "admin/team/upload", method = RequestMethod.POST)
    public AjaxReturn upload(@RequestParam("file")MultipartFile file) {
        Attach attach = attachService.uploadFile(file);
        Team team = new Team();
        team.setAttach(attach);
        teamService.saveTeam(team);
        return AjaxReturn.success();
    }
}
