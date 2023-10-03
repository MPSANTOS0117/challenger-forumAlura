package com.alura.forum.controller;

import com.alura.forum.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TRepository repository;

    @PostMapping("cadastrar")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosTopico dados, UriComponentsBuilder uriBuilder) {
        var topico = new Topico(dados);
        repository.save(topico);

        var uri = uriBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.ok().body(dados);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopico>> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        Page<Topico> page = repository.findTopicosNaoFechados(paginacao);
        Page<DadosListagemTopico> dadosPage = page.map(DadosListagemTopico::new);
        return ResponseEntity.ok(dadosPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @PutMapping("atualizar")
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizacaoTopico dados) {
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
        repository.save(topico);

        return ResponseEntity.ok().body("Atualização concluída");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        topico.setStatus(Status.FECHADO);
        repository.save(topico);

        return ResponseEntity.status(204).build();
    }

}
