package com.project.mathsite.service;


import com.project.mathsite.dao.NodeRepository;
import com.project.mathsite.dto.request.NodeRequest;
import com.project.mathsite.dto.response.NodeResponse;
import com.project.mathsite.entity.Node;
import com.project.mathsite.exeption.NodeNotFoundException;
import com.project.mathsite.mapper.NodeMapper;
import com.project.mathsite.service.interfaces.NodeService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Transactional
@Service
public class DefaultNodeService implements NodeService {
    private final NodeRepository repository;
    private final NodeMapper mapper;

    public DefaultNodeService(NodeRepository nodeRepository, NodeMapper nodeMapper){
        this.repository = nodeRepository;
        this.mapper = nodeMapper;
    }

    @Override
    public NodeResponse getNodeById(Long id){
        var nodeEntity = repository.findById(id).orElseThrow(()->new NodeNotFoundException("There is no element with id: "+id));


        return mapper.EntityToResponse(nodeEntity);
    }

    @Override
    public List<NodeResponse> getAllNodes() {
        Iterable<Node> nodes = repository.findAll();
        return StreamSupport.stream(nodes.spliterator(),false).map((mapper::EntityToResponse)).toList();
    }

    @Override
    public NodeResponse addNode(NodeRequest nodeRequest) {
        var nodeEntity = mapper.RequestToEntity(nodeRequest);
        repository.save(nodeEntity);
        return mapper.EntityToResponse(nodeEntity);
    }

    @Override
    public NodeResponse updateNode(Long id, NodeRequest nodeRequest) {
        var existingNode = repository.findById(id).orElseThrow(()->new NodeNotFoundException("There is no element with this id: "+id));
        mapper.updateNodeFromRequest(nodeRequest,existingNode);
        var updatedNode = repository.save(existingNode);
        return mapper.EntityToResponse(updatedNode);
    }

    @Override
    public void deleteNode(Long id) {
        if (!repository.existsById(id)) {
            throw new NodeNotFoundException("There is no element with this id: " + id);
        }

        // Находим все дочерние узлы с parent_id равным удаляемому id
        List<Node> childNodes = repository.findByParentId(id);

        // Удаляем все дочерние узлы
        for (Node child : childNodes) {
            deleteNode(child.getId());
        }

        // Удаляем сам узел
        repository.deleteById(id);
    }

}
