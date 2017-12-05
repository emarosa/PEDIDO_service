import java.util.*;
import java.util.function.ToIntFunction;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.*;

import br.com.fish.devops.domain.pedido.ItemPedido;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import br.com.fish.devops.domain.pedido.Pedido;
import br.com.fish.devops.domain.pedido.StatusPedido;
import br.com.fish.devops.dto.pedido.ItemPedidoDTO;

public class JUnitTest {

	private static List<Pedido> pedidosMock = new ArrayList<Pedido>();
	private Pedido pedido = new Pedido();
	private ItemPedidoDTO itemDTO = new ItemPedidoDTO();

	@Test(expected = RuntimeException.class)
	public void verificaPedidoTest() {
		if (!itemDTO.clientExists()) {
			throw new RuntimeException("O usuario com id: " + itemDTO.getIdCliente() + " não existe");
		}
		assertFalse(itemDTO.clientExists());
	}

	@Test
	public void inserirPedidoTeste() {
		boolean pedidoNovo = true;
		long idCliente = 0;
		
		for (Pedido pedido : pedidosMock) {

			if (pedido.getId() == itemDTO.getIdPedido()) {
				pedido.getItems().add(itemDTO.getItem());

				idCliente = pedido.getIdCliente();

				pedidoNovo = false;
			}
		}
		
		assertTrue(pedidoNovo);
	}
	
	@Test
	public void addPedidoTest(){
		long idCliente;
			Pedido pedido = new Pedido();

			idCliente = itemDTO.getIdCliente();
			pedido.setId(itemDTO.getIdPedido());
			pedido.setDataPedido(new Date());
			pedido.setIdCliente(itemDTO.getIdCliente());
			pedido.getItems().add(itemDTO.getItem());
			pedido.setStatus(StatusPedido.ABERTO);

			pedidosMock.add(pedido);
			
			assertTrue(pedidosMock.contains(pedido));		
	}

	@Test
	public void cancelaPedidoTest() {
		ItemPedido item = new ItemPedido();
		pedidosMock.add(pedido);

		for (Pedido pedido : pedidosMock) {

			if (pedido.getId() == this.pedido.getId()) {

				pedido.setStatus(StatusPedido.CANCELADO);

			}

		}

		assertNotSame("pedido " + this.pedido.getId() + " cancelado", this.pedido.getId(), pedido.getId());
	}

}
