package com.boaglio.greendogdelivery;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.boaglio.greendogdelivery.model.Cliente;
import com.boaglio.greendogdelivery.model.Item;
import com.boaglio.greendogdelivery.model.Pedido;
import com.boaglio.greendogdelivery.repository.ClienteRepository;
import com.boaglio.greendogdelivery.repository.ItemRepository;
import com.boaglio.greendogdelivery.repository.PedidoRepository;

@Component
public class CargaDados implements CommandLineRunner {

    private final ClienteRepository clienteRepository;
    private final ItemRepository itemRepository;
    private final PedidoRepository pedidoRepository;

    public CargaDados(ClienteRepository clienteRepository, ItemRepository itemRepository, PedidoRepository pedidoRepository) {
        this.clienteRepository = clienteRepository;
        this.itemRepository = itemRepository;
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(">>> [SETUP] Iniciando carga de dados no H2 Database...");

        Cliente fernando = new Cliente("Fernando Boaglio", "Sampa");
        Cliente ze = new Cliente("Zé Pequeno", "Cidade de Deus");
        clienteRepository.save(fernando);
        clienteRepository.save(ze);

        Item dog1 = new Item("Green Dog Tradicional", 25.0);
        Item dog2 = new Item("Green Dog Picante", 27.0);
        Item dog3 = new Item("Green Dog Vegan", 30.0);
        itemRepository.save(dog1);
        itemRepository.save(dog2);
        itemRepository.save(dog3);

        List<Item> lista1 = new ArrayList<>();
        lista1.add(dog1);
        lista1.add(dog2);
        Pedido pedido1 = new Pedido(fernando, lista1, dog1.getPreco() + dog2.getPreco());
        fernando.novoPedido(pedido1);
        pedidoRepository.save(pedido1);

        List<Item> lista2 = new ArrayList<>();
        lista2.add(dog3);
        Pedido pedido2 = new Pedido(ze, lista2, dog3.getPreco());
        ze.novoPedido(pedido2);
        pedidoRepository.save(pedido2);

        System.out.println(">>> [SETUP] Carga de dados finalizada com sucesso!");
    }
}