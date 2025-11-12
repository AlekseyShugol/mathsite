package com.project.mathsite.service;


import com.project.mathsite.entity.Node;
import com.project.mathsite.repository.NodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeService {
    public final NodeRepository nodeRepository;


    public NodeService(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    public List<Node> test(){
        return nodeRepository.findAll();
    }

}
