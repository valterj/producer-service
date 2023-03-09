package br.com.rabbit.producer.services;

import static br.com.rabbit.producer.configs.RabbitMQConfig.EXG_NAME_MARKETPLACE;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import br.com.rabbit.producer.configs.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class StringService {

	private final RabbitTemplate rabbitTemplate;

	public void produce(String message) {
		log.info("Mensagem recebida:" + message);
		rabbitTemplate.convertAndSend(EXG_NAME_MARKETPLACE, RabbitMQConfig.RK_PRODUTO_LOG, message);
	}

}
