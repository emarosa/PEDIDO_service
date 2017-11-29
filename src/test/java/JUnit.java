import java.util.*;
import org.junit.*;


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
import br.com.fish.devops.domain.pedido.*;
public class JUnit {
	
	private static List<Pedido> pedidosMock = new ArrayList<Pedido>();
	Pedido pedido = new Pedido();
	
	@Test
	public void addItemPedTest(){
		assertTrue(pedidosMock.add(pedido));
	}
		
	@Test
	public void removeItemPedido(){
		long item = pedido.getId();
		assertFalse(pedido.getItems().remove(item));
	}
	
}
