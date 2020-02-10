package com.interns.match.matchbackend.controller;

import java.util.List;
import java.util.Optional;

import com.interns.match.matchbackend.model.dto.UpdateDtoId;
import com.interns.match.matchbackend.model.entity.Player;
import com.interns.match.matchbackend.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PlayerController{

    @Autowired
    private PlayerService playerService;

    @GetMapping(path="/player/all")
    public List<Player> getAllPlayers() {
        return playerService.findAllPlayer();
    }

    @GetMapping(path = "/player/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> findById(@PathVariable(value = "id") int id) throws Exception {
        return ResponseEntity.ok(
        Optional.ofNullable(playerService.findPlayerById(id))
                                        .orElseThrow(() -> new Exception("No Player Found")));
    }

    @PostMapping(path="/player/create")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        return ResponseEntity.ok(playerService.createPlayer(player));
    }

    @RequestMapping(path="/player/deletebyid/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePlayerById(@PathVariable(value = "id") int id) {
        try {
            playerService.deletePlayerById(id);
            return ResponseEntity.ok("200: Deleted Completely");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(path="/player/updatename", method = RequestMethod.PUT)
    public Player updatePlayerByName(@RequestBody UpdateDtoId dto) {
        return playerService.updatePlayerName(dto);
    }

    @RequestMapping(path="/player/updateall", method = RequestMethod.PUT)
    public ResponseEntity<Player> updatePlayerAll(@RequestBody Player player) throws Exception {
        return ResponseEntity.ok(
            Optional.ofNullable(playerService.updatePlayerAll(player))
                    .orElseThrow(() -> new Exception("No Match Found")));
    }
}