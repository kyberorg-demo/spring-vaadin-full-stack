package eu.yadev.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import eu.yadev.backend.data.entity.HistoryItem;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
