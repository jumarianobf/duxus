package br.com.duxus.service.apiService;

import br.com.duxus.controller.dto.FuncaoDTO;
import br.com.duxus.controller.dto.FuncoesDTO;
import br.com.duxus.domain.ComposicaoTime;
import br.com.duxus.repository.ComposicaoTimeRepository;
import br.com.duxus.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class FuncaoService {

    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private ComposicaoTimeRepository composicaoTimeRepository;
    @Autowired
    private ValidaDatas validaDatas;

    public FuncaoDTO getFuncaoMaisComum(LocalDate dataInicial, LocalDate dataFinal) {
        List<ComposicaoTime> composicaoDeTimes = getComposicaoDeTimes(dataInicial, dataFinal);
        Map<String, Integer> funcaoMap = getFuncaoMap(composicaoDeTimes);

        String funcao = null;
        int contagem = 0;

        for (Map.Entry<String, Integer> entry : funcaoMap.entrySet()) {
            if (entry.getValue() > contagem) {
                funcao= entry.getKey();
                contagem = entry.getValue();
            }
        }
        return FuncaoDTO
                .builder()
                .funcao(funcao)
                .build();
    }

    public FuncoesDTO getContagemFuncao(LocalDate dataInicial, LocalDate dataFinal) {
        List<ComposicaoTime> composicaoDeTimes = getComposicaoDeTimes(dataInicial, dataFinal);
        Map<String, Integer> funcaoMap = getFuncaoMap(composicaoDeTimes);

        List<FuncaoDTO> funcoes = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : funcaoMap.entrySet()) {
            FuncaoDTO funcao = FuncaoDTO
                    .builder()
                    .funcao(entry.getKey())
                    .contagem(entry.getValue())
                    .build();
            funcoes.add(funcao);
        }
        return FuncoesDTO
                .builder()
                .funcoes(funcoes)
                .build();
    }


    private Map<String, Integer> getFuncaoMap(List<ComposicaoTime> composicaoDeTimes) {
        Map<String, Integer> funcaoMap = new HashMap<>();
        for (ComposicaoTime composicao : composicaoDeTimes) {
            String funcao = composicao.getIntegrante().getFuncao();
            funcaoMap.put(funcao, funcaoMap.getOrDefault(funcao, 0) + 1);
        }
        return funcaoMap;
    }


    private List<ComposicaoTime> getComposicaoDeTimes(LocalDate dataInicial, LocalDate dataFinal) {
        dataInicial = validaDatas.getDataInicial(dataInicial);
        dataFinal = validaDatas.getDataFinal(dataFinal);
        return composicaoTimeRepository.findByTimeDataBetween(dataInicial, dataFinal);
    }
}



