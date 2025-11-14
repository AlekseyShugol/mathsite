package com.project.mathsite.mapper;
import com.project.mathsite.dto.request.NodeRequest;
import com.project.mathsite.entity.Node;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NodeMapper {
    Node RequestToEntity(NodeRequest request);
}
