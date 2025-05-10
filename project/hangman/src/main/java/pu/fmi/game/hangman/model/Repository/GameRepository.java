package pu.fmi.game.hangman.model.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.query.spi.Limit;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pu.fmi.game.hangman.model.entity.HangmanGame;
import pu.fmi.game.hangman.model.entity.Status;

public interface GameRepository extends JpaRepository<HangmanGame, Long> {

    // SELECT * FROM HANGMAN_GAME
    // WHERE STATUS = ?
    List<HangmanGame> findByStatus(Status status);

    // TODO: Add query method to find first 10 games ordered by started on date desc
    // Look here for examples: https://docs.spring.io/spring-data/jpa/reference/repositories/query-methods-details.html#repositories.limit-query-result

    List<HangmanGame> findTop10ByOrderByStartedOnDateDesc();

    // в случай, че искаме да връщаме различен брой игри, подредени по startedOnDate. По подразбиране ще са 10
    // тогава в GameService ще се подаде limit на на getAllGames(int limit)
    //List<HangmanGame> findAllByOrderByStartedOnDateDesc(Pageable pageable);



}
