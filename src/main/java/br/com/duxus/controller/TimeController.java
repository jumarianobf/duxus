package br.com.duxus.controller;

import br.com.duxus.controller.dto.TimeDTO;
import br.com.duxus.model.Time;
import br.com.duxus.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private AtualizaTimeService atualizaTimeService;
    @Autowired
    private BuscaTimePorIdService buscaTimePorIdService;
    @Autowired
    private DeletaTimeService deletaTimeService;
    @Autowired
    private ListarTimesService listarTimesService;
    @Autowired
    private CadastraTimeService cadastraTimeService;

    @PostMapping
    public void cadastrar(@RequestBody @Valid TimeDTO time) {
        cadastraTimeService.executar(time);
    }

    @GetMapping
    public Page<Time> listar(@PageableDefault(size = 10) Pageable timePageable) {
        return listarTimesService.executar(timePageable);
    }

    @GetMapping("/{id}")
    public Time buscaTimePorId(@PathVariable Long id) {
        return buscaTimePorIdService.executar(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody @Valid TimeDTO dados) {
        atualizaTimeService.executar(id, dados);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        deletaTimeService.executar(id);
    }
}
