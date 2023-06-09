package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> listAllProjects();

    ProjectDTO findByProjectCode(String projectCode);

    void save(ProjectDTO projectDTO);
    void update(ProjectDTO projectDTO);
    void delete(String projectCode);
    void complete(String projectCode);
}
