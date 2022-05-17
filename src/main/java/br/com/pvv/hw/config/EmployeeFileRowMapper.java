package br.com.pvv.hw.config;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import br.com.pvv.hw.entity.Pessoa;

public class EmployeeFileRowMapper implements FieldSetMapper<Pessoa> {
//id;nome;cidade;estado;cep;aniv;emprego

    @Override
    public Pessoa mapFieldSet(FieldSet fieldSet) throws BindException {
        long id = fieldSet.readLong("id");
        String nome = fieldSet.readString("nome");
        String cidade = fieldSet.readString("cidade");
        String estado = fieldSet.readString("estado");
        String cep = fieldSet.readString("cep");
        String aniv = fieldSet.readString("aniv");
        String emprego = fieldSet.readString("emprego");
        Pessoa p = new Pessoa();
        p.setId(id);
        p.setNome(nome);
        p.setCidade(cidade);
        p.setEstado(estado);
        p.setEmprego(emprego);
        p.setCep(cep);
        p.setAniv(aniv);
        p.setEmprego(emprego);
        return p;
    }

}
