package com.project.mathsite.service;


import com.project.mathsite.dao.repository.NodeRepository;
import com.project.mathsite.dto.request.NodeRequest;
import com.project.mathsite.dto.response.NodeResponse;
import com.project.mathsite.exeption.NodeNotFoundException;
import com.project.mathsite.mapper.NodeMapper;
import com.project.mathsite.service.interfaces.NodeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class DefaultNodeService implements NodeService {
    private final NodeRepository nodeRepository;
    private final NodeMapper nodeMapper;

    public DefaultNodeService(NodeRepository nodeRepository, NodeMapper nodeMapper){
        this.nodeRepository = nodeRepository;
        this.nodeMapper = nodeMapper;
    }

    @Override
    public NodeResponse getNodeById(Long id){
        var nodeEntity = nodeRepository.findById(id).orElseThrow(()->new NodeNotFoundException("There is no element with id: "+id));


        return nodeMapper.EntityToResponse(nodeEntity);
    }

    @Override
    public List<NodeResponse> getAllNodes() {
        return List.of();
    }

    @Override
    public NodeResponse addNode(NodeRequest nodeRequest) {
        return null;
    }

    @Override
    public NodeResponse updateNode(Long id, NodeRequest nodeRequest) {
        return null;
    }

    @Override
    public void deleteNode(Long id) {

    }

}
