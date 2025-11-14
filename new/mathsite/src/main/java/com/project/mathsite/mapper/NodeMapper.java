package com.project.mathsite.mapper;
import com.project.mathsite.dto.request.NodeRequest;
import com.project.mathsite.dto.response.NodeResponse;
import com.project.mathsite.entity.Node;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface NodeMapper {
    Node RequestToEntity(NodeRequest request);

    NodeRequest EntityToRequest(Node node);

    Node ResponseToEntity(NodeResponse response);

    NodeResponse EntityToResponse(Node node);

    void updateNodeFromRequest(NodeRequest request, @MappingTarget Node node);
}
