package com.project.mathsite.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.util.Objects;

/**
 * Класс-сущность, представляющая узел (папку, файл или ссылку)
 * в иерархической структуре данных.
 *
 * Таблица создаётся автоматически при запуске приложения,
 * если она отсутствует (при включённом spring.jpa.hibernate.ddl-auto=update).
 */


@Entity
@Table(name = "nodes")
@Check(constraints = "type IN ('FOLDER', 'FILE', 'LINK')") // ← проверка типов на уровне БД
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    /** Название узла */
    @Column(nullable = false)
    private String name;

    /** Тип: FOLDER / FILE / LINK */
    @Column(length = 128, nullable = false)
    private String type;

    /** ID родителя */
    @Column(name = "parent_id")
    private Long parentId;

    /** URL */
    private String url;

    /** Описание */
    private String description;

    /** Порядок отображения */
    @Column(name = "element_position")
    private Integer elementPosition;
    public Node(){}

    public Node(String name, String type, Long parentId, String url, String description, Integer elementPosition) {
        this.name = name;
        this.type = type;
        this.parentId = parentId;
        this.url = url;
        this.description = description;
        this.elementPosition = elementPosition;
    }

    // --- Геттеры и сеттеры ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Long getParentId() { return parentId; }
    public void setParentId(Long parentId) { this.parentId = parentId; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getElementPosition() { return elementPosition; }
    public void setElementPosition(Integer elementPosition) { this.elementPosition = elementPosition; }
    
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node that = (Node) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", parentId=" + parentId +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", elementPosition=" + elementPosition +
                '}';
    }
}
