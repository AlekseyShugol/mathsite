package com.project.mathsite.service;


import com.project.mathsite.dao.repository.NodeRepository;
import org.springframework.stereotype.Service;

@Service
public class NodeService {
    public final NodeRepository testRepository;


    public NodeService(NodeRepository testRepository) {
        this.testRepository = testRepository;
    }



}
