package com.project.mathsite.controller;

import com.project.mathsite.dto.response.NodeResponse;
import com.project.mathsite.service.interfaces.NodeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/")
@CrossOrigin(origins = "*")
public class NodeController {
    private final NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NodeResponse getNode(@PathVariable Long id){
        return nodeService.getNodeById(id);
    }
}
