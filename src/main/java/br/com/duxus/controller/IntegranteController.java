package br.com.duxus.controller;

import br.com.duxus.controller.dto.IntegranteDTO;
import br.com.duxus.domain.Integrante;
import br.com.duxus.domain.Time;
import br.com.duxus.repository.IntegranteRepository;
import br.com.duxus.repository.TimeRepository;
import br.com.duxus.service.apiService.*;
import br.com.duxus.service.integrante.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/integrantes")
public class IntegranteController {

    @Autowired
    private AtualizaIntegranteService atualizaIntegranteService;
    @Autowired
    private BuscaIntegrantePorIdService buscaIntegrantePorIdService;
    @Autowired
    private DeletaIntegranteService deletaIntegranteService;
    @Autowired
    private ListarIntegranteService listarIntegranteService;
    @Autowired
    private CadastraIntegranteService cadastraIntegranteService;
    @Autowired
    private IntegranteRepository integranteRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid IntegranteDTO integrante) {
        cadastraIntegranteService.executar(integrante);
    }

    @GetMapping
    public Page<Integrante> listar(@PageableDefault(size = 10) Pageable integrantePageable) {
        return listarIntegranteService.executar(integrantePageable);
    }

    @GetMapping("/{id}")
    public Integrante buscaIntegrantePorId(@PathVariable Long id) {
        return buscaIntegrantePorIdService.executar(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody @Valid IntegranteDTO dados) {
        atualizaIntegranteService.executar(id, dados);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        deletaIntegranteService.executar(id);
    }
}


