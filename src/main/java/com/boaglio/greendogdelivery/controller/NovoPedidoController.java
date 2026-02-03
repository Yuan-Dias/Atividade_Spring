package com.boaglio.greendogdelivery.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.boaglio.greendogdelivery.dto.RespostaDTO;
import com.boaglio.greendogdelivery.model.Cliente;
import com.boaglio.greendogdelivery.model.Item;
import com.boaglio.greendogdelivery.model.Pedido;
import com.boaglio.greendogdelivery.repository.ClienteRepository;
import com.boaglio.greendogdelivery.repository.ItemRepository;

@RestController
public class NovoPedidoController {

    private final ClienteRepository clienteRepository;
    private final ItemRepository itemRepository;

    public NovoPedidoController(ClienteRepository clienteRepository, ItemRepository itemRepository) {
        this.clienteRepository = clienteRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/rest/pedido/novo/{clienteId}/{listaDeItens}")
    public RespostaDTO novo(@PathVariable("clienteId") Long clienteId, 
                            @PathVariable("listaDeItens") String listaDeItens) {
        
        RespostaDTO dto = new RespostaDTO();
        try {
            Cliente c = clienteRepository.findById(clienteId).get();
            String[] listaDeItensID = listaDeItens.split(",");

            Pedido pedido = new Pedido();
            double valorTotal = 0;
            List<Item> itensPedidos = new ArrayList<>();

            for (String itemId : listaDeItensID) {
                Item item = itemRepository.findById(Long.parseLong(itemId)).get();
                itensPedidos.add(item);
                valorTotal += item.getPreco();
            }

            pedido.setItens(itensPedidos);
            pedido.setValorTotal(valorTotal);
            pedido.setData(new Date());
            pedido.setCliente(c);
            c.getPedidos().add(pedido);
            
            this.clienteRepository.save(c);

            Long ultimoPedido = c.getPedidos().get(c.getPedidos().size()-1).getId();
            dto = new RespostaDTO(ultimoPedido, valorTotal, "Pedido efetuado com sucesso");

        } catch (Exception e) {
            dto.setMensagem("Erro: " + e.getMessage());
        }
        return dto;
    }
}