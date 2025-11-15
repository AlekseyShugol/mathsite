package com.project.mathsite.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Check;

import java.util.Objects;

/**
 * Класс-сущность, представляющая узел (папку, файл или ссылку)
 * в иерархической структуре данных.
 *
 * Таблица создаётся автоматически при запуске приложения,
 * если она отсутствует (при включённом spring.jpa.hibernate.ddl-auto=update).
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "nodes")
@Check(constraints = "type IN ('FOLDER', 'FILE', 'LINK')")
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

}
