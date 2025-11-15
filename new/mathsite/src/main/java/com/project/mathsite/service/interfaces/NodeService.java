package com.project.mathsite.service.interfaces;

import com.project.mathsite.dto.request.NodeRequest;
import com.project.mathsite.dto.response.NodeResponse;
import com.project.mathsite.entity.Node;

import java.util.List;


public interface NodeService {

    NodeResponse getNodeById(Long id);

    List<NodeResponse> getAllNodes();

    NodeResponse addNode(NodeRequest nodeRequest);

    NodeResponse updateNode(Long id, NodeRequest nodeRequest);

    List<Node> findByParentId(Long parrentId);

    void deleteNode(Long id);
}
