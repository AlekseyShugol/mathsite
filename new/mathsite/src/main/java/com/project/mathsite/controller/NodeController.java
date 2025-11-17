package com.project.mathsite.controller;

import com.project.mathsite.dto.request.NodeRequest;
import com.project.mathsite.dto.response.NodeResponse;
import com.project.mathsite.entity.Node;
import com.project.mathsite.service.interfaces.NodeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<NodeResponse> getAllNodes() {
        return nodeService.getAllNodes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NodeResponse addNode(@RequestBody @Valid NodeRequest request) {
        return nodeService.addNode(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public NodeResponse updateNode(@PathVariable Long id, @RequestBody @Valid NodeRequest request) {
        return nodeService.updateNode(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteNode(@PathVariable Long id) {
        nodeService.deleteNode(id);
    }

    @GetMapping("child/{parrentId}")
    public List<Node> getNodeByParrentId(@PathVariable Long parrentId){
        return nodeService.findByParentId(parrentId);
    }
}
