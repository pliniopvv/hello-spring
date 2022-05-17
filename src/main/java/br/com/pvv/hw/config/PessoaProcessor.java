package br.com.pvv.hw.config;

import org.springframework.batch.item.ItemProcessor;

import br.com.pvv.hw.entity.Pessoa;

public class PessoaProcessor implements ItemProcessor<Pessoa, Pessoa> {

	@Override
	public Pessoa process(Pessoa item) throws Exception {
		return item;
	}
}
