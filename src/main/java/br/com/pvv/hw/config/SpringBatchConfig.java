package br.com.pvv.hw.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import br.com.pvv.hw.entity.Pessoa;
import br.com.pvv.hw.repository.PessoaRepository;
import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Autowired
	private PessoaRepository repository;

	@Bean
	public FlatFileItemReader<Pessoa> reader() {
		FlatFileItemReader<Pessoa> itemReader = new FlatFileItemReader<>();
		itemReader.setResource(new FileSystemResource("/home/gangss/Documentos/@/Spring/hello-spring/data.csv"));
		// itemReader.setResource(new FileSystemResource("src/main/resources/data2.csv"));
		itemReader.setResource(new FileSystemResource("src/main/resources/data.csv"));
		itemReader.setName("csvReader");
		itemReader.setLinesToSkip(1);
		itemReader.setLineMapper(new DefaultLineMapper<Pessoa>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setNames("id", "nome", "cidade", "estado", "cep", "aniv", "emprego");
				setDelimiter(";");
			}});
			setFieldSetMapper(new EmployeeFileRowMapper());
		}});
		return itemReader;
	}

	// private LineMapper<Pessoa> lineMapper() {
	// 	DefaultLineMapper<Pessoa> lineMapper = new DefaultLineMapper<>();

	// 	// DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
	// 	// delimitedLineTokenizer.setDelimiter(";");
	// 	// // delimitedLineTokenizer.setDelimiter(",");
		
	// 	// delimitedLineTokenizer.setStrict(false);
	// 	// // delimitedLineTokenizer.setNames("id","firstName","lastName","email","gender","contactNo","country","dob");
	// 	// delimitedLineTokenizer.setNames("id", "nome", "cidade", "estado", "cep", "aniv", "emprego");

	// 	BeanWrapperFieldSetMapper<Pessoa> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
	// 	fieldSetMapper.setTargetType(Pessoa.class);

	// 	lineMapper.setFieldSetMapper(fieldSetMapper);
	// 	lineMapper.setLineTokenizer(delimitedLineTokenizer);

	// 	return lineMapper;
	// }

	@Bean
	public PessoaProcessor processor() {
		return new PessoaProcessor();
	}

	@Bean
	public RepositoryItemWriter<Pessoa> writer() {
		RepositoryItemWriter<Pessoa> writer = new RepositoryItemWriter<>();

		writer.setRepository(repository);
		writer.setMethodName("save");

		return writer;
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("csv-step").<Pessoa, Pessoa>chunk(10).reader(reader()).processor(processor())
				.writer(writer()).build();
	}

	@Bean
	public Job runJob() {
		return jobBuilderFactory.get("importPessoaFaker").flow(step1()).end().build();
	}

}
