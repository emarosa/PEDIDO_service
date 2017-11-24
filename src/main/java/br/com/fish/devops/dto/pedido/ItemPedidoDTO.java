package br.com.fish.devops.dto.pedido;

import br.com.fish.devops.domain.pedido.ItemPedido;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ItemPedidoDTO {

	private long idPedido;

	private long idCliente;

	private ItemPedido item;

	public long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public ItemPedido getItem() {
		return item;
	}

	public void setItem(ItemPedido item) {
		this.item = item;
	}

	public boolean clientExists(){
		long idCliente = getIdCliente();
		RestTemplate restTemplate = new RestTemplate();
		String url =
				"http://localhost:8080/clienterest/"+idCliente+"/exists/";
		ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.GET, null, Boolean.class);
		Boolean clientExists = response.getBody();
		if(!clientExists){
			return false;
		}
		return true;
	}

}
