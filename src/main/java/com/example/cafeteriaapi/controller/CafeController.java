package com.example.cafeteriaapi.controller;

import com.example.cafeteriaapi.DTO.RequestCafe;
import com.example.cafeteriaapi.model.Cafe;
import com.example.cafeteriaapi.repository.CafeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cafe")
public class CafeController {
    @Autowired
    private CafeRepository repository;

    @GetMapping
    public ResponseEntity todosCafes(){
        List<Cafe> cafes = repository.findAll();
        return ResponseEntity.ok(cafes);
    }
    @PostMapping
    public ResponseEntity novoCafe(@RequestBody @Valid RequestCafe cafe){
        Cafe novoCafe = new Cafe(cafe);
        repository.save(novoCafe);
        return ResponseEntity.ok("Café adicionado!");
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity deletarCafe(@RequestBody @Valid RequestCafe cafe){
        Optional<Cafe> optionalCafe = repository.findById(cafe.id());
        if (optionalCafe.isPresent()){
            Cafe cafeDeletar = optionalCafe.get();
            repository.delete(cafeDeletar);
        } else{
            return ResponseEntity.ok("Café não adicionado");
        }

        return  ResponseEntity.ok("Café removido!");
    }

    @PutMapping
    @Transactional
    public  ResponseEntity atualizarCafe(@RequestBody @Valid RequestCafe cafe) {
        Optional<Cafe> optionalCafe = repository.findById(cafe.id());
        if (optionalCafe.isPresent()) {
            Cafe cafeatualizado = optionalCafe.get();
            cafeatualizado.setNome(cafe.nome());
            cafeatualizado.setQuantidade(cafe.quantidade());
            cafeatualizado.setPreco_in_cents(cafe.preco_in_cents());
            return ResponseEntity.ok("Café atualizado");
        } else {
            return ResponseEntity.badRequest().build();


        }
    }

}
