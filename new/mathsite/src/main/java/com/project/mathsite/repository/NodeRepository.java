package com.project.mathsite.repository;

import com.project.mathsite.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Node,Long> {
}
