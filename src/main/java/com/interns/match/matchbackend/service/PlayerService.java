package com.interns.match.matchbackend.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.interns.match.matchbackend.model.dto.UpdateDtoId;
import com.interns.match.matchbackend.model.entity.Player;
import com.interns.match.matchbackend.model.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService{

    @Autowired
    public PlayerRepository playerRepository;

    public Player createPlayer(Player player){
        return playerRepository.save(player);
    }

    public List<Player> findAllPlayer(){
        return StreamSupport.stream(playerRepository.findAll().spliterator(), false)
                            .collect(Collectors.toList());
    }

    public Player findPlayerByName(String name){
        return playerRepository.findByName(name);
    }

    public Player findPlayerById(int id){
        return playerRepository.findById(id).get();
    }

    public Player updatePlayerName(UpdateDtoId dtoUpdater){
        Player player = playerRepository.findById(dtoUpdater.getId()).get();
        player.setName(dtoUpdater.getNewName());
        return playerRepository.save(player);
    }

    public Player updatePlayerAll(Player player){
        Player playerFinded = playerRepository.findById(player.getId()).get();
        playerFinded.setName(player.getName());
        playerFinded.setLastName(player.getLastName());
        playerFinded.setCity(player.getCity());
        return playerRepository.save(playerFinded);
    }

    public void deletePlayerById(int id){
        playerRepository.deleteById(id);
    }

}