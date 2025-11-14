package com.project.mathsite.controller;

import com.project.mathsite.entity.Node;
import com.project.mathsite.service.NodeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/test")
@CrossOrigin(origins = "*")
public class NodeController {
    private final NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

}
