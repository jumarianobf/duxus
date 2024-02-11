package br.com.duxus.controller;

import br.com.duxus.controller.dto.*;
import br.com.duxus.domain.ComposicaoTime;
import br.com.duxus.service.apiService.*;
import br.com.duxus.service.composicaoTime.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/composicao-de-times")
public class ComposicaoDeTimeController {

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
    @Autowired
    private TimeDaDataService timeDaDataService;
    @Autowired
    private IntegrantesMaisUsadoService integrantesMaisUsadoService;
    @Autowired
    private TimeMaisComumService timeMaisComumService;
    @Autowired
    private FuncaoService funcaoService;
    @Autowired
    private FranquiaService franquiaService;

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


    @GetMapping("/integrantes")
    public ResponseEntity<IntegranteNaDataDTO> integrantesNoTimeDaData(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return ResponseEntity.ok(timeDaDataService.executar(data));
    }

    @GetMapping("/integrantes/mais-usado")
    public ResponseEntity<IntegranteMaisUsadoDTO> integranteMaisUsado(
            @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return ResponseEntity.ok(integrantesMaisUsadoService.executar(dataInicial, dataFinal));
    }

    @GetMapping("/integrantes/time-mais-comum")
    public ResponseEntity<IntegranteNaDataDTO> timeMaisComum(
            @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return ResponseEntity.ok(timeMaisComumService.executar(dataInicial, dataFinal));
    }

    @GetMapping("/franquias/mais-comum")
    public ResponseEntity<FranquiaDTO> franquiaMaisFamosa(
            @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        return ResponseEntity.ok(franquiaService.getFranquiaoMaisComum(dataInicial, dataFinal));
    }

    @GetMapping("/franquias/contagem")
    public ResponseEntity<FranquiasDTO> getContagemPorFranquia(
            @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {

        FranquiasDTO contagemPorFranquia = franquiaService.getContagemFranquia(dataInicial, dataFinal);
        if (contagemPorFranquia != null) {
            return ResponseEntity.ok(contagemPorFranquia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/funcoes/mais-comum")
    public ResponseEntity<FuncaoDTO> getFuncaoMaisComum(
            @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        FuncaoDTO funcaoMaisComum = funcaoService.getFuncaoMaisComum(dataInicial, dataFinal);
        System.out.println();
        return ResponseEntity.ok(funcaoMaisComum);
    }

    @GetMapping("/funcoes/contagem")
    public ResponseEntity<FuncoesDTO> getContagemPorFuncao(
            @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        FuncoesDTO contagemPorFuncao = funcaoService.getContagemFuncao(dataInicial, dataFinal);
        if (contagemPorFuncao != null) {
            return ResponseEntity.ok(contagemPorFuncao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
