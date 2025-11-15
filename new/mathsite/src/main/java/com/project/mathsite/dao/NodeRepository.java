package com.project.mathsite.dao;

import com.project.mathsite.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NodeRepository extends JpaRepository<Node,Long> {
    List<Node> findByParentId(Long parentId);
}
