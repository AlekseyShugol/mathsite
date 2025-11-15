CREATE OR REPLACE FUNCTION update_child_parent_ids()
RETURNS TRIGGER AS $$
BEGIN
    -- Если изменился ID корневого элемента (старый parent_id был 0)
    IF OLD.parent_id = 0 AND NEW.id != OLD.id THEN
        -- Обновляем все дочерние элементы
        UPDATE nodes
        SET parent_id = NEW.id
        WHERE parent_id = OLD.id;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_update_child_parent_ids
    AFTER UPDATE OF id ON nodes
    FOR EACH ROW
    EXECUTE FUNCTION update_child_parent_ids();