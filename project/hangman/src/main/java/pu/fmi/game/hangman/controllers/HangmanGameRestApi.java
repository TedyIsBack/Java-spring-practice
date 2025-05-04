package pu.fmi.game.hangman.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pu.fmi.game.hangman.model.entity.HangmanGame;
import pu.fmi.game.hangman.model.service.HangmanGameService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hangman-games")
public class HangmanGameRestApi {

    public final HangmanGameService hangmanGameService;

    public HangmanGameRestApi(HangmanGameService hangmanGameService){
        this.hangmanGameService = hangmanGameService;
    }

    // POST /hangman-games
    @PostMapping
    public HangmanGame storeHangmanGame(){
        return hangmanGameService.startNewGame();
    }

    // PUT /hangman-games/{id}/letter/{guessLetter}
    @PutMapping("/{id}/letter/{guessLetter}")
    public HangmanGame makeGuess(
            @PathVariable Long id,
            @PathVariable Character guessLetter
    ){
        return hangmanGameService.makeGuess(id, guessLetter);
    }

    // GET /hangman-games/{id}
    @GetMapping("/{id}")
    public HangmanGame getGameById(@PathVariable Long id){
        return hangmanGameService.getGameById(id);
    }

    @GetMapping
    public List<HangmanGame> getAllGames(){
        return hangmanGameService.getStoredGamesCollection();
    }

}