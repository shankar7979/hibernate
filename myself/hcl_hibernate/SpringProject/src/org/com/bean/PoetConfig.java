package org.com.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PoetConfig {

	Poet poet;
    Poem poem;
	
	@Bean(initMethod="init_poet")
	public Poet getPoet() {
		poet = new Poet();
		/*poet.setId(65665);
		poet.setName("hari vansh rai bachchan");
		poet.setLanguage("hindi");
		poet.setState("Uttar Pardesh");*/
		poet.setPoem(poem);
		return poet;
	}
	
	@Bean
	public Poem getPoem() {
    poem=new Poem();
    poem.setPoem_id(76656);
    poem.setPoem_name("madhushala");
    return poem;
	}
	
	
}
