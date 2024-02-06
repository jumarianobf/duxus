package br.com.duxus.controller;

import br.com.duxus.controller.dto.ComposicaoTimeDTO;
import br.com.duxus.domain.ComposicaoTime;
import br.com.duxus.service.composicaoTime.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/composicaoTimes")
public class ComposicaoTimeController {

    @Autowired
    private AtualizaComposicaoTimeService atualizaComposicaoTimeService;
    @Autowired
    private BuscaComposicaoTimePorIdService buscaComposicaoTimePorIdService;
    @Autowired
    private DeletaComposicaoTimeService deletaComposicaoTimeService;
    @Autowired
    private ListarComposicaoTimeService listarComposicaoTimeService;
    @Autowired
    private CadastraComposicaoTimeService cadastraComposicaoTimeService;

    @PostMapping
    public void cadastrar(@RequestBody @Valid ComposicaoTimeDTO composicaoTime) {
        cadastraComposicaoTimeService.executar(composicaoTime);
    }

    @GetMapping
    public Page<ComposicaoTime> listar(@PageableDefault(size = 10) Pageable composicaoTimePageable) {
        return listarComposicaoTimeService.executar(composicaoTimePageable);
    }

    @GetMapping("/{id}")
    public ComposicaoTime buscaComposicaoTimePorId(@PathVariable Long id) {
        return buscaComposicaoTimePorIdService.executar(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody @Valid ComposicaoTimeDTO dados) {
        atualizaComposicaoTimeService.executar(id, dados);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        deletaComposicaoTimeService.executar(id);
    }
}
